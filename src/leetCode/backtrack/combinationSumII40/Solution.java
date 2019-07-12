package leetCode.backtrack.combinationSumII40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/21 19:30}
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<Integer> tempRes, int[] source, int remainSum, int start) {

        if (remainSum == 0) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        //如何去除重复？
        // 1. 对元素进行排序，比如这道题排序成1,1,2,5,6,7,10   和为8
        for (int i = start; i < source.length; i++) {
            int candidate = source[i];
            //这一步非常重要(i > start && candidate == source[i - 1])
            //不能只写candidate == source[i - 1]这样会漏掉1,1,6这种情况，这个i>index条件非常关键
            if (candidate > remainSum || (i > start && candidate == source[i - 1])) {
                continue;//去除重复元素
            }
            tempRes.add(source[i]);
            backtrack(tempRes, source, remainSum - candidate, i + 1);
            tempRes.remove(tempRes.size() - 1);
        }
    }
}
