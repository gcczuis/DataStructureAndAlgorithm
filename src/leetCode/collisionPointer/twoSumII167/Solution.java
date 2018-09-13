package leetCode.collisionPointer.twoSumII167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //指针对撞，设定左右两个指针
        int l = 0, r = numbers.length - 1;
        while(l < r){
            if(numbers[l] + numbers[r] < target) l++;
            else if(numbers[l] + numbers[r] > target) r--;
            else {// numbers[l] + numbers[r] == target{
                int[] ret = {l + 1, r + 1};
                return ret;
            }
        }
        return null;


    }
}