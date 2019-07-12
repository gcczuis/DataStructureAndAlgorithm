package leetCode.backtrack.NQueensII52;

/**
 * {@author: gcc}
 * {@Date: 2019/6/25 20:35}
 */
public class Solution {
    private int ret;

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[n * 2 - 1];
        boolean[] dia2 = new boolean[n * 2 - 1];
        char[] chars = new char[n];
        putQInLine(n, 0, col, dia1, dia2);
        return ret;

    }

    private void putQInLine(int n, int row, boolean[] col, boolean[] dia1, boolean[] dia2) {
        if (row == n) {
            ret++;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[i + row] && !dia2[row - i + n - 1]) {
                col[i] = true;
                dia1[row + i] = true;
                dia2[row - i + n - 1] = true;
                putQInLine(n, row + 1, col, dia1, dia2);
                dia2[row - i + n - 1] = false;
                dia1[row + i] = false;
                col[i] = false;
            }
        }
    }

}
