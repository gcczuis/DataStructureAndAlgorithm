package leetCode.dynamicProgramming.houseRobber198;

import java.util.Arrays;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 15:48}
 * 状态：考虑偷取[x...n-1]范围里的房子并达到价值最大,记住是考虑，意思是不一定会偷x这个房子，只是在这个范围的房子中考虑，关键是最后价值要最大
 * 状态转移方程：
 * f(x) = max{nums[x]+f(x+2),nums[x+1]+f(x+3),....,nums[n-3]+f(n-1),nums[n-2],nums[n-1]};
 */
public class Solution1DP {
    int[] memo;

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //可以超过nums.length的限制，反正默认memo[nums.lenth+k] = 0,加不加没区别
        memo = new int[nums.length + 2];
        Arrays.fill(memo, 0);
        memo[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                memo[i] = Math.max(memo[i], nums[j] + memo[j + 2]);
            }
        }
        return memo[0];
    }
}
