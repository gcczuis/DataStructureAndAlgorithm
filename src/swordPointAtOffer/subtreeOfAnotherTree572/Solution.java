package swordPointAtOffer.subtreeOfAnotherTree572;


import java.util.LinkedList;
import java.util.Queue;

/**
 * {@author: gcc}
 * {@Date: 2019/6/29 10:02}
 * 这道题的解法是对应于剑指offer上的26题，剑指offer上的题和对应的leetcode上的题有些不一样
 * 思路很简单，层序遍历该树，每一个节点node1都将node1与t做比较，看是否是相同的结构
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null || s == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (sub(node,t)){
                return true;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return false;
    }

    private boolean sub(TreeNode node, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        if (node.val!=node2.val){
            return false;
        }
        return sub(node.right, node2.right) && sub(node.left, node2.left);
    }
}
