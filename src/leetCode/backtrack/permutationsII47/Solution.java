package leetCode.backtrack.permutationsII47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * {@author: gcc}
 * {@Date: 2019/6/21 17:06}
 */
public class Solution {
    private boolean[] used;
    private List<List<Integer>> res = new ArrayList<>();
    private Set<List<Integer>> finalTempRes = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        permuteArr(nums, 0, new ArrayList<>());
        finalTempRes.forEach(res::add);
        return res;

    }

    //从nums[0...index-1]的组合项已经放在了tempRes中了，需要求出index后面的组合项
    private void permuteArr(int[] nums, int index, ArrayList<Integer> tempRes) {
        if (index == nums.length) {
            finalTempRes.add(new ArrayList<>(tempRes));
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
}
