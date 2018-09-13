package algorithm.advancedSort;



public class QuickSort {
    private QuickSort(){

    }

    public static void sort(Comparable[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r){
        if(r - l <= 10){
            InsertionSort2.sort(arr, l, r);
            return ;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p+1, r);
    }

    //对arr[l...r]部分进行partition操作
    //返回索引值p，使得arr[l...p-1] < arr[p];arr[p+1] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){
        //取第一个元素作为快排的分割元素
        Comparable v = arr[l];
        //理解下面这行注释至关重要
        //arr[l+1...j] < v, arr[j+1...i) >= v,i是循环中一直需要判断和v的大小的那个元素索引
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(arr[i].compareTo(v) < 0){
                swap(arr, i, j+1);
                j++;
            }
        }
        //由于arr[j] < v,而v在l（<j）的位置上，所以交换l和j
        swap(arr, l, j);
        return j;

    }

    private static void swap(Comparable[] arr, int i, int j){
        Comparable c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }


}
