package algorithm.advancedSort;

//比第三版更好地解决大量重复元素的一种三路快速排序的实现
//三路快速排序处理arr[l...r]
//将arr[l...r]分为 <v ; ==v; >v三部分
//之后递归对<v和>v两部分继续进行三路快速排序

public class QuickSort3Ways {
    private QuickSort3Ways(){

    }

    public static void sort(Comparable[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r){
        if(r - l <= 10){
            InsertionSort2.sort(arr, l, r);
            return ;
        }
        //由于需要返回两个下标，所以就不封装partition函数了
        //partition
        //随机取一个元素作为快排的分割元素
        swap(arr, l, (int)(Math.random()*(r-l+1))+l);
        Comparable v = arr[l];
        //从始至终保持下面三行注释性质不变很重要
        int lt = l;//arr[l+1...lt] < v
        int gt = r + 1;//arr[gt...r] > v
        int i = l + 1;//arr[lt+1...i) == v
        while(i < gt){
            if(arr[i].compareTo(v) < 0){
                swap(arr, lt + 1, i);
                lt ++;
                i ++;
            }
            else if(arr[i].compareTo(v) > 0){
                swap(arr, i, gt - 1);
                gt --;
            }
            else{//arr[i] == v
                i ++;
            }
        }
        swap(arr, l, lt);
        //swap之后三个区间分别为[l, lt-1][lt,gt)[gt,r]
        sort(arr, l, lt - 1);
        sort(arr, gt, r);


    }



    private static void swap(Comparable[] arr, int i, int j){
        Comparable c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }


}
