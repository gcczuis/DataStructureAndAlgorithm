package leetCode.binaryTreeWithRecursion.sumRootToLeafNumbers129;

import java.util.ArrayList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 16:02}
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

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        List<String> ret = sumNum(root);
        for (int i = 0; i < ret.size(); i++) {
            sum += Integer.parseInt(ret.get(i));
        }
        return sum;
    }

    //如果树为1,2,3,4则返回以node为根节点到叶子节点所有组成的字符串"124","13"...
    private List<String> sumNum(TreeNode node) {
        ArrayList<String> ret = new ArrayList<>();
        if (node == null) {
            return ret;
        }
        if (isLeaf(node)) {
            ret.add(node.val + "");
            return ret;
        }
        List<String> strings = sumNum(node.left);
        for (int i = 0; i < strings.size(); i++) {
            ret.add(node.val + "" + strings.get(i));
        }
        List<String> strings2 = sumNum(node.right);
        for (int i = 0; i < strings2.size(); i++) {
            ret.add(node.val + "" + strings2.get(i));
        }

        return ret;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
