package leetCode.backtrack.subsets78;

import java.util.ArrayList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/21 21:46}
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        for (int i = 0; i <= size; i++) {
            subset(nums,0,i,new ArrayList<>());
        }
        return res;

    }

    private void subset(int[] nums, int start, int size, ArrayList<Integer> tempRes) {
        if (tempRes.size() == size){
            res.add(new ArrayList<>(tempRes));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempRes.add(nums[i]);
            subset(nums,i + 1,size,tempRes);
            tempRes.remove(tempRes.size() - 1);
        }
    }
}
