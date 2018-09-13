package leetCode.slidingWindow.containsDuplicateII219;

import java.util.HashSet;

//一个长度为k+1的滑动窗口加set集合
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0) return false;
        HashSet<Object> set = new HashSet<>();
        for (int i = 0; i < Math.min(k + 1, nums.length) ; i++) {
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        int start = 0, end = k;
        while(end + 1 < nums.length){
            set.remove(nums[start]);
            if(set.contains(nums[end + 1])) return true;
            else set.add(nums[++end]);
            start ++;
        }
        return false;
    }
}
