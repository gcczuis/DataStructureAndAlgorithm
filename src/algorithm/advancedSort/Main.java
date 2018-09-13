package algorithm.advancedSort;

import java.util.Arrays;

public class Main {
    private static int n = 2000000;

    public static void main(String[] args){
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 100000);
//        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        //在数组近乎有序的情况下插入排序的效率是非常高的
//        Integer[] arr4 = SortTestHelper.generateNearlyOrderedArray(n, 20);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);

        SortTestHelper.testSort("algorithm.advancedSort.QuickSort",arr);
        SortTestHelper.testSort("algorithm.advancedSort.QuickSort3Ways",arr5);


    }


}
