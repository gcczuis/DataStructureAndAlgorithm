package leetCode.binaryTreeWithRecursion.countCompleteTreeNodes222;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 08:34}
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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }
}
