package swordPointAtOffer.changeOneNumberBinaryToAnotherNum15;

import org.junit.Test;

/**
 * {@author: gcc}
 * {@Date: 2019/6/27 15:38}
 * 问题描述：
 * 输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n。比如10的二进制表示为1010,13的二进制表示为1101，需要改变1010的3位才能得到1101.
 *
 * 思路：
 * 我们可以分成两步来解决这个问题
 * 1. 求这两个数的亦或
 * 2. 统计亦或结果中1的位数
 */
public class Solution {
    public int calculate(int m,int n){
        int oneNum = m ^ n;
        return NumberOf1(oneNum);
    }

    private int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag!=0) {
            if ((flag & n)!=0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(calculate(10,13));

    }
}

