package leetCode.binaryTreeWithRecursion.maximumDepthOfBinaryTree104;

/**
 * {@author: gcc}
 * {@Date: 2019/6/19 21:05}
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

    //返回以root为根节点的二叉树的最大深度，root为null则深度为0
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        return 1 + Integer.max(maxDepth(root.right),maxDepth(root.left));

    }

}
