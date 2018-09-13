package leetCode.removeElements.moveZeroes283;

public class Solution2 {

    //时间复杂度：O(n)
    //空间复杂度：O(1)

    public void moveZeroes(int[] nums) {
        int length = nums.length;

        //[0...i)为非零元素，[i....k)为0元素
        int i = 0;
        for (int k = 0; k < length; k++) {
            if(nums[k] != 0) {
                if(k != i)
                    swap(nums, k, i++);
                else
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
