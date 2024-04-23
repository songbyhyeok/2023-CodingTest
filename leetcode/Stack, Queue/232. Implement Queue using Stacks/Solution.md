# 스택을 이용한 큐 구현 - <a href="https://leetcode.com/problems/implement-queue-using-stacks/description/" target="_blank">232. Implement Queue using Stacks</a>

두 개의 스택을 활용하여 큐(Push, Peek, Pop, Empty) 메소드를 구현하기.

### 풀이 과정
**두 개를 쓸 수 밖에 없다.**  
스택을 한 개 사용 시, FIFO 방식으로 제어하려고 할 경우 o(n) 만큼의 비용이 들고 매우 비효율적이다.  
ex 1 -> 2 -> 3 -> 4 -> 5 의 상태에서 첫 번째 1을 가져오려면 1까지 모두 꺼내 1을 반환 후 다시 역순으로 저장시켜 2 -> 3 -> 4 -> 5로 만들어야 한다.  
**두 개 사용 시 고려할 점**
두 개 사용 시 한 개 사용함에 있어 비효율적인 것을 보완할 수 있다. 그렇지만 구현 과정에서 고려 사항들이 생기게 된다.  
- Peek, Pop
  - 우선 두 스택의 용도는 저장과 출력이다. 저장은 삽입 목적만 수행하면 되기 때문에 문제가 되지 않지만, 저장 값을 활용해야 하는 출력은 여러 가지를 고려해야만 한다.
    - 출력의 버퍼가 비어있을 때만 입력의 저장값들을 출력에 전송시킬 수 있다.
      - 3-2-1의 값들을 출력에 전달 후, 다시 '4'를 입력 버퍼에 저장 후에 다시 출력 버퍼에 전송시켰을 때를 생각해 본다면 아마 4-1-2-3 순으로 출력이 될 것이다. 왜냐하면 두 구조는 결국 스택이기 때문이다. 따라서 이를 방지하기 위해 한 번 출력 구조의 데이터가 비어있지 않다면 전부 출력하기 전까진 값을 이동시켜서는 안된다. 
- isEmpty
  - 출력 구조만 비어있으면 되지 않겠나고 생각이 들었었는데 위 Peek, Pop의 메커니즘을 고려하지 않아 문제가 발생했던 부분이었다.  
  -> 출력의 데이터가 3개 들어가 있는 상태에서 바로 하나의 데이터가 입력에 저장될 경우 4개의 데이터를 보유한 상태다. 따라서 두 개의 구조가 모두 비어있어야 하는 것이다.

```java
class MyQueue {
    Deque<Integer> inputS = new ArrayDeque<>();
    Deque<Integer> outputS = new ArrayDeque<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        inputS.push(x);
    }

    private void moveData() {
        if (outputS.isEmpty()) {
            while(!inputS.isEmpty()) {
                outputS.push(inputS.pop());
            }
        }
    }
    
    public int pop() {
        moveData();
        return outputS.pop();
    }
    
    public int peek() {
        moveData();
        return outputS.peek();
    }
    
    public boolean empty() {
        return inputS.isEmpty() && outputS.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```