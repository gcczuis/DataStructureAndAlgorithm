package leetCode.dynamicProgramming.houseRobber198;


import java.util.Arrays;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 15:48}
 * 状态：考虑偷取[x...n-1]范围里的房子并达到价值最大,记住是考虑，意思是不一定会偷x这个房子，只是在这个范围的房子中考虑，关键是最后价值要最大
 * 状态转移方程：
 * f(x) = max{nums[x]+f(x+2),nums[x+1]+f(x+3),....,nums[n-3]+f(n-1),nums[n-2],nums[n-1]};
 */
public class Solution1 {
    int[] memo;

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return DP(nums, 0);
    }

    private int DP(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        if (memo[start] == -1) {
            for (int i = start; i < nums.length; i++) {
                memo[start] = Math.max(memo[start], nums[i] + DP(nums, i + 2));
            }
        }
        return memo[start];
    }
}
