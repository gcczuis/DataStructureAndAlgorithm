package leetCode.LinkedList.rotateList61;

import org.junit.Test;

/**
 * {@author: gcc}
 * {@Date: 2019/6/18 11:16}
 * 版本2:
 * - 注意k值和链表长度n之间的关系，要注意到如果k是n的倍数的话，最后结果还是原链表
 */
public class Solution2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //建模发现不需要pre节点，所以不需要虚拟头节点
        ListNode pretail = head;
        ListNode tail = null;
        int length = 0;
        while (pretail != null) {
            length++;
            pretail = pretail.next;
        }

        k = k % length;
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

    private ListNode findPretail(ListNode head) {
        while (head.next.next != null) {
            head = head.next;
        }
        return head;
    }

    @Test
    public void test1(){
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        rotateRight(listNode0,4);
    }
}
