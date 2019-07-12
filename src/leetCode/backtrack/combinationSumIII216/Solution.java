package leetCode.backtrack.combinationSumIII216;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/21 20:31}
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combine3(k, n, 1, new ArrayList<>());
        return res;
    }

    private void combine3(int k, int remainSum, int start, List<Integer> tempRes) {
        if (k == tempRes.size()) {
            if (remainSum == 0) {
                res.add(new ArrayList<>(tempRes));
                return;
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (remainSum < i) {
                continue;
            }
            tempRes.add(i);
            combine3(k, remainSum - i, i + 1, tempRes);
            tempRes.remove(tempRes.size() - 1);
        }

    }

    @Test
    public void test() {
        combinationSum3(3, 7);

    }
}
