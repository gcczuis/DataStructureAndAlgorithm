package leetCode.dynamicProgramming.decodeWays91;

/**
 * @author: gcc
 * @Date: 2018/9/13 14:54
 * @Description: 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 思路：动态规划：
 *              状态：dp(k)表示长度为k的字符串的解码方法总数
 *              状态转移方程：dp(k) = dp(k - 1) + 1  (最后两位数字>26)
 */
public class Solution {
    public int numDecodings(String s) {
        return 0;
    }

}
