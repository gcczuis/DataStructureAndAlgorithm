package leetCode.dynamicProgramming.houseRobberIII337;
/**
 * {@author: gcc}
 * {@Date: 2019/6/23 17:18}
 * 状态：考虑根节点root及其子节点，求最大收益
 * DP(root) = max{money(root)+DP(root.left.left)+DP(root.left.right)+DP(root.right.left)++DP(root.right.right),DP(root.left)+DP(root.right)}
 *
 * 这一题不是动态规划，因为没有重叠子问题，树是发散下去的
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

    public int rob(TreeNode root) {
        int ret;
        if (root == null){
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode lleft = null,lright = null,rleft = null,rright = null;
        if (root.left!=null){
            lleft = left.left;
            rleft = left.right;
        }
        if (root.right!=null){
            lright = right.left;
            rright = right.right;
        }
        return Math.max(root.val+rob(lleft)+rob(lright)+rob(rleft)+rob(rright),rob(left)+rob(right));

    }
}
