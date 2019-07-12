package leetCode.backtrack.combinations77;

import java.util.ArrayList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/21 17:19}
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineBackTrack(n, k, 1, new ArrayList<>());
        return res;
    }

    //求解C(n,k),当前已经找到的组合存储在tempRes中，需要从start开始搜索新的元素
    private void combineBackTrack(int n, int k, int start, ArrayList<Integer> tempRes) {
        if (tempRes.size() == k) {
            res.add(new ArrayList<>(tempRes));
            return;
        }

        for (int i = start; i <= n; i++) {
            tempRes.add(i);
            combineBackTrack(n, k, i + 1, tempRes);
            tempRes.remove(tempRes.size() - 1);
        }

    }
}
