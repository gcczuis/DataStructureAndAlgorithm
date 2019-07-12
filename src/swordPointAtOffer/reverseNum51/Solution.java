package swordPointAtOffer.reverseNum51;

/**
 * {@author: gcc}
 * {@Date: 2019/7/4 11:03}
 */
public class Solution {
    public int InversePairs(int[] array) {
        int[] memo = new int[array.length];

        memo[0] = 0;
        for (int i = 1; i < array.length; i++) {
            int num = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] < array[j]) {
                    num++;
                }
            }
            memo[i] = memo[i - 1] + num;
        }
        return memo[array.length - 1]%1000000007;
    }
}
