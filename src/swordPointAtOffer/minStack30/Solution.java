package swordPointAtOffer.minStack30;

import java.util.Stack;

/**
 * {@author: gcc}
 * {@Date: 2019/6/29 10:53}
 */
public class Solution {
    private Stack<Integer> stack =
            new Stack<>();
    private Stack<Integer> helper = new Stack<>();


    public void push(int node) {
        //避免一开始helper为空的情况

        int peek = Integer.MAX_VALUE;
        if (!helper.isEmpty()) {
            peek = helper.peek();
        }

        if (node < peek) {
            helper.push(node);
        } else {
            helper.push(peek);
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return helper.peek();
    }
}
