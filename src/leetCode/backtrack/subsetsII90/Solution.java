package leetCode.backtrack.subsetsII90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/21 21:59}
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //对于有重复元素的，先进行排序
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            subset(nums, i, 0, new ArrayList<>());
        }
        return res;
    }

    private void subset(int[] nums, int size, int start, ArrayList<Integer> tempRes) {
        if (tempRes.size() == size) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //这行很关键，去除了重复的可能组合
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }
            tempRes.add(nums[i]);
            subset(nums,size,i+1,tempRes);
            tempRes.remove(tempRes.size() - 1);
        }


    }
}
