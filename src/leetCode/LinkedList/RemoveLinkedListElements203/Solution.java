package leetCode.LinkedList.RemoveLinkedListElements203;

/**
 * @author: gcc
 * @Date: 2018/9/11 19:12
 * @Description: 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null || (head.val == val && head.next == null)){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = pre.next;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

}
