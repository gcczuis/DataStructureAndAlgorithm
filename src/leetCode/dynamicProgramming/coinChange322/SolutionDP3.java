package leetCode.dynamicProgramming.coinChange322;


import org.junit.Test;

/**
 * {@author: gcc}
 * {@Date: 2019/6/26 16:17}
 * DP(i,m)表示考虑前i个面值来凑足金钱m所需要的最少的钱币数量
 * 状态转移方程：
 * DP(i,m) = min{DP(i-1,m),min{DP(i-1,m-coins[i]*k)+k}}
 * k为选取的第i个面值的数目，1<=k<(amount/coins[i])
 */
public class SolutionDP3 {
    //memo[i][j]指的是考虑前j个面值来凑足金钱i所需要的最少的钱币数量
    int memo[][];

    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length][amount + 1];
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) {
                memo[0][j] = j / coins[0];
            } else {
                memo[0][j] = 100;

            }
        }
        for (int i = 0; i < coins.length; i++) {
            memo[i][0] = 0;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int min = Integer.MAX_VALUE;
                if (j >= coins[i]) {
                    for (int k = 1; k <= j / coins[i]; k++) {
                        min = Integer.min(min, k + memo[i - 1][j - coins[i] * k]);
                    }
                }
                memo[i][j] = Integer.min(min, memo[i - 1][j]);
            }
        }
        return memo[coins.length - 1][amount] >= 100 ? -1 : memo[coins.length - 1][amount];
    }

    @Test
    public void test() {
        int ret = coinChange(new int[]{2, 5, 11}, 27);
        System.out.println(ret);
    }

}
