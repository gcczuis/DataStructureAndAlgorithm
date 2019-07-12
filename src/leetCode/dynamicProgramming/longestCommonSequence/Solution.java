package leetCode.dynamicProgramming.longestCommonSequence;

/**
 * {@author: gcc}
 * {@Date: 2019/6/24 17:01}
 * 描述：给出两个字符串s1和s2，求这两个字符串的最长公共子序列的长度
 * 状态定义：
 * LCS(m,n)是s1[0...m]和s2[0...n]的最长公共子序列的长度
 * 状态转移方程：
 * if
 *      s1[m] = s2[n]
 * LCS(m,n) = LCS(m-1,n-1)
 * if   s1[m] != s2[n]
 * LCS(m,n) = max{LCS(m,n-1),LCS(m-1,n)}
 */
public class Solution {
}
