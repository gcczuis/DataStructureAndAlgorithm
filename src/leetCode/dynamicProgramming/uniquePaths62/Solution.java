package leetCode.dynamicProgramming.uniquePaths62;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 11:27}
 * DP(m,n) = DP(m-1,n)+DP(m,n-1)    (m>1,n>1)
 * =DP(m,n-1)   (m=1,n>1)
 * =DP(m-1,n)   (m>1,n=1)
 * =1           (m=1,n=1)
 */
public class Solution {
    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m + 1][n + 1];
        return DP(m, n);
    }

    private int DP(int m, int n) {
        if (memo[m][n] == 0) {
            if (m == 1 && n == 1) {
                return memo[m][n] = 1;
            }
            if (m == 0 || n == 0) {
                return memo[m][n] = 0;
            }
            memo[m][n] = DP(m - 1, n) + DP(m, n - 1);
        }
        return memo[m][n];
    }
}
