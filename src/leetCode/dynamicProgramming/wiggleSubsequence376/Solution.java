package leetCode.dynamicProgramming.wiggleSubsequence376;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * {@author: gcc}
 * {@Date: 2019/6/24 16:35}
 * 因为一个元素如果在wiggle串中，它可能会扮演两个角色，一个是在串中与其他元素相比较大的那个，
 * 另一个是在串中与其他元素相比较小的那个
 *
 * big(i) = max{1+small(j)}   0<=j<=i-1
 * small(i) = max{1+big(j)}   0<=j<=i-1
 *
 * 最后的结果为：
 * Max{big(i),small(i)}         i从0~nums.length-1
 *
 * 注意：二维数组初始化要都为1，因为每个字符都是一个长度为1的wiggle串
 *
 */
public class Solution {
    int[][] memo;

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //创建一个二维数组，第一行memo[0][i]表示如果nums[i]是作为wiggle串，他在串中和旁边元素比较是较大的那个
        //创建一个二维数组，第一行memo[1][i]表示如果nums[i]是作为wiggle串，他在串中和旁边元素比较是较小的那个
        memo = new int[2][nums.length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], 1);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    memo[0][i] = Math.max(memo[0][i], memo[1][j] + 1);
                }
                if (nums[i] < nums[j]) {
                    memo[1][i] = Math.max(memo[1][i], memo[0][j] + 1);
                }
            }
        }
        return Math.max(IntStream.of(memo[0]).max().getAsInt(),IntStream.of(memo[1]).max().getAsInt());
    }
}
