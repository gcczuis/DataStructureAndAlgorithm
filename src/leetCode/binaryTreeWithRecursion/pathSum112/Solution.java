package leetCode.binaryTreeWithRecursion.pathSum112;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 09:46}
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

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumRec(root, sum);
    }

    /*private boolean hasPathSumRec(TreeNode node, int tempSum) {
        //这样写是错误的，要注意是从根节点到“叶子节点”，而node == null && tempSum == 0并不能保证有解
        //因为可能node的父亲节点不是叶子节点。
        if (node == null) {
            return tempSum == 0;
        } else {
            return (hasPathSum(node.left, tempSum - node.val) || hasPathSum(node.right, tempSum - node.val));
        }
    }*/
    private boolean hasPathSumRec(TreeNode node, int tempSum) {
        if (node == null){
            return false;
        }
        if (node.left == null && node.right == null && tempSum == node.val) {
            return true;
        } else {
            return (hasPathSum(node.left, tempSum - node.val) || hasPathSum(node.right, tempSum - node.val));
        }
    }


}
