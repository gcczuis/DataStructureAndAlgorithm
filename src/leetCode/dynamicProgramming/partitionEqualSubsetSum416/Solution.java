package leetCode.dynamicProgramming.partitionEqualSubsetSum416;

import java.util.stream.IntStream;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 20:05}
 * 典型的背包问题，在n个物品中选出一定物品，填满sum/2的背包
 * 状态：DP(n,c)考虑n个物品,看是否能填满容量为C的背包
 * DP(i,c) = DP(i-1,c)||DP(i-1,c-w(i))
 */
public class Solution {
    //-1表示不能填满，0表示未记录，1表示能填满，需要表示三个状态
    private int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();
        if (sum % 2 != 0 || sum == 0) {
            return false;
        }
        int half = sum / 2;
        memo = new int[nums.length][half + 1];

        return partition(nums, half, nums.length - 1);
    }

    private boolean partition(int[] nums, int sum, int end) {
        if (end < 0 || sum < 0) {
            return false;
        }
        if (memo[end][sum] != 0) {
            return memo[end][sum] == 1;
        }
        if (sum == 0) {
            memo[end][sum] = 1;
            return true;
        }
        memo[end][sum] = partition(nums, sum, end - 1) || partition(nums, sum - nums[end], end - 1) ? 1 : -1;
        return memo[end][sum] == 1;


    }
}
