package algorithm.basicSort;

import java.util.Arrays;

public class Main {
    private static int n = 60000;

    public static void main(String[] args){
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        //在数组近乎有序的情况下插入排序的效率是非常高的
        Integer[] arr4 = SortTestHelper.generateNearlyOrderedArray(n, 80);

        SortTestHelper.testSort("algorithm.basicSort.InsertionSort",arr);
        SortTestHelper.testSort("algorithm.basicSort.SelectionSort",arr2);
        SortTestHelper.testSort("algorithm.basicSort.InsertionSort2",arr3);
        SortTestHelper.testSort("algorithm.basicSort.InsertionSort2",arr4);
        System.out.println(SortTestHelper.isSorted(arr));
        System.out.println(SortTestHelper.isSorted(arr2));
        System.out.println(SortTestHelper.isSorted(arr3));
        System.out.println(SortTestHelper.isSorted(arr4));


    }


}
