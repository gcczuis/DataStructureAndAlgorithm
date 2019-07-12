package leetCode.binaryTreeWithRecursion.invertBinaryTree226;

/**
 * {@author: gcc}
 * {@Date: 2019/6/19 21:26}
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
    //just invert
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        TreeNode newRight = invertTree(root.left);
        TreeNode newLeft = invertTree(root.right);

        root.left = newLeft;
        root.right = newRight;

        return root;
    }
}
