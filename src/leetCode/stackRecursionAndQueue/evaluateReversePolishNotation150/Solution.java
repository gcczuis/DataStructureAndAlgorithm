package leetCode.stackRecursionAndQueue.evaluateReversePolishNotation150;

import java.util.Stack;

/**
 * {@author: gcc}
 * {@Date: 2019/6/19 10:19}
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isNum(token)){
                stack.push(token);
            }else {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                Integer res = caculate(first, second, token);
                stack.push(res.toString());
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private int caculate(int first, int second, String token) {
        if(token.equals("*"))
            return first * second;
        else if(token.equals("/"))
            return first/second;
        else if(token.equals("+"))
            return first+second;
        else// (token.equals("-"))
            return first - second;
    }


    private boolean isNum(String str) {
        return !(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }
}
