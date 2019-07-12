package leetCode.dynamicProgramming.houseRobber198;

import java.util.Arrays;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 16:48}
 * 考虑和{@link Solution1}不一样的状态定义和状态转移方程
 * 状态定义：考虑偷取从[0....x]的房子获取到的金钱价值最大,同样的不会限定必须要偷取x这个房子
 * 状态转移方程：
 * DP(x) = Math.max(DP(x - 2) + momey[x], DP(x - 1))
 */
public class Solution2 {
    int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        return result;
    }
}
