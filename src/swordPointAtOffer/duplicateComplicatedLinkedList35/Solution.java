package swordPointAtOffer.duplicateComplicatedLinkedList35;

import java.util.HashMap;
import java.util.Map;

/**
 * {@author: gcc}
 * {@Date: 2019/7/2 15:32}
 * 两步：
 * 1. 先新建一个链表，复制原链表，但不复制random指针，同时将原链表的node和新建链表的对应node放进map中
 * 2. 遍历map，给新链表赋上random指针
 */
public class Solution {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }


    }

    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        while (pHead == null) {
            return null;
        }

        RandomListNode cur = pHead;
        //虚拟头结点
        RandomListNode newPre = new RandomListNode(-1);
        //用于循环的pre节点
        RandomListNode newPre2 = newPre;


        while (cur != null) {
            newPre2.next = new RandomListNode(cur.label);
            map.put(cur, newPre2.next);
            cur = cur.next;
            newPre2 = newPre2.next;
        }

        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            RandomListNode node1 = entry.getKey();
            RandomListNode node2 = entry.getValue();
            if (node1.random != null) {
                node2.random = map.get(node1.random);
            }
        }

        return map.get(pHead);
    }
}
