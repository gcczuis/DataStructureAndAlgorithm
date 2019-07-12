package leetCode.dynamicProgramming.Triangle120;

import java.util.Arrays;
import java.util.List;

/**
 * @author: gcc
 * @Date: 2018/9/12 17:04
 * @Description: 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 动态规划：
 * 状态：F(i,j)表示从顶元素到第i行第j个元素的最小路径和
 * 状态转移方程:F(n,j) = min{F(n-1,j) + A(n,j), F(n-1,j-1) + A(n,j)}   (0<j<n)
 * = F(n-1,j) + A(n,j)                             (j == 0)
 * = F(n-1,j - 1) + A(n,j)                         (j == n)
 * 其中n和j都是起始为0的索引号
 */
public class Solution {
    private int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] lastLine = new int[triangle.size()];
        memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];

        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            lastLine[i] = minimum(triangle, triangle.size() - 1, i);
        }

        Arrays.sort(lastLine);
        return lastLine[0];
    }

    private int minimum(List<List<Integer>> triangle, int x, int y) {
        if (x == 0 && y == 0) {
            return triangle.get(0).get(0);
        }

        if (memo[x][y] == 0) {
            if (y == 0) {
                memo[x][y] = triangle.get(x).get(y) + minimum(triangle, x - 1, y);
            } else if (y == x) {
                memo[x][y] = triangle.get(x).get(y) + minimum(triangle, x - 1, y - 1);
            } else {
                memo[x][y] = triangle.get(x).get(y) + Math.min(minimum(triangle, x - 1, y), minimum(triangle, x - 1, y - 1));
            }
        }

        return memo[x][y];
    }
}
