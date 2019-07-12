package leetCode.backtrack.wordSearch79;

import org.junit.Test;

/**
 * {@author: gcc}
 * {@Date: 2019/6/22 09:30}
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

    public boolean exist(char[][] board, String word) {
        //初始化
        rows = board.length;
        assert rows > 0;
        columns = board[0].length;
        used = new boolean[rows][columns];
        //对二维数组中每个元素都进行search
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (search(word, board, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //从board[rowIndex,columnIndex]处匹配word.charAt(start),匹配成功则分四个方向继续匹配，匹配失败返回false
    private boolean search(String word, char[][] board, int rowIndex, int columnIndex, int start) {
        if (start == word.length() - 1 && board[rowIndex][columnIndex] == word.charAt(start)) {
            return true;
        }

        if (board[rowIndex][columnIndex] == word.charAt(start)) {
            used[rowIndex][columnIndex] = true;

            for (int i = 0; i < 4; i++) {
                int newRowIndex = rowIndex + horizontalShifting[i];
                int newColumnIndex = columnIndex + verticalShifting[i];

                if (valid(newRowIndex, newColumnIndex) && !used[newRowIndex][newColumnIndex] && search(word, board, newRowIndex, newColumnIndex, start + 1)) {
                    return true;
                }
            }
            used[rowIndex][columnIndex] = false;
        }
        return false;

    }

    private boolean valid(int rowIndex, int columnIndex) {
        return rowIndex < rows && rowIndex >= 0 && columnIndex >= 0 && columnIndex < columns;
    }

    @Test
    public void testArr() {


    }
}
