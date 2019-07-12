package swordPointAtOffer.BSTTwoLinkedList36;


/**
 * {@author: gcc}
 * {@Date: 2019/7/2 16:23}
 */
public class Solution {
    public class TreeNode {

        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) {
            return pRootOfTree;
        }
        return findHead(compact(pRootOfTree));
    }

    //整理以node为根节点的树，使得树下的所有节点都按排序规则组成一个双向链表，返回根节点
    private TreeNode compact(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode minNode = findTail(compact(node.left));
        TreeNode maxNode = findHead(compact(node.right));
        node.left = minNode;
        node.right = maxNode;
        if (minNode != null) {
            minNode.right = node;
        }
        if (maxNode != null) {
            maxNode.left = node;
        }
        return node;
    }

    //找到双向链表的头结点
    private TreeNode findHead(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //找到双向链表的尾节点
    private TreeNode findTail(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

}
