package leetCode.binaryTreeWithRecursion.sameTree100;

/**
 * {@author: gcc}
 * {@Date: 2019/6/19 21:35}
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

    //以p为根节点的子树和以q为根节点的子树是否是same树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else if(p.val != q.val){
            return false;
        }else{//p.val == q.val
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}
