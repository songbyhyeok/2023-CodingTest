import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverse(final ListNode head) {
        ListNode prev = null, node = head;
        while(node != null) {
            final ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    private BigInteger toBigInteger(ListNode node) {
        String val = "";

        while(node != null) {
            val += node.val;
            node = node.next;
        }

        return new BigInteger(val);
    }

    private ListNode toReversedNode(BigInteger val) {
        ListNode prev = null;
        
        for(char c : String.valueOf(val).toCharArray()) {
            final ListNode node = new ListNode(Character.getNumericValue(c));
            node.next = prev;
            prev = node;
        }

        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode reversedL1 = reverse(l1);
        final ListNode reversedL2 = reverse(l2);
        final BigInteger total = toBigInteger(reversedL1).add(toBigInteger(reversedL2));
        return toReversedNode(total);
    }
}