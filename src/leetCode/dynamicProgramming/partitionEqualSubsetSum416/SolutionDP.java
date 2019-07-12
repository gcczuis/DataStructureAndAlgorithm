package leetCode.dynamicProgramming.partitionEqualSubsetSum416;

import java.util.stream.IntStream;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 20:05}
 * 典型的背包问题，在n个物品中选出一定物品，填满sum/2的背包
 * 状态：DP(n,c)考虑n个物品,看是否能填满容量为C的背包
 * DP(i,c) = DP(i-1,c)||DP(i-1,c-w(i))
 *
 * 画图画图画图，用动态规划解题，需要
 * 1. 想出状态定义和状态转移方程
 * 2. 画图，看图来初始化memo数组
 */
public class SolutionDP {
    //-1表示不能填满，0表示未记录，1表示能填满，需要表示三个状态
    private boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();
        if (sum % 2 != 0 || sum == 0) {
            return false;
        }
        int half = sum / 2;
        memo = new boolean[nums.length][half + 1];
        //初始化第一行，因为下面每一行都需要用到上一行的信息
        for (int i = 0; i <= half; i++) {
            memo[0][i] = (nums[0] == i);
        }
        //初始化第一列，当啥物品都不放的时候肯定能装满容量为0的背包，所以全部初始化为true
        for(int i = 0; i < nums.length; i++) {
            memo[i][0] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= half; j++) {
                if (nums[i] <= j){
                    memo[i][j] = memo[i-1][j] || memo[i-1][j-nums[i]];
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        return memo[nums.length - 1][half];
    }


}
