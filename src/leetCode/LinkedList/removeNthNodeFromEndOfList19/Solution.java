package leetCode.LinkedList.removeNthNodeFromEndOfList19;

/**
 * {@author: gcc}
 * {@Date: 2019/6/18 11:04}
 * 我们不知道整个链表有多长，所以一般的解决思路是先遍历一遍链表，获得链表长度，再遍历一遍找到要删除的元素
 * 最后将其删除。
 *
 * 如果说能不能只遍历一遍链表解决这个问题呢？
 * 双指针技术
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode l1 = dummyHead;
        ListNode l2 = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            l2 = l2.next;
        }
        while (l2!=null){
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode pre = l1;
        ListNode toDel = l1.next;
        ListNode next = toDel.next;

        pre.next = next;

        return dummyHead.next;
    }
}
