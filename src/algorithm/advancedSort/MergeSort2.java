package algorithm.advancedSort;


/**
 * 由于在测试用例中发现当测试数据近乎有序的时候，插入排序比归并排序更快
 * 所以产生了优化
 */
public class MergeSort2 {

    //辅助数组
    private static Comparable[] aux;

    private MergeSort2() {
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
        //优化2：在较小的数据量情况下，插入排序比需要大量递归的归并排序性能要好
        if(r - l <= 15){
            InsertionSort2.sort(arr, l, r);
            return ;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
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
            else if(aux[i].compareTo(aux[j]) < 0)   arr[k] = aux[i++];
                //aux[i-l].compareTo(aux[j-l]) >= 0
            else                                    arr[k] = aux[j++];



        }


    }
}
