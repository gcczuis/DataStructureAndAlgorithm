package leetCode.backtrack.palindromePartitioning131;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/21 15:30}
 *
 */
public class Solution {
    private List<List<String>> res = new ArrayList<>();


    public List<List<String>> partition(String s) {
        part(s,0,new ArrayList<>());
        return res;
    }

    //tempRes保存str[0....start-1]中的回文串
    //求从str的index位置开始的回文串的解
    private void part(String str, int start, List<String> tempRes) {
        if (start == str.length()) {
            res.add(new ArrayList<>(tempRes));
            return;
        }

        for (int i = start; i < str.length(); i++) {
            String para = str.substring(start, i + 1);
            //注意下：这里每次都要冲
            if (isPalindrome(para)) {
                tempRes.add(para);
                part(str, i + 1, tempRes);
                //这里不能写tempREs.remove(para)因为可能list中已经存在了多个para，可能会删除错误的para导致最后结果顺序出现错乱
                tempRes.remove(tempRes.size() - 1);
            }
        }
    }


    //str是否是回文字符串，如"s","ss","121"
    private boolean isPalindrome(String str) {
        if (str.isEmpty() || str == null) {
            return false;
        }
        int l = 0;
        int r = str.length() - 1;

        while (l <= r) {
            char lChar = str.charAt(l++);
            char rChar = str.charAt(r--);
            if (lChar != rChar) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPalindrome() {
        System.out.println(isPalindrome("1"));
    }
}
