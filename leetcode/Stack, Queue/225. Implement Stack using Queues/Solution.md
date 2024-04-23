# 큐를 이용한 스택 구현 - <a href="https://leetcode.com/problems/implement-stack-using-queues/description/" target="_blank">225. Implement Stack using Queues</a>

큐가 제공하는 연산자들을 활용해서 스택을 구현하기.

```java
// LIFO를 활용한 괄호 일치 여부 판별
class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        queue.offer(x);
        for(int i = 1; i < queue.size(); i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```