package leetCode.LinkedList.ReverseLinkedList206;



import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: gcc
 * @Date: 2018/9/10 21:19
 * @Description: 反转一个单链表，不能使用栈这些数据结构，只是将指针指向改变，通过保存前一个node和后一个node迭代翻转
 * 注意点：
 * 1. 需要三个指针来穿针引线
 * 2. 一开始pre=null,cur=head,head要先翻转指向null，不能pre = head,cur = head.next,这样是错误的会造成循环链表
 */
public class Solution {
    private Queue q = new LinkedList();

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
