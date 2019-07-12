package leetCode.stackRecursionAndQueue.MergeKSortedLists23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * {@author: gcc}
 * {@Date: 2019/6/28 10:13}
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            return null;
        }
    }

    //利用最小堆构成的优先队列，首先将每个链表的第一个元素加入队列，每次取出队首元素后，将相应链表的下一个元素加入队列，循环此操作直到队列为空。由于k个链表是有序的，所以每个链表的元素也是按从小到大进入队列，故队列中始终存放当前k个最小元素。每个元素入队一次O(kn)，每次插入新元素后需调整O(lgk)。故时间复杂度O(kn * lgk)，空间复杂度O(k)。
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}