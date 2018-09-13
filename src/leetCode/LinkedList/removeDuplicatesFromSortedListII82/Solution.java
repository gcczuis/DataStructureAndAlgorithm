package leetCode.LinkedList.removeDuplicatesFromSortedListII82;

/**
 * @author: gcc
 * @Date: 2018/9/11 19:25
 * @Description: 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode base = head;
        ListNode cur = base.next;
        boolean isRepeated = false;
        while (cur != null) {
            while (cur != null && cur.val == base.val) {
                isRepeated = true;
                cur = cur.next;
            }
            if (isRepeated) {
                pre.next = cur;
                base = pre.next;
                isRepeated = false;
            } else {
                pre = base;
                base = cur;
            }
            if (cur != null) {
                cur = cur.next;
            }

        }
        return dummyHead.next;


    }

}
