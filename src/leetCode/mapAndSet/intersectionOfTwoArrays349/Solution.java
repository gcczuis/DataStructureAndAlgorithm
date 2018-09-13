package leetCode.mapAndSet.intersectionOfTwoArrays349;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        List<Integer> retList = new ArrayList<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<Integer> retList2 = new ArrayList<>();
        for (Integer i : nums1) {
            set1.add(i);
        }
        for (Integer i: set1) {
            retList.add(i);
        }
        for (Integer i : nums2) {
            set2.add(i);
        }
        for (Integer j: retList) {
            if(set2.contains(j)) retList2.add(j);
        }
        int[] ret = new int[retList2.size()];
        for (int i = 0; i < retList2.size(); i++) {
            ret[i] = retList2.get(i);
        }
        return ret;
    }
}
