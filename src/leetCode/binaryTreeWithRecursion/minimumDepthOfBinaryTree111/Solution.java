package leetCode.binaryTreeWithRecursion.minimumDepthOfBinaryTree111;

/**
 * {@author: gcc}
 * {@Date: 2019/6/19 21:11}
 * 注意这边有个陷阱：题目是说从根节点到叶子节点最短，如果给了1->2,题解应该是2而不是1
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

    /*//返回以root为根节点的二叉树的最小深度，root为null则深度为0
    //这个代码在1->2这个测试用例下是失败的，为什么失败呢，因为题目说是从根节点到"叶子节点",根节点不是叶子节点，观察下面正确代码：最重要的是明确函数定义，确定递归模型
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null || root.right != null)
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        return 0;
    }*/
    //返回以root为根节点的二叉树的最小深度，root为null则深度为0
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null)
            return minDepth(root.right) + 1;
        else if (root.right==null)
            return minDepth(root.left) + 1;
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
