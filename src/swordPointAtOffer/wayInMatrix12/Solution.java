package swordPointAtOffer.wayInMatrix12;

import org.junit.Test;

/**
 * {@author: gcc}
 * {@Date: 2019/7/9 14:30}
 */
public class Solution {
    boolean[][] used;
    int[][] forward = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    int rows;
    int cols;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        this.rows = rows;
        this.cols = cols;

        char[][] realMatrix = new char[rows][cols];
        int counter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                realMatrix[i][j] = matrix[counter++];
            }
        }

        used = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (has(realMatrix, i, j, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //在row，col这个位置上验证是否存在dest数组中从start开始的剩余路径
    private boolean has(char[][] source, int row, int col, char[] dest, int start) {
        if (source[row][col] == dest[start]) {
            if (start == dest.length - 1) {
                return true;
            } else {
                used[row][col] = true;
                for (int i = 0; i < 4; i++) {
                    int newRow = row + forward[0][i];
                    int newCol = col + forward[1][i];

                    if (isValid(newRow, newCol) && !used[newRow][newCol] && has(source, newRow, newCol, dest, start + 1)) {
                        return true;
                    }
                }
                used[row][col] = false;
            }
        }
        return false;
    }

    private boolean isValid(int row, int col) {
        return row < rows && row >= 0 && col >= 0 && col < cols;
    }

    @Test
    public void test() {
        System.out.println(hasPath(new char[]{'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'}, 3, 4, new char[]{'A', 'B', 'C', 'C', 'E', 'D'}));
    }
}
