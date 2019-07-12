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
 * 这个算法是可行的，但时间复杂度和空间复杂度比较高
 */
public class SolutionDP {
    //memo[i][j]指的是考虑前j个面值来凑足金钱i所需要的最少的钱币数量
    int memo[][];

    public int coinChange(int[] coins, int amount) {

        int[] newCoins = fillCoins(coins, amount);
        memo = new int[newCoins.length][amount + 1];
        for (int i = 0; i < memo.length; i++) {
            //初始化值设为10000，一个比较大的数
            Arrays.fill(memo[i], 10000);
        }
        //0块钱，不需要凑足，所以初始化为0
        for (int i = 0; i < memo.length; i++) {
            memo[i][0] = 0;
        }
        for (int i = 1; i <= amount; i++) {
            memo[0][i] = (i == newCoins[0]) ? 1 : 10000;
        }

        for (int i = 1; i < newCoins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= newCoins[i]) {
                    memo[i][j] = Math.min(memo[i][j], Math.min(memo[i - 1][j], 1 + memo[i - 1][j - newCoins[i]]));
                } else {
                    memo[i][j] = Math.min(memo[i][j], memo[i - 1][j]);
                }
            }
        }
        //可能10000会加加减减，所以阈值设为1000
        return memo[newCoins.length - 1][amount] > 1000 ? -1 : memo[newCoins.length - 1][amount];

    }

    //填充一个新的coins数组，比如[1,2,5] 11
    //因为纸币数量无限，所以我们可以新建一个[1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,5,5]
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
