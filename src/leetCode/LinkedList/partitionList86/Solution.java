package leetCode.LinkedList.partitionList86;

/**
 * @author: gcc
 * @Date: 2018/9/11 10:30
 * @Description: 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * 思路：找到第一个比x大的元素4，然后再往后找到第一个比x小的数2，再将2插到4之前，知道找不到第一个比x小的数为止
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {

        ListNode cur = head;
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        dummyHead.next = head;
        //下一个比x小的节点的前一个节点
        ListNode nextBiggerThanX = head;
        while(cur != null){
            if(cur.val >= x){
                //找到第一个比x小的节点的前一个节点
                while(nextBiggerThanX.next != null && nextBiggerThanX.next.val >= x){
                    nextBiggerThanX = nextBiggerThanX.next;
                }
                //如果为空说明已经partition，可以跳出循环了
                if(nextBiggerThanX.next == null) {
                    break;
                }
                else {
                    //进行插入元素和删除元素的操作
                    ListNode next1 = nextBiggerThanX.next.next;
                    ListNode next2 = cur;
                    pre.next = nextBiggerThanX.next;
                    pre.next.next = next2;
                    nextBiggerThanX.next = next1;
                }
            }
            else{
                //如果一直比x小则不断往前遍历
                cur = cur.next;
                nextBiggerThanX = cur;
            }
            pre = pre.next;
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

    public static void main(String[] args){
        int[] arr = {1,4,3,2,5,2};
        ListNode head = createLinkedList(arr,arr.length);
        head = partition(head, 3);
        System.out.println(linkedListToString(head));


    }
}
