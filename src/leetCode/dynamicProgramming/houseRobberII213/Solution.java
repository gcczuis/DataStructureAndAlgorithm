package leetCode.dynamicProgramming.houseRobberII213;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 16:55}
 * 虽然整个n个房子连成了一个环形，但我们还是可以将他们分开
 * 因为每一栋房子有两种策略，抢劫或者不抢劫，我们采用谈论最后一栋房子(n-1)是否被抢劫来将问题划分
 * 1. 最后一栋(n-1)房子被抢劫，那么，0和n-2下标的房子都不能被抢劫所以我们只需要考虑抢劫
 * 1...n-3+nums[n-1]获得的收益
 * 2. 最后一栋(n-1)房子没有被抢劫，那么考虑抢劫0...n-2获得的收益
 * 取最大值
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];
        //from 0 to n-2
        System.arraycopy(nums, 0, arr1, 0, nums.length - 1);
        if (nums.length >= 4) {
            //from 1 to n-3
            System.arraycopy(nums, 1, arr2, 0, nums.length - 3);
            return Math.max(robb(arr1), robb(arr2) + nums[nums.length - 1]);
        } else {
            return Math.max(robb(arr1), nums[nums.length - 1]);
        }
    }

    //复用houseRobber198的代码
    private int robb(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
        }
        return memo[nums.length];
    }
}
