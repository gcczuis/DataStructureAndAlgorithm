package algorithm.advancedSort;

import java.util.Arrays;

public class MergeSort {

    //辅助数组
    private static Comparable[] aux;

    private MergeSort() {
    }

    /**
     *
     * @param arr 要排序的数组
     */
    public static void sort(Comparable[] arr){
        int n = arr.length;
        //辅助数组初始化
        aux = new Comparable[n];
        //左边界是0，右边界是n-1
        sort(arr, 0, n-1);

    }

    //递归使用归并排序，对arr[l....r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){
        if(l >= r)
            return;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        //归并左右两部分
        merge(arr, l, mid, r);
    }


    private static void merge(Comparable[] arr, int l, int mid, int r){
        for (int i = l; i <= r ; i++) {
            aux[i] = arr[i];
        }
        //初始化，i指向aux左半部分的初始索引，j指向aux右半部分的初始索引
        int i = l, j = mid + 1;
        //k指向arr的索引
        for (int k = l; k <= r; k++) {
            //如果左半部分全部遍历完
            if(i > mid)                             arr[k] = aux[j++];
            //如果左半部分全部遍历完
            else if(j > r)                          arr[k] = aux[i++];
            //加了<=而不是单纯的<可以使得排序后的数组仍然稳定（相同元素排序前后的相对位置不发生改变）
            else if(aux[i].compareTo(aux[j]) <= 0)   arr[k] = aux[i++];
            //aux[i-l].compareTo(aux[j-l]) > 0
            else                                    arr[k] = aux[j++];


            
        }


    }
}
