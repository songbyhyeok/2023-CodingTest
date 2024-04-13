# Leetcode - 328. Odd Even Linked List
# 홀짝 연결리스트 - <a href="https://leetcode.com/problems/odd-even-linked-list/description" target="_blank">328. Odd Even Linked List</a>

연결 리스트의 노드 구성을 홀수번째, 짝수번째 두 개의 기준으로 분류 및 홀수 번째 다음에 짝수번째가 연결되게 재구성하기.

2 - > 1 -> 3 - > 5 -> 6 -> 4 -> 7  
odd = 2 -> 3 -> 6 -> 7  
even = 1 -> 5 -> 4  
result = odd + even

```java
// 순회하며 홀짝 나누어 재구성 및 합치기
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head ==null)
            return null;

        var odd = head;
        var even = odd.next;
        final var fEven = even;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = fEven;
        
        return head;
    }
}
```