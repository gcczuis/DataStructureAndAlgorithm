package leetCode.LinkedList.removeDuplicatesfromSortedList83;


/**
 * @author: gcc
 * @Date: 2018/9/11 10:06
 * @Description:
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
        if(head == null)
            return null;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.val == pre.val){
                pre.next = cur.next;//pre跳过重复的cur
            }else{
                pre = cur;//pre向前进一位
            }
            cur = cur.next;//cur向前进一位
        }
        return head;
    }


}
