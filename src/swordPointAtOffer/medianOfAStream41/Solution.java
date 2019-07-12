package swordPointAtOffer.medianOfAStream41;

import java.util.PriorityQueue;

/**
 * {@author: gcc}
 * {@Date: 2019/7/10 19:28}
 */
public class Solution {
    //大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int count = 0;

    public void Insert(Integer num) {

        //两边堆的数量相同则优先放进左边的堆中
        if (count % 2 == 0) {
            //由于就算放进左边可能该数也不会大于右边的全部数值，
            //所以先放入右边，再从右边拿出最大的数值放入左边，这样就满足题意了
            right.add(num);
            left.add(right.poll());
        } else {
            left.add(num);
            right.add(left.poll());
        }
        count++;

    }

    public Double GetMedian() {

        if (count % 2 == 0) {
            return (right.peek() + left.peek()) / 2.0;
        } else {
            return (double) left.peek();
        }
    }

}
