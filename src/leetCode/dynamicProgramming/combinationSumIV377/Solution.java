package leetCode.dynamicProgramming.combinationSumIV377;

import java.net.DatagramPacket;
import java.util.Arrays;

/**
 * {@author: gcc}
 * {@Date: 2019/6/24 09:07}
 * 这是个典型的树形问题
 *         1 - 1 - 0
 *        /
 *      1 - 2 - 0
 *    ／
 *  1 － 2 - 1 - 0
 *    \
 *     3 - 0              ==> total ways = 7
 *
 *      1 - 1 - 0
 *    /
 *  2 - 2 - 0
 *
 *  3 - 1 - 0
 *  状态：
 *  从nums[i]开始来凑足j一共有多少种方式？凑齐的话第一个元素一定是nums[i]
 *  状态转移方程：
 *  DP(i,j) = sum{DP(m,j-nums[i]) | m from nums[0] to nums[nums.length-1]}
 *  = 0 if nums[i] > j
 *
 */
public class Solution {
    int[][] memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[nums.length][target + 1];
        for (int i = 0; i < memo.length; i++) {
            //这种没有最大最小比较的题用-1作为初始值肯定没问题
            Arrays.fill(memo[i],-1);
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret += dp(nums,target,i);
        }
        return ret;
    }

    private int dp(int[] nums, int target, int index) {
        if (memo[index][target] != -1){
            return memo[index][target];
        }
        if (nums[index] == target){
            memo[index][target] = 1;
        }else if(nums[index] > target){
            memo[index][target] = 0;
        }else{
            memo[index][target] = 0;
            for (int i = 0; i < nums.length; i++) {
                memo[index][target] += dp(nums,target - nums[index],i);
            }
        }
        return memo[index][target];
    }
}
