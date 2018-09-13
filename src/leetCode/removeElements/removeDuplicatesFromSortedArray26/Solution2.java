package leetCode.removeElements.removeDuplicatesFromSortedArray26;


/**
 * 解法1未能充分理解题目条件“Given a sorted array nums”，数组是有序的说明重复元素是紧挨着的
 */
public class Solution2 {
    public int removeDuplicates(int[] nums) {


        int length = nums.length;
        int i = 1;//由于第一个元素肯定不是重复的所以可以取1，
        //[0....i)存储着所有非重复元素,[i...k)存储着所有和[0..i)有重复的元素
        for (int k = 1; k < length; k++) {
            if(nums[k] !=  nums[i-1]){
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
