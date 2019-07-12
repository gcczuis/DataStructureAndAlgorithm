package leetCode.binaryTreeWithRecursion.lowestCommonAncestorOfABinarySearchTree235;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 16:55}
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode bigNode;
        TreeNode smallNode;
        if (p.val >= q.val) {
            bigNode = p;
            smallNode = q;
        } else {
            bigNode = q;
            smallNode = p;
        }
        /*if ((root.val > smallNode.val && root.val < bigNode.val)
                || (root.val == smallNode.val && root.val < bigNode.val)
                || (root.val == bigNode.val && root.val > smallNode.val)) {*/
        //这个条件等于上面注释的if语句，好好理解上面的句子
        if(root.val>=smallNode.val && root.val <= bigNode.val){
            return root;
        } else if (root.val > bigNode.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < smallNode.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}
