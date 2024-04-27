# 원형 큐 디자인 - <a href="https://leetcode.com/problems/design-circular-queue/description/" target="_blank">622. Design Circular Queue</a>

자료구조 원형 큐 구현하기.  
  
**원형 큐란?**  
기존 Queue와 동일하게 FIFO 특성에 따라 입출력이 가능하며, 원 모양의 정형화적인 구조(Ring Buffer)에 따라 앞 부분은 Front 포인터터가 마지막 부분은 Rear 포인터가 가리키면서 현재 원소를 기억 및 원소를 제어할 수 있다.  
  
**링버퍼(Ring Buffer)?**  
원형 모양의 정형화 구조로 이루어져 있고, 입출력 용도의 버퍼 내부에 Node의 head, tail이 각각 앞과 뒤를 담당하며 data를 제어 및 관리하는 것을 말한다.
  
**구현 과정에서의 enQueue와 deQueue**  
enQueue는 삽입 용도의 메소드로서 크기가 꽉 차있지 않다면 rear 변수가 %(모듈로) 연산에 따라 값이 1 증가하거나 혹은 다시 원래의 첫 위치로 돌아가는 원형적인 구조로 되어 있다.  
deQueue는 삭제 용도이며, 원소가 하나라도 존재한다면 front 변수가 모듈로 연산에 따라 값이 1 증가하여 앞 요소를 더이상 관리할 수 없게 만들거나 아니면 다시 원래의 첫 위치로 돌아가는 원형적 구조로 되어 있다.

```java
class MyCircularQueue {
    int q[];
    int len;
    int front, rear;

    public MyCircularQueue(int k) {
        this.q = new int[k];
        this.len = 0;
        this.front = 0;
        this.rear = -1;
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            this.rear = (rear + 1 ) % this.q.length;
            this.q[rear] = value;
            ++this.len;

            return true;
        }

        return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()) {
            this.front = (front + 1) % this.q.length;
            --this.len;

            return true;
        }

        return false;
    }
    
    public int Front() {
        return !(this.isEmpty()) ? this.q[this.front] : -1;
    }
    
    public int Rear() {
        return !(this.isEmpty()) ? this.q[this.rear] : -1;
    }
    
    public boolean isEmpty() {
        return this.len == 0;
    }
    
    public boolean isFull() {
        return this.len == this.q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
```