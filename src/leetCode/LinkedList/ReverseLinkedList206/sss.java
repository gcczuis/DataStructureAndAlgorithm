package leetCode.LinkedList.ReverseLinkedList206;

import java.util.LinkedList;
import java.util.Queue;

/**
 * {@author: gcc}
 * {@Date: 2019/6/29 00:42}
 */
public class sss {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root1);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == root2.val){
                if (isSub(node,root2)){
                    return true;
                }
            }
            if (node.left!=null){
                q.offer(node.left);
            }
            if (node.right!=null){
                q.offer(node.right);
            }
        }
        return false;
    }

    private boolean isSub(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null){
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }
        return isSub(root1.left, root2.left) && isSub(root1.right, root2.right);
    }
}