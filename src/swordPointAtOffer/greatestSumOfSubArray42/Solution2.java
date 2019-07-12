package swordPointAtOffer.greatestSumOfSubArray42;

import java.util.stream.IntStream;

/**
 * {@author: gcc}
 * {@Date: 2019/7/10 19:41}
 * 使用动态规划解题
 * 状态定义：以Data[i]结尾的子数组的最大和为f(i)
 * 状态转移方程：
 * f(i) = Data[i]  if f(i-1)<=0
 * = Data[i]  if f(i-1)>0
 */
public class Solution2 {
    public int FindGreatestSumOfSubArray(int[] array) {

        int[] memo = new int[array.length];
        memo[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (memo[i - 1] <= 0) {
                memo[i] = array[i];
            } else {
                memo[i] = array[i] + memo[i - 1];
            }
        }

        int ret = IntStream.of(memo).max().getAsInt();
        return ret;
    }
}
