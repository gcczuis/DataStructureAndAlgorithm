package swordPointAtOffer.firstNonDuplicateCharInStream;

import java.util.ArrayList;

/**
 * {@author: gcc}
 * {@Date: 2019/7/10 21:38}
 * 这种方法比{@link Solution}稍微垃圾一点，因为每次都要从头开始扫描整个list，不像{@link Solution}会将
 * 不满足题意的char删除从而减少遍历长度。
 */
public class Solution2 {
    private ArrayList<Character> list = new ArrayList<>();
    //存储字符出现的频率
    private int[] freq = new int[256];


    public void Insert(char ch) {
        freq[ch]++;
        list.add(ch);
    }

    public char FirstAppearingOnce() {
        for (Character ch : list) {
            if (freq[ch] == 1){
                return ch;
            }
        }
        return '#';
    }
}
