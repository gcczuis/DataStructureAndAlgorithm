package leetCode.dynamicProgramming.integerBreak343;

import org.junit.Test;

/**
 * @author: gcc
 * @Date: 2018/9/12 20:16
 * @Description: 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * <p>
 * 思路:动态规划:
 * 状态：dp(k)指k这个正整数拆分为至少两份后的最大乘积
 * 状态转移方程：dp[n] = max(i*n-i, i * dp(i - j))) for 1<=i<=n-1
 * 因为n肯定会拆成两份或以上，所以其中一份的值肯定是从1到n-1的，我们只需要把握这一份值就行了！！
 */
public class Solution {
    private int[] dp;

    public int integerBreak(int n) {
        dp = new int[n + 1];
        return integerBreakDP(n);
    }

    private int max3(int res, int i, int i1) {
        return Math.max(Math.max(res, i), i1);
    }

    //将n分割成至少2部分，可以获得的最大乘积
    private int integerBreakDP(int n) {
        //无法分割，直接返回1
        if (n == 1) {
            return 1;
        }
        if (dp[n] == 0) {
            int res = -1;
            for (int i = 1; i < n; i++) {
                res = max3(res, i * (n - i), i * integerBreakDP(n - i));
            }
            dp[n] = res;
        }
        return dp[n];
    }
}
