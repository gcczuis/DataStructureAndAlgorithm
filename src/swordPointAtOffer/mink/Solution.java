package swordPointAtOffer.mink;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * {@author: gcc}
 * {@Date: 2019/7/2 19:03}
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        if (k > input.length || k <= 0) {
            return ret;
        }

        for (int i = 0; i < k; i++) {
            queue.add(input[i]);
        }

        for (int i = k; i < input.length; i++) {
            if (queue.peek() > input[i]) {
                queue.poll();
                queue.offer(input[i]);
            }
        }

        ret.addAll(queue);
        return ret;
    }
}
