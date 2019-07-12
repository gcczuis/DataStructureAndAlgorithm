package leetCode.dynamicProgramming.wordBreak139;

import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/24 09:59}
 * 状态：
 * DP(i) = canBePinJie(s.subString(0,i+1)),str能否被拼接
 * 状态转移方程：
 * DP(i) = DP(j)&&wordDict.contains(s.subString(j+1,i+1))    j from 0 to i-1,这是或者的关系，只要有一个j使得DP(i)成立，DP(i) 就为true
 */
public class Solution {
    private boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new boolean[s.length() + 1];
        //设置组成空串总是成功的
        memo[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                //下面的索引确定比较麻烦，需要在纸上模拟一下
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }
}
