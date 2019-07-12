package leetCode.backtrack.pacificAtlanticWaterFlow417;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/22 15:11}
 * 技巧：如果题目跟四条边有关的话，可以从四条边来进行DFS，找到能触及四条边的所有元素，而不用遍历整个矩阵进行DFS
 */
public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //坐标是否触及太平洋
        boolean[][] pacific = new boolean[n][m];
        //坐标是否触及大西洋
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            //对第一行的所有元素进行DFS，标记触及太平洋的元素
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            //对最后一行的所有元素进行DFS，标记触及太平洋的元素
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            //对第一列的所有元素进行DFS，标记触及大西洋的元素
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            //对最后一列的所有元素进行DFS，标记触及大西洋的元素
            dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i,j));
        return res;
    }

    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length, m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for (int[] d : dir) {
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }
}
