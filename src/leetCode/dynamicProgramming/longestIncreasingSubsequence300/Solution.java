package leetCode.dynamicProgramming.longestIncreasingSubsequence300;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * {@author: gcc}
 * {@Date: 2019/6/24 15:51}
 * 状态：
 * DP(i):从[0...i]元素中以nums[i]结尾的最长上升子序列的长度
 * 状态转移方程：
 * DP(i) = max{DP(k)+1}   k from 0 to i-1
 *
 * 注意：
 * 1. 这道题两个值相等不属于上升
 * 2. 这道题的初始值很关键，初始值都为1
 * 3. 最后需要遍历memo数组，获得最大值
 */
public class Solution {
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        memo = new int[nums.length];
        Arrays.fill(memo,1);
        for (int i = 1; i < memo.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (nums[i] >= nums[j]) {
                    memo[i] = Math.max(memo[i],memo[j]+1);
                }
            }
        }
        return IntStream.of(memo).max().getAsInt();
    }
}
