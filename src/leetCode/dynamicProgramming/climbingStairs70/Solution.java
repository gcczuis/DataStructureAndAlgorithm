package leetCode.dynamicProgramming.climbingStairs70;

/**
 * @author: gcc
 * @Date: 2018/9/12 15:06
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 动态规划思路：
 *              状态：dp(i)指爬到i阶楼梯有多少种不同的方法
 *              状态转移方程：dp（1） = 1；dp(2) = 2;dp(k) = dp(k - 1) + dp(k - 2)  (1<=k<=n)
 */
public class Solution {

    private static int[] memo;
    //爬到n阶楼梯的不同方法数目（动态规划）
    public static int climbStairs(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];

    }
    /*public static int climbStairs(int n) {
        memo = new int[n + 1];
        return climbStairsRe(n);

    }*/
/*
    //爬到n阶楼梯的不同方法数目（记忆化搜索）
    public static int climbStairsRe(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(memo[n] == 0) {
            memo[n] = climbStairsRe(n - 1) + climbStairsRe(n - 2);
        }
        return memo[n];

    }
*/
   /* //爬到n阶楼梯的不同方法数目（非动态规划，非记忆化搜索）
    public static int climbStairsRe(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);

    }*/

    public static void main(String[] args){
        System.out.println(climbStairs(4));
    }


}
