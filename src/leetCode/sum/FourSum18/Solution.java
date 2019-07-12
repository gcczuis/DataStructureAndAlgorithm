package leetCode.sum.FourSum18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> rets = new ArrayList<>();
        Arrays.sort(nums);
        int lastNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 3; i++) {//由于只在当前遍历元素后面寻找三元集所以，元素后面至少得有俩元素
            if (nums[i] == lastNum) continue;
            int resSum = target - nums[i];
            int lastNum2 = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length - 2; j++) {//由于只在当前遍历元素后面寻找三元集所以，元素后面至少得有俩元素
                if (nums[j] == lastNum2) continue;
                int resSum2 = resSum - nums[j];
                int start = j + 1, end = nums.length - 1;
                while (start < end) {
                    if (nums[start] + nums[end] < resSum2) start++;
                    else if (nums[start] + nums[end] > resSum2) end--;
                    else {
                        List<Integer> ret = Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
                        rets.add(ret);
                        while (start < end) {
                            if (nums[start] == nums[start + 1]) start++;
                            if (nums[end] == nums[end - 1]) end--;
                            if (start < end && nums[start] != nums[start + 1] && nums[end] != nums[end - 1]) {
                                start++;
                                end--;
                                break;
                            }
                        }
                    }
                }
                lastNum2 = nums[j];
            }
            lastNum = nums[i];
        }
        return rets;

    }
}

