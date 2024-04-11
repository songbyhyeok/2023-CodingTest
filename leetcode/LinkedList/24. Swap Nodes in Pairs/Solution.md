# 페어의 노드 스왑 - <a href="https://leetcode.com/problems/swap-nodes-in-pairs/description/?source=submission-ac " target="_blank">24\. Swap Nodes in Pairs</a>

주어진 연결리스트의 인접한 두 노드를 모두 교체 후 Head Node 반환하기<br>
**1. 단순 값 교환 방식**  
* 출제자 의도와 벗어난 해결 방식 <br>

**2. iterator 방식**
* 세 가지를 고려할 것
  * 두 인접 노드를 교환했을 때 1번 노드는 3번 노드를, 2번 노드는 1번 노드를 가리키고 있는가? ex 1 -> 2 -> 3 은 1 -> 3 -> 2
  * 연결리스트 노드 제어자는 다음 교환을 위해 어느 위치로 이동해야 하는가?  
    ex if 2 -> 1 -> 3 then while(node.next != null && node.next.next != null)
  * 요구조건 달성 시 Head Node를 가리키는 주소값이 존재하는가?  
    ex if 2 - > 1 -> 3 -> 5 -> 4 then dummy -> 2 -> 1 -> 3 - > 5 -> 4

**3. 재귀 방식**
* 인접 두 노드에서 첫 번째 노드의 next를 재귀 반환 방식을 통해 재구조화하기, 주의할 점은 두 번째 노드의 next를 재귀 이전에 변경한다면 스택 오버플로우 발생 -> if 1 -> 2 -> 3 then if 2 -> 1, then 1.next.next = 1 -> 2 -> 1

```
// 단순 값 교환 방식
public ListNode swapPairs(ListNode head) {
        var node = head;
        while(node != null && node.next != null) {
            final var tempVal = node.val;
            node.val = node.next.val;
            node.next.val = tempVal;

            node = node.next.next;
        }

        return head;
    }

// iterator 반복을 통한 교환
public ListNode swapPairs(ListNode head) {
        final var dummy = new ListNode();
        var node = dummy;
        node.next = head;

        while(node.next != null && node.next.next != null) {
            final var fNode = node.next;
            final var sNode = node.next.next;
            fNode.next = sNode.next;
            sNode.next = fNode;

            // node -> 1 ? 2 -> 1 -> 3            
            node.next = sNode;
            // node -> 2 -> 1 -> 3
            node = sNode.next;
            // node -> 1 -> 3 -> .....
        }

        return dummy.next;
    }

// 재귀 방식을 통한 교환
    public ListNode swapPairs(ListNode head) {        
        while(head != null && head.next != null) {
            final var fNode = head;
            final var sNode = fNode.next;

            // sNode의 다음 노드를 먼저 이어줄 경우 현 구조의 세 번째 노드를 찾을 수 없게 된다.
            fNode.next = swapPairs(sNode.next);
            sNode.next = fNode;

            return sNode;
        }

        return head;
    }
```