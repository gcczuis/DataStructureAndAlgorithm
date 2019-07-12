package leetCode.dynamicProgramming.combinationSumIV377;

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
 *  = 1 if nums[i] = j
 */
public class SolutionDP {
    int[][] memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[nums.length][target + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i],-1);
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            memo[i][0] = 0;
        }
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == j) {
                    memo[i][j] = 1;
                }else if (nums[i] > j){
                    memo[i][j] = 0;
                }else{
                    memo[i][j] = 0;
                    for (int k = 0; k < nums.length; k++) {
                        memo[i][j] += memo[k][j-nums[i]];
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            ret += memo[i][target];
        }
        return ret;
    }
}
