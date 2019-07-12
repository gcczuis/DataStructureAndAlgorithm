package leetCode.backtrack.numberOfIslands200;

/**
 * {@author: gcc}
 * {@Date: 2019/6/22 10:39}
 */
public class Solution {
    //为了方便偏移上下左右四个方向
    private int[] horizontalShifting = {0, 0, -1, 1};
    private int[] verticalShifting = {-1, 1, 0, 0};
    //传入的二维数组行、列数
    private int rows;
    private int columns;
    //该元素是否被访问过
    private boolean[][] used;
    private int res;

    public int numIslands(char[][] grid) {
        if (grid.length == 0){
            return 0;
        }

        //初始化
        rows = grid.length;
        assert rows > 0;
        columns = grid[0].length;
        used = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    res++;
                    mark(grid, i, j);
                }
            }

        }
        return res;

    }

    //grid[rowIndex][columnIndex]已经是陆地了，标记与之相连的陆地
    //保证rowIndex，columnIndex合法，且used[rowIndex][columnIndex]是没有被访问过的陆地
    private void mark(char[][] grid, int rowIndex, int columnIndex) {
        used[rowIndex][columnIndex] = true;
        for (int i = 0; i < 4; i++) {
            int newRowIndex = rowIndex + horizontalShifting[i];
            int newColumnIndex = columnIndex + verticalShifting[i];

            if (valid(newRowIndex, newColumnIndex)
                    && !used[newRowIndex][newColumnIndex]
                    && grid[newRowIndex][newColumnIndex] == '1') {
                mark(grid, newRowIndex, newColumnIndex);
            }
        }

    }


    private boolean valid(int rowIndex, int columnIndex) {
        return rowIndex < rows && rowIndex >= 0 && columnIndex >= 0 && columnIndex < columns;
    }
}
