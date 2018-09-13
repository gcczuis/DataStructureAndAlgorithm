package leetCode.LinkedList.ReverseLinkedList206;


/**
 * @author: gcc
 * @Date: 2018/9/10 21:19
 * @Description: 反转一个单链表，不能使用栈这些数据结构，只是将指针指向改变，通过保存前一个node和后一个node迭代翻转
 */
public class Solution {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;

        ListNode nextNode = cur.next;
        while(cur != null){
            nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }
}
