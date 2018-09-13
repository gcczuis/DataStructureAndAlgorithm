package leetCode.removeElements.removeElement27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        //[0...i)中不包含val,[i,k)中全是val
        int i = 0;
        for (int k = 0; k < length; k++) {
            if(nums[k] != val){
                swap(nums, i, k);
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
