package leetCode.collisionPointer.containerWithMostWater11;
//最优方法原理：
//
//1利用2个指针来表示Area的起始，和终止的位置，
//
//2根据(Area的面积中height由2条边中最小的一条的长度决定)
//
//3.Area面积在高度不变的情况下，宽度越大，面积越来越大
//
//4Area面积在宽度变小的情况下，只有可能高度变大，面积才有可能变大
public class Solution {
    private  boolean isCaculateRes = true;
    public  int maxArea(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            if(isCaculateRes){
                //还存在优化空间，不用每次循环都算res只有新的height > 旧的height 才算res
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
                isCaculateRes = false;
            }
            //Area的面积中height由2条边中最小的一条的长度决定,所以要移动短的那一条边的索引值
            if (height[i] < height[j]) {
                if(height[i+1] > height[i])
                    isCaculateRes = true;
                ++i;
            }
            else {
                if(height[j-1] > height[j])
                    isCaculateRes = true;
                --j;
            }
        }
        return res;
    }

 /*   public static void main(String[] args){
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }*/
}