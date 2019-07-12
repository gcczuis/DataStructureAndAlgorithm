package leetCode.binaryTreeWithRecursion.binaryTreePaths257;

import java.util.ArrayList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 14:38}
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

    //
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        if(isLeaf(root)){
            ret.add(root.val+"");
            return ret;
        }
        List<String> strings = binaryTreePaths(root.left);
        for (int i = 0; i < strings.size(); i++) {
            ret.add(root.val+"->"+strings.get(i));
        }
        List<String> strings2 = binaryTreePaths(root.right);
        for (int i = 0; i < strings2.size(); i++) {
            ret.add(root.val+"->"+strings2.get(i));
        }

        return ret;
    }


    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
