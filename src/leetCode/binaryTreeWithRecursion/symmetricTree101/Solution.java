package leetCode.binaryTreeWithRecursion.symmetricTree101;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 08:15}
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricRec(root.left, root.right);
    }

    //left和right这两棵子树是否对称于中心线
    //比较left.val和right.val的值是否相等，如果相等则比较left.left和right.right以及left.right和right.left
    private boolean isSymmetricRec(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isSymmetricRec(left.left, right.right) && isSymmetricRec(left.right, right.left);
        }
    }


}
