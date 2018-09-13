package leetCode.sort.sortColors75;

public class Solution {

    //利用三路快排的原理
    public void sortColors(int[] nums) {
        int length = nums.length;
        int a = 1;//比较的元素是1
        int lt = 0, bt = length - 1;//[0....lt)<a,[lt...i) = a,(bt....length-1]> a
        //注意这边是<=，因为bt是开区间
        for (int i = 0; i <= bt; i++) {
            if(nums[i] < a){
                swap(nums, i, lt++);
            }
            else if(nums[i] > a){
                swap(nums, bt--, i--);
            }
        }
    }


    public static void swap(int[] arr, int i, int j){
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;

    }



}
