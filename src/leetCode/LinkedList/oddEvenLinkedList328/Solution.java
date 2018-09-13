package leetCode.LinkedList.oddEvenLinkedList328;

/**
 * @author: gcc
 * @Date: 2018/9/11 14:47
 * @Description: 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode nodeToInsert = head;
        ListNode preNodeOfToInsert = head;
        ListNode whereToInsert = head;
        //由于cur的位置在第一次的时候跳两格，后面是要跳一格，所以需要个标志位判断
        boolean flag = true;
        while(cur != null && cur.next != null && cur.next.next != null){

            preNodeOfToInsert = cur.next;
            nodeToInsert = cur.next.next;
            preNodeOfToInsert.next = nodeToInsert.next;
            nodeToInsert.next = whereToInsert.next;
            whereToInsert.next = nodeToInsert;
            whereToInsert = whereToInsert.next;
            if(flag){
                cur = cur.next.next;
                flag = false;
            }
            else{
                cur = cur.next;
            }
            System.out.println(linkedListToString(head)+cur.val);
        }
        return head;
    }

    public static ListNode createLinkedList(int[] arr, int n) {
        if (arr.length < n && n == 0) {
            return null;
        }
        ListNode dummyhead = new ListNode(Integer.MAX_VALUE);
        ListNode cur = dummyhead;
        for (int i = 0; i < n; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return dummyhead.next;
    }

    public static String linkedListToString(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val + " -> ");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        ListNode head = createLinkedList(arr,arr.length);
        head = oddEvenList(head);
       System.out.println(linkedListToString(head));


    }
}
