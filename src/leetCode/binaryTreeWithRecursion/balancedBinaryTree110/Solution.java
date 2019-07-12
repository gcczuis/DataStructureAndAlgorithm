package leetCode.binaryTreeWithRecursion.balancedBinaryTree110;

import org.junit.Test;

/**
 * {@author: gcc}
 * {@Date: 2019/6/20 08:40}
 * 这道题要好好看看滴
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(heightOfNode(root.left) - heightOfNode(root.right)) <= 1) {

            return (isBalanced(root.left) && isBalanced(root.right));
        } else {//Math.abs(heightOfNode(root.left)-heightOfNode(root.right)) > 1
            return false;
        }
    }

    private int heightOfNode(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Integer.max(heightOfNode(node.left), heightOfNode(node.right));
        }
    }

    /*@Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(4);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;

        treeNode4.left = treeNode6;
        treeNode6.left = treeNode7;

        System.out.println(heightOfNode(treeNode2));
        System.out.println(heightOfNode(treeNode3));
        System.out.println(isBalanced(treeNode1));

    }*/

    @Test
    public void test(){
        int a = 10;
        System.out.println(a&=-a);

    }
}
