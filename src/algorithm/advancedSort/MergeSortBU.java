package algorithm.advancedSort;

public class MergeSortBU {

    //辅助数组
    private static Comparable[] aux;

    private MergeSortBU() {
    }

    /**
     *
     * @param arr 要排序的数组
     */
    public static void sort(Comparable[] arr){
        int n = arr.length;
        //辅助数组初始化
        aux = new Comparable[n];
        for (int sz = 1; sz <= n; sz += sz) {
            //因为是归并排序，所以至少要归并两部分的数据（不然只有一部分的数据，这部分数据已经是有序的了就不用归并了），
            // 所以要i+sz<n,这样也保证了i+sz-1不越界
            for (int i = 0; i + sz < n; i += sz + sz) {
                //对arr[i...i+sz-1]和arr[i+sz...i+1*sz-1]进行归并
                //对归并到比较靠后的元素集时，最后的元素集很有可能不足数，这对merge操作无影响，但要注意i+sz+sz-1不要越界！
                merge(arr, i, i + sz - 1, Math.min(i + sz +sz - 1, n-1));
            }
            
        }

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
