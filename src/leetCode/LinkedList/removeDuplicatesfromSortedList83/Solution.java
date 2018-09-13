package leetCode.LinkedList.removeDuplicatesfromSortedList83;

import java.util.HashSet;

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
        if(head == null || head.next == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        ListNode cur = head;
        while(cur != null){
            if(set.contains(cur.val)){
                pre.next = cur.next;
                cur = cur.next;
            }
            if(cur != null){
                set.add(cur.val);
                cur = cur.next;
            }
        }
        return head;
    }



}
