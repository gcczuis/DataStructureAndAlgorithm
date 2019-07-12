package algorithm.basicSort;

public class SelectionSort {

    private SelectionSort() {
    }

    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //获取i索引之后的最小值所在索引存入minIndex中
            for (int j = i; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Comparable[] arr, int i, int j){
        Comparable c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
