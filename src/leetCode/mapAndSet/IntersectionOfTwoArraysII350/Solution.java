package leetCode.mapAndSet.IntersectionOfTwoArraysII350;

import java.util.*;

public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums1)
                .forEach(i-> map.merge(i, 1, Integer::sum));
        Arrays.stream(nums2)
                .forEach(i->{
                    if(map.get(i)!=null&&map.get(i)!=0){
                        map.computeIfPresent(i,(key,oldvalue)->oldvalue-1);
                        list.add(i);
                    }
                });
        return list.stream().mapToInt(i->i).toArray();


















       /* ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i: nums1) {
            if(map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i,1);
        }
        for (Integer i: nums2) {
            Integer j = map.get(i);
            if(j != null && j >= 1) {
                list.add(i);
                map.put(i, j - 1);
            }

        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;*/
    }

}
