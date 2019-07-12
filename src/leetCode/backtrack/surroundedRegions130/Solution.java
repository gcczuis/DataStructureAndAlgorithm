package leetCode.backtrack.surroundedRegions130;


/**
 * {@author: gcc}
 * {@Date: 2019/6/22 11:07}
 * 遍历矩阵的四条边，如果有'O'的，从这个点进行DFS寻找相连的'O',将这些'O'设为'U'
 * 遍历全部矩阵，将'O'全部设为'X',将'U'全部设为'O','X'不变
 * <p>
 * <p>
 * 技巧：如果题目跟四条边有关的话，可以从四条边来进行DFS，找到能触及四条边的所有元素，而不用遍历整个矩阵进行DFS
 */
public class Solution {

    //为了方便偏移上下左右四个方向
    private int[] horizontalShifting = {0, 0, -1, 1};
    private int[] verticalShifting = {-1, 1, 0, 0};
    private int rows;
    private int columns;


    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        //初始化
        rows = board.length;
        assert rows > 0;
        columns = board[0].length;

        for (int i = 0; i < board[0].length; ++i) {
            if (board[0][i] == 'O') {
                markUnflippable(board, 0, i);
            }
        }
        for (int i = 0; i < board[board.length - 1].length; ++i) {
            if (board[board.length - 1][i] == 'O') {
                markUnflippable(board, board.length - 1, i);
            }
        }
        for (int i = 0; i < board.length; ++i) {
            if (board[i][0] == 'O') {
                markUnflippable(board, i, 0);
            }
        }
        for (int i = 0; i < board.length; ++i) {
            if (board[i][board[i].length - 1] == 'O') {
                markUnflippable(board, i, board[i].length - 1);
            }
        }

        // modify the board
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'U') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void markUnflippable(char[][] board, int r, int c) {
        board[r][c] = 'U';
        for (int i = 0; i < 4; i++) {
            int newRow = r + verticalShifting[i];
            int newColumn = c + horizontalShifting[i];
            if (valid(newRow, newColumn) && board[newRow][newColumn] == 'O') {
                markUnflippable(board, newRow, newColumn);
            }
        }
    }

    private boolean valid(int rowIndex, int columnIndex) {
        return rowIndex < rows && rowIndex >= 0 && columnIndex >= 0 && columnIndex < columns;
    }
}
