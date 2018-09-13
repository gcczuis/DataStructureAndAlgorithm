package leetCode.removeElements.moveZeroes283;

public class Solution1 {
    //时间复杂度：O(n)
    //空间复杂度：O(1)

    public void moveZeroes(int[] nums) {
        int l = nums.length;
        int i = -1;//[0...i]包含全部非零元素
        for (int j = 0; j < l; j++) {
            if(nums[j] == 0) {
                i = j - 1;
                break;
            }
        }
        //[i+1...k)为0
        for (int k = i + 1; k < l; k++) {
            if(nums[k] != 0){
                swap(nums, k, i + 1);
                i ++;
            }
        }

    }


    public static void swap(int[] arr, int i, int j){
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;

    }
}
