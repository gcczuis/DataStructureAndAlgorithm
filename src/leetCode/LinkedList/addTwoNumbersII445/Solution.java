package leetCode.LinkedList.addTwoNumbersII445;

import java.util.Stack;

/**
 * @author: gcc
 * @Date: 2018/9/11 18:39
 * @Description: 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
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
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        boolean flag = false;
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int sum = 0;
            if(!stack1.isEmpty()){
                sum += stack1.pop();
            }
            if(!stack2.isEmpty()){
                sum += stack2.pop();
            }
            if(flag){
                sum += 1;
                flag = false;
            }
            if(sum >= 10){
                sum -= 10;
                flag = true;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if(flag){
            cur.next = new ListNode(1);
        }
        return reverseList(dummyHead.next);

    }
    public static ListNode reverseList(ListNode head) {
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
        int[] arr = {7,2,4,3};
        int[] arr2 = {5,6,4};
        ListNode head = createLinkedList(arr,arr.length);
        ListNode head2 = createLinkedList(arr2,arr2.length);
        head = addTwoNumbers(head,head2);
        System.out.println(linkedListToString(head));
    }
}
