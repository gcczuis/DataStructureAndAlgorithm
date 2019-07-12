package leetCode.dynamicProgramming.targetSum494;


/**
 * {@author: gcc}
 * {@Date: 2019/6/24 10:49}
 * 状态：
 * 对于前i个元素通过合理安排加减符号位置使得最终结果为j，其所有可能的排列数量为DP(i,j)
 * 状态转移方程：
 * DP(i,j) = DP(i-1,j+nums[i-1]) + DP(i-1,j-nums[i-1])
 */
public class Solution {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        if (S < -sum || S > sum) { return 0;}

        int[][] dp = new int[nums.length + 1][ 2 * sum + 1];
        dp[0][0 + sum] = 1; // 0 + sum means 0, 0 means -sum,  check below graph
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j < 2 * sum + 1; j++){

                if(j + nums[i - 1] < 2  * sum + 1) dp[i][j] += dp[i - 1][j + nums[i - 1]];
                if(j - nums[i - 1] >= 0) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][sum + S];
    }
}
