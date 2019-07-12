package swordPointAtOffer.OneNumberInTwoBinary15;

/**
 * {@author: gcc}
 * {@Date: 2019/6/27 15:30}
 * 问题描述：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * flag右移出整形范围后就溢出了，变为0，作为循环终止条件
 */
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag!=0) {
            if ((flag & n)!=0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}