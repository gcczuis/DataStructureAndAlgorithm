package leetCode.removeElements.removeDuplicatesFromSortedArray26;

import java.util.HashMap;

class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int i = 0;
        //[0....i)存储着所有非重复元素,[i...k)存储着所有重复的元素
        for (int k = 0; k < length; k++) {
            if(!map.containsKey(nums[k])){
                map.put(nums[k],1);
                swap(nums, k, i);
                i++;
            }

        }
        return i;

    }



    public static void swap(int[] arr, int i, int j){
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;

    }
}