package algorithm.basicSort;

/**
 * 插入排序的第二层循环理论上能够提前终止（arr[j].compareTo(arr[j-1]) > 0），所以插入排序应该比选择排序效率更高一点
 * 但是这一版的插入排序有几个性能方面的优化空间
 *
 * 每一次比较成功(arr[j].compareTo(arr[j-1]) < 0)就要进行交换操作，而交换操作比比较操作更费时，因为每一次交换操作需要进行
 * 三次赋值的操作,而且对于数组来说还有访问数组相应位置元素所耗费的时间。
 *
 * 能不能改进算法，让他在内层的循环中只交换一次呢？
 *
 * 请看插入排序第二版
 *
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void sort(Comparable[] arr){
        //由于每一次是将当前位置元素与前一个元素作比较，而索引为0前面没有元素，所以从1开始遍历
        for (int i = 1; i < arr.length; i++) {
            //寻找arr[i]合适的插入位置
            for (int j = i; j > 0; j--) {
                if(arr[j].compareTo(arr[j-1]) < 0){
                    swap(arr, j, j-1);
                }
                else break;
            }
            
        }
    }

    private static void swap(Comparable[] arr, int i, int j){
        Comparable c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
