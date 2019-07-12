package leetCode.removeElements.moveZeroes283;

public class Solution1 {
    //时间复杂度：O(n)
    //空间复杂度：O(1)

    public void moveZeroes(int[] nums) {
        int l = nums.length;
        int i = 0;//[0...i)包含全部非零元素,[i,j)包含所有零元素，[j,l)是要探索的区域
        for (int j = 0; j < l; j++) {
            if(nums[j] != 0) {
                swap(nums,j,i);
                i++;
            }
        }
    }


    public static void swap(int[] arr, int i, int j){
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;

    }
}
