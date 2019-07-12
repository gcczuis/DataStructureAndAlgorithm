package leetCode.dynamicProgramming.climbingStairs70;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 08:22}
 */
public class SolutionDP {
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
