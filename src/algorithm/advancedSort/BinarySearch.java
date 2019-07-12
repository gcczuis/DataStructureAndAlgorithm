package algorithm.advancedSort;


/**
 * {@author: gcc}
 * {@Date: 2019/5/23 10:15}
 */
public class BinarySearch {
    //从[l,r]的范围内查找target
    public static <T extends Comparable> int binarySearch(T[] arr, int l, int r, T target) {
        if (target.compareTo(arr[l]) < 0
                || target.compareTo(arr[r]) > 0
                || l > r) return -1;
        int mid = l + (r - l) / 2;
        if (arr[mid].compareTo(target) == 0)
            return mid;
        else if (arr[mid].compareTo(target) > 0)
            l = mid;
        else if (arr[mid].compareTo(target) < 0)
            r = mid;
        return binarySearch(arr, l, r, target);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(arr, 0, 7, 10));
    }
}
