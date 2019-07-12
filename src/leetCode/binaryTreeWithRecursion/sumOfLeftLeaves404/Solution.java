package leetCode.binaryTreeWithRecursion.sumOfLeftLeaves404;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 11:21}
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

    //这里有个tips，不能用一个全局变量sum代替ret，因为根据递归函数的语义，ret指的是以root为根节点的所有左叶子之和，所以理所当然初始化为0，而不是用sum来累加
    public int sumOfLeftLeaves(TreeNode root) {
        int ret = 0;
        if (root == null || isLeaf(root)) {
            return 0;
        }
        if (root.left != null) {
            if (isLeaf(root.left)){
                ret += root.left.val;
            }else{
                ret += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            ret += sumOfLeftLeaves(root.right);
        }
        return ret;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
