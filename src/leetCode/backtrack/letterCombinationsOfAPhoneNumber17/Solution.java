package leetCode.backtrack.letterCombinationsOfAPhoneNumber17;

import java.util.ArrayList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/21 10:33}
 * 画出树形模型，搞清回溯策略，定义清楚递归函数
 */
public class Solution {
    private String[] strArr = {null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty() || digits == null) {
            return res;
        }
        combineLetters(digits, 0, "");
        return res;
    }

    //tempRes中保存了此时从digits[0....start-1]翻译得到的一个字母字符串
    //寻找和digits[start]匹配的字母，获得digits[0...start]翻译得到的解
    private void combineLetters(String digits, int start, String tempRes) {
        if (tempRes.length() == digits.length()) {
            res.add(tempRes);
            return;
        }

        String str = strArr[digits.charAt(start) - '0'];
        for (int i = 0; i < str.length(); i++) {
            combineLetters(digits, start + 1, tempRes + str.charAt(i));
        }
    }
}
