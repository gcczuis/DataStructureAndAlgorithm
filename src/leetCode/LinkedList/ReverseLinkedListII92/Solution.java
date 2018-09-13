package leetCode.LinkedList.ReverseLinkedListII92;

/**
 * @author: gcc
 * @Date: 2018/9/10 21:11
 * @Description: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。1 ≤ m ≤ n ≤ 链表长度。
 */


class Solution {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode NodeM = null;
        ListNode LastNodeM = null;
        ListNode NodeN = null;
        ListNode nextNodeN = null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        for (int i = 1; i < n + 1; i++) {
            cur = cur.next;
            if (i == m) {
                NodeM = cur;
            } else if (i == m - 1) {
                LastNodeM = cur;
            } else if (i == n) {
                NodeN = cur;
                nextNodeN = cur.next;
                cur.next = null;
            }
        }
        ListNode listNode = reverseList(NodeM);
        NodeM.next = nextNodeN;
        if (m != 1) {
            LastNodeM.next = listNode;
            return head;
        }
        return listNode;


    }


    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;

        ListNode nextNode = cur.next;
        while (cur != null) {
            nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }




  /*  public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 8, 3, 2, 1};
        ListNode node = createLinkedList(arr, 10);
        node = reverseBetween(node, 1, 10);
        System.out.println(linkedListToString(node));

    }*/

}
