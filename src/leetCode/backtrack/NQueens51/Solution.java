package leetCode.backtrack.NQueens51;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@author: gcc}
 * {@Date: 2019/6/25 19:12}
 */
public class Solution {
    private List<List<String>> ret = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[n * 2 - 1];
        boolean[] dia2 = new boolean[n * 2 - 1];
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        List<String> tempRes = Stream.generate(() -> new String(chars))
                .limit(n)
                .collect(Collectors.toList());
        putQInLine(n, 0, col, dia1, dia2, tempRes);
        return ret;

    }

    private void putQInLine(int n, int row, boolean[] col, boolean[] dia1, boolean[] dia2, List<String> tempRes) {
        if (row == n) {
            ret.add(new ArrayList<>(tempRes));
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[i + row] && !dia2[row - i + n - 1]) {
                col[i] = true;
                dia1[row + i] = true;
                dia2[row - i + n - 1] = true;
                tempRes.remove(row);
                tempRes.add(row, generateQStr(n, i));
                putQInLine(n, row + 1, col, dia1, dia2, tempRes);
                tempRes.remove(row);
                tempRes.add(row, generatePotStr(n));
                dia2[row - i + n - 1] = false;
                dia1[row + i] = false;
                col[i] = false;
            }
        }
    }

    private String generatePotStr(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        return new String(chars);
    }

    private String generateQStr(int n, int i) {
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        chars[i] = 'Q';
        return new String(chars);
    }
}
