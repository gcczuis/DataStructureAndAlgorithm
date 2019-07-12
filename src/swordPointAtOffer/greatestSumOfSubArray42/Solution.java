package swordPointAtOffer.greatestSumOfSubArray42;

/**
 * {@author: gcc}
 * {@Date: 2019/7/2 19:14}
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {

        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                ret = Math.max(ret, add(array, i, j));
            }
        }
        return ret;
    }

    private int add(int[] arr, int lo, int hi) {
        int ret = 0;
        for (int i = lo; i < hi + 1; i++) {
            ret += arr[i];
        }
        return ret;
    }
}
