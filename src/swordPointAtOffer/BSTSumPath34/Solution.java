package swordPointAtOffer.BSTSumPath34;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@author: gcc}
 * {@Date: 2019/7/2 15:10}
 */
public class Solution {

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return ret;
        }

        find(root, target, new ArrayList<>());

        List<ArrayList<Integer>> collect = ret.stream()
                .sorted((o1, o2) -> o2.size() - o1.size())
                .collect(Collectors.toList());

        ret.clear();
        ret.addAll(collect);

        return ret;
    }

    //从root节点（包括root节点）往下寻找和为target的所有路径，结果暂存在tempRes中
    private void find(TreeNode root, int target, ArrayList<Integer> tempRes) {
        if (isLeaf(root)) {
            if (root.val == target) {
                tempRes.add(target);
                ret.add(new ArrayList<>(tempRes));
                tempRes.remove(tempRes.size() - 1);
            }
            return;
        }
        tempRes.add(root.val);

        if (root.left != null) {
            find(root.left, target - root.val, tempRes);
        }
        if (root.right != null) {
            find(root.right, target - root.val, tempRes);
        }
        tempRes.remove(tempRes.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
