package leetCode.dynamicProgramming.coinChange322;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 21:17}
 * 典型的背包问题，在n个物品中选出一定物品，填满amount的背包
 * 状态：DP(n,c)考虑n个物品,看填满容量为C的背包最少需要几个物品
 * DP(i,c) = min{DP(i-1,c),DP(i-1,c-w(i))+1}
 *
 * 不能AC，不知道问题出在哪，不过SolutionDP3的做法显然是更好的方法
 */
public class Solution {
    int memo[][];

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] newCoins = fillCoins(coins, amount);
        memo = new int[newCoins.length][amount + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], 10000);
        }
        return coinDP(newCoins, newCoins.length - 1, amount);

    }

    private int coinDP(int[] newCoins, int coinEnd, int amount) {
        if (coinEnd == 0) {
            return memo[coinEnd][amount] = (amount == newCoins[coinEnd] ? 1 : 0);
        }
        if (memo[coinEnd][amount] < 1000) {
            return memo[coinEnd][amount];
        }
        if (amount == 0) {
            return memo[coinEnd][amount] = 0;
        } else {
            int dp1 = coinDP(newCoins, coinEnd - 1, amount);
            if (amount >= newCoins[coinEnd]) {
                int dp2 = coinDP(newCoins, coinEnd - 1, amount - newCoins[coinEnd]);
                memo[coinEnd][amount] = Math.min(dp1, dp2 + 1);

            } else {
                memo[coinEnd][amount] = dp1;
            }
        }
        return memo[coinEnd][amount];
    }

    private int[] fillCoins(int[] coins, int amount) {
        int[] size = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            //如果给出的acount为1，纸币只有2块，那么应该保留一张2块的纸币，
            size[i] = (amount / coins[i] == 0 ? 1 : amount / coins[i]);
        }
        int sumSize = IntStream.of(size).sum();
        int[] ret = new int[sumSize];

        for (int i = 0, k = 0; i < coins.length; i++) {
            for (int j = 0; j < size[i]; j++, k++) {
                ret[k] = coins[i];
            }
        }
        return ret;
    }
    @Test
    public void testfillcoin() {
        int[] ints = fillCoins(new int[]{2}, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
