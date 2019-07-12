package leetCode.sort.mergeSortedArray88;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = Arrays.copyOf(nums1, m);
        int length = nums1.length;
        int j = 0, k = 0, i = 0;//j是nums3的索引， k是nums2的索引 ,i是nums1的索引
        while(i < length){
            if(j == nums3.length)   nums1[i++] = nums2[k++];
            else if(k == nums2.length)   nums1[i++] = nums3[j++];
            else if(nums3[j] > nums2[k]) nums1[i++] = nums2[k++];
            else if(nums3[j] <= nums2[k]) nums1[i++] = nums3[j++];

        }
    }
}
