package leetCode.sum.threeSumClosest16;
import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int lastNum = Integer.MAX_VALUE;
        int ret = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {//由于只在当前遍历元素后面寻找三元集所以，元素后面至少得有俩元素
            if(nums[i] == lastNum) continue;
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(sum - target) < Math.abs(ret - target)){
                    ret = sum;
                }
                if(sum < target) start ++;
                else if(sum > target) end --;
                else {
                    return sum;
                }
            }
            lastNum = nums[i];
        }
        return ret;
    }

 /*  public static void  main(String[] args){
        int[] arr = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(arr, -1));
    }*/
}
