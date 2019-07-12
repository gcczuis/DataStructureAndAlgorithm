package leetCode.stackRecursionAndQueue.validParentheses20;

import java.util.HashSet;
import java.util.Stack;

/**
 * {@author: gcc}
 * {@Date: 2019/6/19 09:57}
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set1 = new HashSet<>();
        set1.add('(');
        set1.add('{');
        set1.add('[');
        HashSet<Character> set2 = new HashSet<>();
        set2.add(')');
        set2.add(']');
        set2.add('}');
        for (int i = 0; i < s.length(); i++) {
            if (set2.contains(s.charAt(i))){
                if(stack.isEmpty())
                    return false;
                Character pop = stack.pop();
                if(s.charAt(i)==')'&&pop=='(' || s.charAt(i)==']'&&pop=='[' || s.charAt(i)=='}'&&pop=='{')
                    continue;
                else
                    return false;
            }else
                stack.push(s.charAt(i));
        }
        if (!stack.isEmpty())
            return false;

        return true;

    }
}
