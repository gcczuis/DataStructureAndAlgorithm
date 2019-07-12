package leetCode.LinkedList.mergeTwoSortedLists21;

/**
 * @author: gcc
 * @Date: 2018/9/11 19:57
 * @Description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                while (cur2 != null) {
                    cur.next = new ListNode(cur2.val);
                    cur2 = cur2.next;
                    cur = cur.next;
                }
            } else if (cur2 == null) {
                while (cur1 != null) {
                    cur.next = new ListNode(cur1.val);
                    cur1 = cur1.next;
                    cur = cur.next;
                }
            } else {
                if (cur1.val > cur2.val) {
                    cur.next = new ListNode(cur2.val);
                    cur2 = cur2.next;
                }else{
                    cur.next = new ListNode(cur1.val);
                    cur1 = cur1.next;
                }
                cur = cur.next;
            }
        }
        return dummyHead.next;

    }

}
