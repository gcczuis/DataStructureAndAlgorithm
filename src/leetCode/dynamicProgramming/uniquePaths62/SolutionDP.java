package leetCode.dynamicProgramming.uniquePaths62;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 11:27}
 */
public class SolutionDP {
    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m + 1][n + 1];
        memo[1][1] = 1;
        for (int i = 2; i < m+1; i++) {
            memo[i][1] = memo[i-1][1];
        }
        for (int i = 2; i < n+1; i++) {
            memo[1][i] = memo[1][i-1];
        }
        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                memo[i][j] = memo[i-1][j]+memo[i][j-1];
            }
        }

        return memo[m][n];
    }
}
