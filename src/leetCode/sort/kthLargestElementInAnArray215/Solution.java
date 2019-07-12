package leetCode.sort.kthLargestElementInAnArray215;

public class Solution {

    //如何不使用先排序再找元素的思路而是利用快速排序的思路？
    //利用快排partition中，将pivot放置在了其正确的位置上的性质

    public int findKthLargest(int[] nums, int k) {
        int ret = nums.length, l = 0, r = nums.length;
        partition(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    /**
     *
     * @param nums
     * @param l 要partition的左边界
     * @param r 要partition的右边界
     * @return  pivot的index
     */
    private static void partition(int[] nums, int l, int r, int ret){
        //取第一个元素作为快排的分割元素
        int v = nums[l];
        //理解下面这行注释至关重要
        //arr[l+1...j] < v, arr[j+1...i) >= v,i是循环中一直需要判断和v的大小的那个元素索引
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(nums[i] < v){
                swap(nums, i, j+1);
                j++;
            }
        }
        //由于arr[j] < v,而v在l（<j）的位置上，所以交换l和j
        swap(nums, l, j);
        if(nums.length - j == ret) return ;
        else if(nums.length - j > ret) partition(nums, j + 1, r, ret);
        else if(nums.length - j < ret) partition(nums, l, j - 1, ret);
    }


    public static void swap(int[] arr, int i, int j){
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;

    }
   /* public static void main(Solution[] args){
        int[] test = {-1,1,5,12,8,-1,0};
        partition(test, 0, test.length-1,2);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
            
        }

    }*/
}
