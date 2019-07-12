package swordPointAtOffer.twoNumSumS;

import org.junit.Test;

import java.util.ArrayList;


public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MAX_VALUE;

        for (int i = 0; i < array.length - 1; i++) {
            if (contains(array, i + 1, array.length - 1, sum - array[i])) {
                if (array[i] * (sum - array[i]) < min){
                    min = array[i] * (sum - array[i]);
                    lo = array[i];
                    hi = sum - array[i];
                }
            }
        }

        if (lo != Integer.MAX_VALUE) {
            list.add(lo);
            list.add(hi);
        }
        return list;

    }

    private boolean contains(int[] array, int lo, int hi, int target) {
        if (lo > hi || target > array[hi] || target < array[lo]) {
            return false;
        }
        int mid = lo + (hi - lo) / 2;
        if (array[mid] == target) {
            return true;
        } else if (array[mid] > target) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
        return contains(array, lo, hi, target);
    }

    @Test
    public void test() {
        FindNumbersWithSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},21);
        System.out.println(contains(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 1, 19, 20));
    }
}