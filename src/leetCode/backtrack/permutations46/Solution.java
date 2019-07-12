package leetCode.backtrack.permutations46;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/21 16:16}
 * 和电话号码那一题有区别，因为电话号码每个数字对应的是不同的字符组合，而本题中前面的选择会影响后续的选择，因为不能出现重复的数字
 * 理解回溯，状态的回溯
 */
public class Solution {
    private boolean[] used;
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        permuteArr(nums, 0, new ArrayList<>());
        return res;

    }

    //从nums[0...index-1]的组合项已经放在了tempRes中了，需要求出index后面的组合项
    private void permuteArr(int[] nums, int index, ArrayList<Integer> tempRes) {
        if (index == nums.length) {
            res.add(new ArrayList<>(tempRes));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                int ret = nums[i];
                tempRes.add(ret);
                used[i] = true;
                permuteArr(nums, index + 1, tempRes);
                tempRes.remove(tempRes.size() - 1);
                used[i] = false;
            }
        }
    }
    @Test
    public void test(){
        permute(new int[]{1,2,3});
    }
}
