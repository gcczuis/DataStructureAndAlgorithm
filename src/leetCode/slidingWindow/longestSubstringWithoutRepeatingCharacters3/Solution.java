package leetCode.slidingWindow.longestSubstringWithoutRepeatingCharacters3;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = -1, ret = 0;
        int[] freq = new int[256];
        //滑动窗口区间为[start...end]
        while (start < s.length()){
            if((end + 1) < s.length() && freq[s.charAt(end + 1)] == 0){
                freq[s.charAt(++end)]++;
            }
            else{
                freq[s.charAt(start++)]--;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret;


    }
}
