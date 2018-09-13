package leetCode.dynamicProgramming.perfectSquares279;

import org.junit.Test;

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
public class Solution {
    private int[] dp;
    public int numSquares(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        dp = new int[n + 1];
        return numSquaresDP(n);
    }
    private int numSquaresDP(int n){
        if(dp[n] != 0){
            return dp[n];
        }
        if(isPerfectSqure(n)){
            dp[n] = 1;
        }
        else{
            dp[n] = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                dp[n] = Math.min(dp[n], numSquaresDP(i) + numSquaresDP(n - i));
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
        System.out.println(numSquares(100000));

    }
}
