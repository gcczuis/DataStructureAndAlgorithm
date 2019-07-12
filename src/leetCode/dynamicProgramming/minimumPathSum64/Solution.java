package leetCode.dynamicProgramming.minimumPathSum64;

/**
 * @author: gcc
 * @Date: 2018/9/12 18:34
 * @Description: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 动态规划:
 * 状态:F(i, j)表示从左上角到A(i, j)的总和最小的数字
 * 状态转移方程:F(i,j) = min(F(i, j - 1), F(i - 1, j)) + A(i,j)          (0<=i<=m-1,0<j<=n-1)
 * = F(i - 1, j) + A(i,j)                            (0<=i<=m-1,j=0)
 * = F(i, j - 1) + A(i,j)                            (i=0,0<j<=n-1)
 */
public class Solution {

    private static int[][] memo;

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];

        return minPathSumDP(grid, m - 1, n - 1);
    }

    //求出从左上角到A(i, j)的总和最小的数字
    private static int minPathSumDP(int[][] grid, int i, int j) {
        if (memo[i][j] == 0) {
            if (i == 0 && j == 0) {
                memo[i][j] = grid[i][j];
            } else if (j == 0) {
                memo[i][j] = minPathSumDP(grid, i - 1, j) + grid[i][j];
            } else if (i == 0) {
                memo[i][j] = minPathSumDP(grid, i, j - 1) + grid[i][j];
            } else {
                memo[i][j] = Math.min(minPathSumDP(grid, i - 1, j), minPathSumDP(grid, i, j - 1)) + grid[i][j];
            }
        }
        return memo[i][j];
    }
}
