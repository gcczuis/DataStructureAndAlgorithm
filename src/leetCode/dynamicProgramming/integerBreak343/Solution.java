package leetCode.dynamicProgramming.integerBreak343;

import org.junit.Test;

/**
 * @author: gcc
 * @Date: 2018/9/12 20:16
 * @Description: 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 思路:动态规划:
 *              状态：dp(k)指k这个正整数拆分后的最大乘积
 *              状态转移方程：dp[i] = max(dp[i], max(j, dp[j]) * max(i - j, dp(i - j))) for 1<=i<=n-1
 *              思路：假设dp[i] = max{j * (i - j)} for 1<=j<=i-1,但是由于对i进行拆分得到的最大乘积可能不是由仅仅拆分成
 *                   2个数得到的，所以对这两个数j和i-j都要进行max(j, dp[j])和max(i - j, dp(i - j))操作
 */
public class Solution {
    private int[] dp;
    public int integerBreak(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        dp = new int[n + 1];
        return integerBreakDP(n);

    }
    private int integerBreakDP(int n) {
        if(dp[n] != 0){
            return dp[n];
        }

        for (int i = 1; i < n; i++) {
            dp[n] = Math.max(dp[n], Math.max(i,integerBreakDP(i)) * Math.max(n - i, integerBreakDP(n - i)));
        }
        return dp[n];
    }
    @Test
    public void test(){

        System.out.println(integerBreak(10));

    }



}
