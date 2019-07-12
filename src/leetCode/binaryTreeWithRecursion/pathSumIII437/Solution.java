package leetCode.binaryTreeWithRecursion.pathSumIII437;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 16:21}
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

    //给他一个节点和一个目标值，他返回以这个节点为根的树中，和为目标值的路径总数。
    public int pathSum(TreeNode root, int sum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int pathImLeading = count(root, sum);
        int pathSumLeft = pathSum(root.left, sum);
        int pathSumRight = pathSum(root.right, sum);

        return pathImLeading + pathSumLeft + pathSumRight;

    }

    //给他一个节点和一个目标值，他返回以这个节点为根的树中，能凑出几个以该节点为路径开头，和为目标值的路径总数。
    private int count(TreeNode node, int sum) {
        if (node == null) return 0;
        // 我自己能不能独当一面，作为一条单独的路径呢？
        int isMe = (node.val == sum) ? 1 : 0;
        // 左边的小老弟，你那边能凑几个 sum - node.val 呀？
        int leftBrother = count(node.left, sum - node.val);
        // 右边的小老弟，你那边能凑几个 sum - node.val 呀？
        int rightBrother = count(node.right, sum - node.val);
        return isMe + leftBrother + rightBrother; // 我这能凑这么多个
    }
}
