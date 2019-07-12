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
        ListNode dummyHead = new ListNode(0);//保证算法范围包括头结点
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = cur.next;

        for (int i = 0; i < n - m; i++) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummyHead.next;

    }
/*
    public static void main(Solution[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 8, 3, 2, 1};
        ListNode node = createLinkedList(arr, 10);
        node = reverseBetween(node, 3, 7);
        System.out.println(linkedListToString(node));

    }*/

}
