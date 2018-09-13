package algorithm.advancedSort;


public class InsertionSort2 {
    private InsertionSort2() {
    }

    public static void sort(Comparable[] arr){
        //由于每一次是将当前位置元素与前一个元素作比较，而索引为0前面没有元素，所以从1开始遍历
        for (int i = 1; i < arr.length; i++) {
            //保存一个副本
            Comparable e = arr[i];
            //寻找arr[i]合适的插入位置
            for (int j = i; j > 0; j--) {
                //如果前一个数更大，则将前一个数放到后面去，与第一版（交换两个数不同）不同
                if (e.compareTo(arr[j - 1]) < 0)
                    arr[j] = arr[j - 1];
                else{
                    arr[j] = e;
                    break;
                }
            }
        }
    }
    //对arr[l...r]范围的数组进行插入排序
    //是针对归并排序的小数据情况
    public static void sort(Comparable[] arr, int l, int r){
        //由于每一次是将当前位置元素与前一个元素作比较，而索引为l前面没有元素，所以从l+1开始遍历
        for (int i = l + 1; i <= r; i++) {
            //保存一个副本
            Comparable e = arr[i];

            //寻找arr[i]合适的插入位置
            for (int j = i; j > l; j--) {
                //如果前一个数更大，则将前一个数放到后面去，与第一版（交换两个数不同）不同
                if (e.compareTo(arr[j - 1]) < 0)
                    arr[j] = arr[j - 1];
                else{
                    arr[j] = e;
                    break;
                }
            }
        }
    }

    private static void swap(Comparable[] arr, int i, int j){
        Comparable c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
