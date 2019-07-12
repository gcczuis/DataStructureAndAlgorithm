package leetCode.dynamicProgramming.uniquePathsII63;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 14:55}
 */
public class Solution {
    int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        return DP(obstacleGrid, m - 1, n - 1);

    }

    private int DP(int[][] map, int m, int n) {
        if (m < 0 || n < 0 || map[m][n] == 1) {
            return 0;
        }
        if (memo[m][n] == 0) {
            if (m == 0 && n == 0) {
                return memo[m][n] = 1;
            }
            return memo[m][n] = DP(map, m - 1, n) + DP(map, m, n - 1);
        }
        return memo[m][n];
    }
}
