package leetCode.slidingWindow.MinimumSizeSubarraySum209;

/**
 * 这是滑动窗口的标准代码，滑动窗口需要考虑的边界还是挺多的，包括何时循环的结束，条件的判定，边界的判定等等
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = -1, sum = 0, ret = nums.length + 1;
        //[start...end]维护了一个滑动窗口
        while(start < nums.length){
            //右边界可以扩展（满足题目条件sum<s且未到数组边界）
            if((end + 1 < nums.length) && sum < s) {
                sum += nums[++end];
            }
            else {//右边界不可以拓展，只能左边界开始拓展
                sum -= nums[start++];
            }
            if(sum >= s)
                ret = Math.min(end - start + 1, ret);
        }
        return ret == nums.length + 1 ? 0 : ret;

    }

   /* public static void main(String[] args){
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, arr));
    }*/
}
