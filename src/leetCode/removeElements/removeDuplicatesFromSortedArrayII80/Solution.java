package leetCode.removeElements.removeDuplicatesFromSortedArrayII80;

class Solution {
    public int removeDuplicates(int[] nums) {

        //i-1索引的元素是不是已经重复了，“相当于维护了一个i-1这个索引位置元素是第几次出现的，从而来判断k这个位置元素是否可以加入[0...i)区间”
        boolean isSecond = false;
        int length = nums.length;
        int i = 1;//由于第一个元素肯定不是重复的所以可以取1，
        //[0....i)存储着所有符合条件的元素,[i...k)存储着所有废弃的元素
        for (int k = 1; k < length; k++) {
            if(nums[k] !=  nums[i-1]){
                swap(nums, k, i);
                i++;
                isSecond = false;
            }
            else if((nums[k] ==  nums[i-1] && isSecond == false)){
                swap(nums, k, i);
                i++;
                isSecond = true;
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