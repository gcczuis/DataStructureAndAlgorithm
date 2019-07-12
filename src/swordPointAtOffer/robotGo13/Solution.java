package swordPointAtOffer.robotGo13;

import org.junit.Test;

/**
 * {@author: gcc}
 * {@Date: 2019/7/9 15:06}
 */
public class Solution {
    boolean[][] used;
    int[][] forward = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    int rows;
    int cols;
    int ret = 0;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        used = new boolean[rows][cols];

        search(0, 0, threshold);
        return ret;

    }

    private void search(int row, int col, int threshold) {
        if (sumOfAxis(row, col) <= threshold) {
            ret++;
            System.out.println("row:"+row+",col:"+col);
            used[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int newRow = row + forward[0][i];
                int newCol = col + forward[1][i];
                if (isValid(newRow, newCol) && !used[newRow][newCol])
                    search(newRow, newCol, threshold);
            }

        } else {
            used[row][col] = true;
        }
    }


    private boolean isValid(int row, int col) {
        return row < rows && row >= 0 && col >= 0 && col < cols;
    }

    private int sumOfAxis(int row, int col) {
        int ret = 0;
        while (row / 10 != 0) {
            ret += row % 10;
            row /= 10;
        }
        ret += row;
        while (col / 10 != 0) {
            ret += col % 10;
            col /= 10;
        }
        ret += col;

        return ret;
    }

    @Test
    public void test() {
        System.out.println(sumOfAxis(10,4));
        System.out.println(movingCount(5, 10, 10));
    }


}
