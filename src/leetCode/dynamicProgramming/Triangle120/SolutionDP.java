package leetCode.dynamicProgramming.Triangle120;

import java.util.Arrays;
import java.util.List;

/**
 * @author: gcc
 * @Date: 2018/9/12 17:04
 * @Description: 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 动态规划：
 *          状态：F(i,j)表示从顶元素到第i行第j个元素的最小路径和
 *          状态转移方程:F(n,j) = min{F(n-1,j) + A(n,j), F(n-1,j-1) + A(n,j)}   (0<j<n-1)
 *                            = F(n-1,j) + A(n,j)                             (j == 0)
 *                            = F(n-1,j - 1) + A(n,j)                             (j == n - 1)
 *
 */
public class SolutionDP {
    private int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new int[n][n];
        memo[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(j == 0){
                    memo[i][j] = memo[i - 1][j] + triangle.get(i).get(j);
                }
                else if(j == i){
                    memo[i][j] = memo[i - 1][j - 1] + triangle.get(i).get(j);
                }
                else{
                    memo[i][j] = Math.min(memo[i - 1][j], memo[i - 1][j - 1]) + triangle.get(i).get(j);
                }
                
            }
        }
        Arrays.sort(memo[n - 1]);
        return memo[n - 1][0];

    }


}