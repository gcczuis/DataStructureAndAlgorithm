package leetCode.mapAndSet.intersectionOfTwoArrays349;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();
        Arrays.stream(nums1).forEach(set1::add);
        Arrays.stream(nums2).forEach(set2::add);

        int[] ret = set1.stream().filter(set2::contains).mapToInt(Integer::intValue).toArray();
        return ret;
    }
}
