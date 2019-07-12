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
public class Solution2DP {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
        }
        return memo[nums.length];
    }
}
