package leetCode.stackRecursionAndQueue.topKFrequentElements347;

import org.junit.Test;

import java.util.*;

/**
 * {@author: gcc}
 * {@Date: 2019/6/28 09:23}
 * 这题很重要
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int num : nums) {
            int count = counterMap.getOrDefault(num, 0);
            counterMap.put(num, count + 1);
        }

        //pq的优先规则是跟比较器相关的，默认的整形比较器是递增的，所以默认是个最小堆，正好符合我们的需求
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            if (pq.size() == k) {
                //新加的值如果小于最小(堆顶)的值，直接pass，如果大于最小(堆顶)的值，则删除堆顶值放入新加的值
                if (entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }
            } else {
                pq.offer(entry);
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }
        return res;
    }


    //测试默认是最小堆，siftup操作是如果当前元素comparator.compare(a, 父亲元素或者儿子元素)<0,表示可以上浮。
    @Test
    public void testPQ(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        pq.offer(1);
        pq.offer(3);
        pq.offer(2);
        pq.offer(5);
        pq.offer(6);
        pq.offer(2);
        pq.offer(8);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }


    }
}
