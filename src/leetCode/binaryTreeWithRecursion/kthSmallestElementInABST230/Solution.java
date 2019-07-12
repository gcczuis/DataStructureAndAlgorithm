package leetCode.binaryTreeWithRecursion.kthSmallestElementInABST230;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 19:44}
 */
public class Solution {
    private int counter;
    private int ret;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ret;
    }

    private void inOrder(TreeNode node,int k){
        if (node == null) {
            return ;
        }
        inOrder(node.left,k);
        counter++;
        if(counter == k){
            ret = node.val;
            //之后没有必要再遍历了
            return ;
        }
        inOrder(node.right,k);
    }
}
