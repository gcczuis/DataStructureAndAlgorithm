package leetCode.LinkedList.swapNodesInPairs24;

/**
 * {@author: gcc}
 * {@Date: 2019/6/17 22:04}
 */

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null) {
            first.next = second.next;
            pre.next = second;
            second.next = first;

            pre = first;
            first = first.next;
            if(first!=null){
                second = first.next;
            }
        }
        return dummyHead.next;
    }
}
