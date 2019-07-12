package leetCode.LinkedList.rotateList61;

/**
 * {@author: gcc}
 * {@Date: 2019/6/18 11:16}
 * 版本1，缺陷：每次找pretail节点都需要遍历下链表时间复杂度太高O(n^2)
 */
public class Solution1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        //建模发现不需要pre节点，所以不需要虚拟头节点
        ListNode pretail = head;
        ListNode tail = null;
        //初始化pretail节点和tail节点
        pretail = findPretail(head);
        tail = pretail.next;

        for (int i = 0; i < k; i++) {
            pretail.next = null;
            tail.next = head;

            head = tail;
            tail = pretail;
            pretail = findPretail(head);
        }
        return head;

    }

    private ListNode findPretail(ListNode head){
        while (head.next.next!=null){
            head = head.next;
        }
        return head;
    }
}
