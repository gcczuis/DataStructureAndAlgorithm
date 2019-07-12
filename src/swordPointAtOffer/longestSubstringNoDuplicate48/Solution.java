package swordPointAtOffer.longestSubstringNoDuplicate48;

import java.util.Arrays;

/**
 * {@author: gcc}
 * {@Date: 2019/7/10 21:00}
 */
public class Solution {

    public int longestSubStringWithoutDuplication(String str) {

        //维持一个以索引i对饮字符结尾的最大不重复子串的长度
        int curLen = 0;
        int maxLen = 0;
        //记录str中字符上次出现的索引
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);

        for (int curIndex = 0; curIndex < str.length(); curIndex++) {
            int c = str.charAt(curIndex) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curIndex - preI >= curLen) {
                curLen++;
            } else {//此时该子串不重复条件被破坏，更新maxLen和curLen值
                maxLen = Math.max(maxLen, curLen);
                curLen = curIndex - preI;
            }
            preIndexs[c] = curIndex;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
