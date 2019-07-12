package swordPointAtOffer.lastNumInCircle62;

import dataStructure.linkedlist.LinkedList;

/**
 * {@author: gcc}
 * {@Date: 2019/7/4 19:05}
 */
public class Solution {
    class Node{
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public int LastRemaining_Solution(int n, int m) {
        //这句话不应该放上去，因为n是动态改变的，不是固定的
//        m %= n;
        if (n<=0||m<=0){
            return -1;
        }

        Node dummyHead = new Node(1);
        Node pre = dummyHead;
        Node cur = null;
        for (int i = 0; i < n; i++) {
            cur = new Node(i);
            pre.next = cur;
            cur.pre = pre;
            pre = cur;
        }
        cur.next = dummyHead.next;
        dummyHead.next.pre = cur;
        dummyHead.next = null;

        int count = n;
        cur = cur.next;
        while (count!=1){
            for (int i = 0; i < m - 1; i++) {
                cur = cur.next;
            }
            cur = cur.next;
            cur.pre.pre.next = cur;
            cur.pre = cur.pre.pre;
            count --;
        }
        return cur.val;
    }


}
