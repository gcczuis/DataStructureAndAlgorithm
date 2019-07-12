package swordPointAtOffer.getNumOfK;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * {@author: gcc}
 * {@Date: 2019/7/4 14:41}
 */
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        int sum = 0;
        int d = find(0, array.length - 1, array, k);
        System.out.println(d);
        if (d < 0)
            return 0;

        sum++;
        int i = d - 1;
        int j = d + 1;
        while (i >= 0 && array[i] == k) {
            sum++;
            i--;
        }
        while (j < array.length && array[j] == k) {
            sum++;
            j++;
        }
        return sum;
    }

    //返回找到的第一个等于target的数组中的元素的索引
    private int find(int lo, int hi, int[] arr, int target) {
        if (lo > hi || target > arr[hi] || target < arr[lo]) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
        return find(lo, hi, arr, target);
    }

    @Test
    public void test() {
        System.out.println(GetNumberOfK(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, 20));
    }
}
