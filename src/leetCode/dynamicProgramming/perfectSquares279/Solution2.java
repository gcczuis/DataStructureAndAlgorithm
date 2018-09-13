package leetCode.dynamicProgramming.perfectSquares279;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: gcc
 * @Date: 2018/9/13 10:24
 * @Description: 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 思路: 和343题思路类似，
 *       状态：dp(k) = 能组成k的最小完全平方数
 *       状态转移方程：dp(k) = max{dp(k),dp(i)+dp(k-i)} for 1<=i<=k-1
 *
 *
 */

/**
 * 这种解法对于n很大的时候是不适用的，因为递归深度太大会导致堆栈溢出，所以只能使用自底向上的递归解法
 */
public class Solution2 {
    private int[] dp;
    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(isPerfectSqure(i)){
                    dp[i] = 1;
                }
                else{
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }

        return dp[n];

    }


    private boolean isPerfectSqure(int n){
        double fsqrt = Math.sqrt(n);//先将数开平方
        int m = (int) fsqrt;//转换成整数
        return m*m == n;
    }
    @Test
    public void test(){
        System.out.println(isPerfectSqure(2));
        System.out.println(numSquares(10000));

    }
}
