// dummy 방식으로 값 복사 방식으로 접근한 병합 알고리즘 -> 개선 필요 
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        
        ListNode answerNode = new ListNode();
        ListNode nextNode = answerNode;

        while(list1 != null || list2 != null) {
            if (list1 == null) {
                nextNode.val = list2.val;
                list2 = list2.next;
            } else if (list2 == null) {
                nextNode.val = list1.val;
                list1 = list1.next;
            } else {
                if (list1.val <= list2.val) {
                    nextNode.val = list1.val;
                    list1 = list1.next;
                } else {
                    nextNode.val = list2.val;
                    list2 = list2.next;
                }
            }

            if ( !(list1 == null && list2 == null) )
                nextNode = nextNode.next = new ListNode();
        }

        return answerNode;
    }