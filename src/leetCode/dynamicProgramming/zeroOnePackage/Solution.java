package leetCode.dynamicProgramming.zeroOnePackage;

/**
 * {@author: gcc}
 * {@Date: 2019/6/23 19:50}
 * 问题描述：
 * 有一个背包，它的容量为C(Capacity).现有n中不同的物品，编号为0...n-1,其中每一件物品的重量为w(i),价值为v(i)。问可以向这个背包中盛放哪些物品，使得在不超过背包容量的基础上，物品的总价值最大。
 *
 * 状态:DP(n,c)考虑将n个物品放进容量为C的背包，使得价值最大
 * DP(i,c) = max{DP(i-1,c),v(i)+DP(i-1,c-v(i))}
 *
 */
public class Solution {

}
