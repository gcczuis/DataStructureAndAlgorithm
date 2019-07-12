package leetCode.dynamicProgramming.decodeWays91;

/**
 * @author: gcc
 * @Date: 2018/9/13 14:54
 * @Description: 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 思路：动态规划：
 * 状态：dp(k)表示长度为k的字符串的解码方法总数
 * <p>
 * （1）当0<d<=26，如果d%10!=0，有两种方式到达第i个字符（从第i-1字符加一个字符达到、从第i-2个字符加一个字符达到），即f(s.charAt(i))=f(s.charAt(i-1))+f(s.charAt(i-2))；如果i%10=0,则只有一种方式达到f(s.charAt(i))=f(s.charAt(i-2))
 * <p>
 * （2）当d>26,如果d%10!=0,则一种方法到达i点（即从i-1到达i），f(s.charAt(i))=f(s.charAt(i-1))；如果d%10=0,则没有对应的编码表达d这两个字符，所以直接return 0
 * <p>
 * （3）d==0的时候，字符串中出现了两个连续的0，直接return 0
 * <p>
 * 对于字符串的前两个数字字符单独处理，分类同上，然后遍历字符串就可以得到最终结果。
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }

        int n = s.length();
        int[] dp = new int[n];


        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        //dp[1]贼麻烦，主要还是这题目不是从0开始的导致这么麻烦
        if (s.charAt(0) == '0') {
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
        } else {
            if (s.charAt(1) != '0') {
                dp[1]++;
            }
            Integer second = Integer.valueOf(s.substring(0, 2));
            if (second >= 10 && second <= 26) {
                dp[1]++;
            }
        }

        for (int i = 2; i < n; i++) {
            int first = Integer.valueOf(s.substring(i, i + 1));
            int second = Integer.valueOf(s.substring(i - 1, i + 1));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n - 1];
    }
}
