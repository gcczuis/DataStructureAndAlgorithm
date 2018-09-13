package algorithm.advancedSort;

//第一、二版问题：当数组元素有很多是相同元素时，如果取定相同元素作为标定点，那么会让其他相同元素全部落入同一个区间，造成左右两个区间长度不平衡，
//严重时会退化成一个链表


public class QuickSort3 {
    private QuickSort3(){

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

        //随机取一个元素作为快排的分割元素
        swap(arr, l, (int)(Math.random()*(r-l+1))+l);
        Comparable v = arr[l];
        //理解下面这行注释至关重要
        //arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;
        while(true){
            while(i <= r && arr[i].compareTo(v) < 0) i++;
            while(j >= l + 1 && arr[j].compareTo(v) > 0) j--;
            //表示左右两边已经有序。
            if(i > j) break;
            swap(arr, j, i);
            i ++;
            j --;
        }
        //while循环后i指针指在右半边的最左边元素，j指针指在左半边的最右边元素
        swap(arr, l, j);
        return j;
    }

    private static void swap(Comparable[] arr, int i, int j){
        Comparable c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }


}
