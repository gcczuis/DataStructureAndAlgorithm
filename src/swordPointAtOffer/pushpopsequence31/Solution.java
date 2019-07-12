package swordPointAtOffer.pushpopsequence31;

import java.util.Stack;

/**
 * {@author: gcc}
 * {@Date: 2019/7/2 10:43}
 */
public class Solution {

    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();

        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            //这两个边界条件popIndex < n && !stack.isEmpty()还是很精髓的
            while (popIndex < n && !stack.isEmpty()
                    && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
