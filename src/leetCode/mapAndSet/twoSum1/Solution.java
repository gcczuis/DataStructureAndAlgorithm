package leetCode.mapAndSet.twoSum1;


import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //因为题目只有一个解，为了避免有两个元素4,4而target是8，但用map会将两个4覆盖成一个4的情况，所以每遍历一个
            //值先判断这个值前面是否有target-这个值，如果没有再放入map中
            if(map.containsKey(target - nums[i])){
                ret[0] = i;
                ret[1] = map.get(target - nums[i]);
                return ret;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
