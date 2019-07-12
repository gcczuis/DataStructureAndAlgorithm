package swordPointAtOffer.isPostOrder33;

import org.junit.Test;

/**
 * {@author: gcc}
 * {@Date: 2019/7/2 14:38}
 * 给出一个数组序列，判断其是否是一个二分搜索树的后序遍历结果
 * 比如：1,2,3,4,7,3,7,2,5
 * 后序遍历肯定是先遍历左子树，后遍历右子树，最后遍历根节点
 * 根节点是最后一个元素5，那么前几个1,2,3,4肯定是左子树的节点（因为7>5肯定是右子树的），那么7,3,7,2肯定是右子树的节点
 * 我们只需要遍历7,3,7,2看节点是不是都是大于5的就知道是否是二叉搜索树了，显然这一颗树不是
 */
public class Solution {
    public boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int lo, int hi) {
        if (lo >= hi) {
            return true;
        }
        int root = sequence[hi];
        //左子树新的hi
        int h = lo;
        for (; h < hi - lo; h++) {
            if (sequence[h] > root) {
                break;
            }
        }

        //右子树新的lo
        int l = h;
        //验证从h到hi-1是否都是大于root的
        for (; l < hi - lo; l++) {
            if (sequence[l] < root) {
                return false;
            }
        }

        return verify(sequence, lo, h - 1) && verify(sequence, l, hi - 1);
    }

    @Test
    public void test() {
        System.out.println(VerifySequenceOfBST(new int[]{1, 2, 3, 7, 4, 5, 8}));

    }
}
