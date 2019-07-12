package leetCode.stackRecursionAndQueue.binaryTreeLevelOrderTraversal102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/27 20:04}
 * 利用队列来进行对二叉树的层序遍历
 *
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

    class Pair {
        int level;
        TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //ret.get(i)就是对应的第ilevel(根节点是第0level)的节点list
        List<List<Integer>> ret = new ArrayList<>();

        LinkedList<Pair> queue = new LinkedList<>();
        queue.addFirst(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair pair = queue.removeLast();
            int level = pair.level;
            TreeNode node = pair.node;

            //提前初始化
            if (ret.size() <= level) {
                ret.add(new ArrayList<>());
            }

            ret.get(level).add(node.val);
            if (node.left != null) {
                queue.addFirst(new Pair(level + 1, node.left));
            }
            if (node.right != null) {
                queue.addFirst(new Pair(level + 1, node.right));
            }
        }
        return ret;

    }


}
