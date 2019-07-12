package leetCode.LinkedList.addTwoNumbers2;

/**
 * @author: gcc
 * @Date: 2018/9/11 16:05
 * @Description: 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        //有没有进位的标志位
        boolean flag = false;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l1 != null || l2 != null){
            int sum = 0;

            if(l1 != null && l2 != null){

                sum = flag ? l1.val + l2.val + 1 : l1.val + l2.val;
                if(sum >= 10){
                    sum -= 10;
                    flag = true;
                }
                else{
                    flag = false;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1 != null && l2 == null){
                sum = flag ? l1.val + 1 : l1.val;
                if(sum >= 10){
                    sum -= 10;
                    flag = true;
                }
                else{
                    flag = false;
                }
                l1 = l1.next;
            }
            else if(l1 == null && l2 != null){
                sum = flag ? l2.val + 1 : l2.val;
                if(sum >= 10){
                    sum -= 10;
                    flag = true;
                }
                else{
                    flag = false;
                }
                l2 = l2.next;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        //如果两个链表没有元素，但是进位存在的话还得加个1
        if(flag){
            cur.next = new ListNode(1);
        }
        return dummyHead.next;

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
    public static String linkedListToString2(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val + " ");
            cur = cur.next;
        }
        sb.toString().substring(0,sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args){
        int[] arr = {2,4,3};
        int[] arr2 = {5,6,4};
        ListNode head = createLinkedList(arr,arr.length);
        ListNode head2 = createLinkedList(arr2,arr2.length);
        head = addTwoNumbers(head,head2);
        System.out.println(linkedListToString(head));
    }
}

