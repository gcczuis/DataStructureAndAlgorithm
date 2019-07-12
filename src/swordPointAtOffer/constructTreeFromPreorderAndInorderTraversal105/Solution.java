package swordPointAtOffer.constructTreeFromPreorderAndInorderTraversal105;

import org.junit.Test;

/**
 * {@author: gcc}
 * {@Date: 2019/6/27 09:00}
 * 剑指offer的第七题
 * 看题目解释就好了
 * 画出分析图
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    //从preorder的[prelo,prehi]范围和inorder的[inlo,inhi]范围中生成一颗二叉树，并返回其根节点
    private TreeNode build(int[] preorder, int[] inorder, int prelo, int prehi, int inlo, int inhi) {

        assert prehi - prelo == inhi - inlo;
        if (prehi == prelo) {
            return new TreeNode(preorder[prehi]);
        }
        if (prelo > prehi || inlo > inhi) {
            return null;
        }

        int rootVal = preorder[prelo];
        TreeNode root = new TreeNode(rootVal);
        int index = inlo;
        for (; index <= inhi; index++) {
            if (inorder[index] == rootVal)
                break;
        }
        int preNum = index - inlo;
        root.left = build(preorder, inorder, prelo + 1, prelo + preNum, inlo, index - 1);
        root.right = build(preorder, inorder, prelo + preNum + 1, prehi, index + 1, inhi);

        return root;
    }

}
