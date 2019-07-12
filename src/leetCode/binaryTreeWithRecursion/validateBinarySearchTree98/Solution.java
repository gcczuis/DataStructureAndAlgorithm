package leetCode.binaryTreeWithRecursion.validateBinarySearchTree98;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 17:14}
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


    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return root.val > findRightValueOfNode(root.left) && root.val < findLeftValueOfNode(root.right) && isValidBST(root.left) && isValidBST(root.right);
        } else if (root.right == null && root.left != null) {
            return root.val > findRightValueOfNode(root.left) && isValidBST(root.left);
        } else {//root.right != null && root.left == null
            return root.val < findLeftValueOfNode(root.right) && isValidBST(root.right);
        }

    }

    //找到以node为根节点的树的最大值(最左边的元素)
    private int findLeftValueOfNode(TreeNode node){
        if (node.left == null) {
            return node.val;
        }
        return findLeftValueOfNode(node.left);
    }
    //找到以node为根节点的树的最小值(最右边的元素)
    private int findRightValueOfNode(TreeNode node){
        if (node.right == null) {
            return node.val;
        }
        return findRightValueOfNode(node.right);

    }

    /*public class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null) return true;
            if (root.val >= maxVal || root.val <= minVal) return false;
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
        }
    }*/
}
