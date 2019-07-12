package leetCode.stackRecursionAndQueue.binaryTreeRightSideView199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/27 21:09}
 * 层序遍历，思路和102题一样
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

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //container.get(i)就是对应的第ilevel(根节点是第0level)的节点list
        List<List<Integer>> container = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();

        LinkedList<Pair> queue = new LinkedList<>();
        queue.addFirst(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair pair = queue.removeLast();
            int level = pair.level;
            TreeNode node = pair.node;

            //提前初始化
            if (container.size() <= level) {
                container.add(new ArrayList<>());
            }

            container.get(level).add(node.val);
            if (node.left != null) {
                queue.addFirst(new Pair(level + 1, node.left));
            }
            if (node.right != null) {
                queue.addFirst(new Pair(level + 1, node.right));
            }
        }
        for (int i = 0; i < container.size(); i++) {
            List<Integer> list = container.get(i);
            ret.add(list.get(list.size() - 1));
        }
        return ret;
    }
}
