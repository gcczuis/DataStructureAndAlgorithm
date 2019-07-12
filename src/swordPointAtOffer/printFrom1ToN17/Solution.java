package swordPointAtOffer.printFrom1ToN17;

import org.junit.Test;

import java.util.Arrays;

/**
 * {@author: gcc}
 * {@Date: 2019/6/27 16:19}
 * 题目：输入数字n，按顺序打印出从1到最大的n位十进制数。
 * 注意：考虑大数的情况
 * 本题的解决思路是模拟用字符串存储大数，模拟加法进行求解
 */
public class Solution {
    public void print(int n) {
//        printN(1);
//        printN(2);
        for (int i = 1; i <= n; i++) {
            printN(i);
        }
    }

    private void printN(int n) {
        char[] ret = new char[n + 1];
        Arrays.fill(ret, '0');
        ret[1] = '1';
        System.out.println(new String(ret, 1, n));
        while (!isEnd(ret)) {
            int pointer = n;
            if (ret[pointer] == '9') {
                do {
                    ret[pointer] = '0';
                    pointer--;
                }
                while (ret[pointer] == '9');
            }
            ret[pointer] = (char) (ret[pointer] + 1);
            System.out.println(new String(ret, 1, n));
        }
    }

    private boolean isEnd(char[] ret) {
        for (int i = 1; i < ret.length; i++) {
            if (ret[i] != '9') {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        print(8);
    }
}
