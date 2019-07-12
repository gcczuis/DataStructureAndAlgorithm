package swordPointAtOffer.subtreeOfAnotherTree572;


import java.util.LinkedList;
import java.util.Queue;

/**
 * {@author: gcc}
 * {@Date: 2019/6/29 10:02}
 * 这道题的解法是对应于leetcode上572号问题，主要和剑指offer上的题的区别在于{#sub()}函数中第一个
 * 判断条件不同
 */
public class SolutionOnLeetCode {
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
        if (node2 == null && node == null) {
            return true;
        }
        if (node == null || node2 == null) {
            return false;
        }
        if (node.val!=node2.val){
            return false;
        }
        return sub(node.right, node2.right) && sub(node.left, node2.left);
    }
}
