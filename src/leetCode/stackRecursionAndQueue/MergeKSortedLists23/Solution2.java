package leetCode.stackRecursionAndQueue.MergeKSortedLists23;


/**
 * {@author: gcc}
 * {@Date: 2019/6/28 10:13}
 * 分析：k个链表的归并可以利用归并排序的思想，每次取其中两个归并直到最后合为一个。k个链表每次归并为
 * O(n)，共O(nk)的复杂度TLE。
 *
 * 方法一：用分治的思想，第一次划分将所有链表分k/2组，每次归并都是O(n)，二分之后只需处理lgk次，故时间复杂度O(nlgk)，空间复杂度O(1)。
 *
 */
public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    //有序链表的merge，很关键很重要
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }
}