package swordPointAtOffer.firstNonDuplicateCharInStream;

import java.util.LinkedList;

/**
 * {@author: gcc}
 * {@Date: 2019/7/10 21:38}
 * 一种比较巧妙的方法
 */
public class Solution {
    private LinkedList<Character> queue = new LinkedList<>();
    //存储字符出现的频率
    private int[] freq = new int[256];

    public void Insert(char ch) {
        freq[ch]++;
        queue.addLast(ch);
        //从queue中剔除频率>1的元素，但是freq[i]不会--，因为要queue中的元素删除了要在freq中保存频率信息
        while (!queue.isEmpty() && freq[queue.peek()] > 1)
            queue.poll();
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
