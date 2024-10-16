package org.example.剑指offer.动态规划;

/**
 * <p>Title: LCR088使用最小花费爬楼梯 </p >
 * <p>Description: LCR088使用最小花费爬楼梯 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 14:12
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR088使用最小花费爬楼梯 {
    public static void main(String[] args) {
        LCR088使用最小花费爬楼梯 a = new LCR088使用最小花费爬楼梯();
        System.out.println(a.minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    /*动态规划*/
    /*dp[i]代表爬到第i个台阶需要的最小花费*/
    /*dp[i]=Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1])*/
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], 0);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[dp.length - 1];
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
