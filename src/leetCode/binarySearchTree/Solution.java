package leetCode.binarySearchTree;

import java.util.TreeSet;

//滑动窗口+二分搜索树的顺序性   |nums[i] - nums[k]| <= t     <==>   nums[k] - t <= nums[i] <= t + nums[k]
//利用这个特性
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        int start = 0, end = 0;
        for (; end < nums.length; end++) {

            if(set.ceiling((long)nums[end] - (long)t) != null && set.ceiling((long)nums[end] - (long)t) <= (long)t + nums[end]) return true;
            set.add((long) nums[end]);
            if(end - start >= k){
                set.remove((long)nums[start ++]);
            }
        }
        return false;
    }

/*    public static void main(Solution[] args){
        int[] arr ={1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(arr, 3, 0));
    }*/
}
