package org.example.剑指offer.动态规划;

/**
 * <p>Title: LCR091粉刷房子 </p >
 * <p>Description: LCR091粉刷房子 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 15:02
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR091粉刷房子 {
    public static void main(String[] args) {
        LCR091粉刷房子 a = new LCR091粉刷房子();
        System.out.println(a.minCost(new int[][]{
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}}));
    }

    /*dp[i][j]代表粉刷第i个房子刷成j颜色所需要的最小花费*/
    /*dp[i][j] = Math.min(dp[i - 1][1] + costs[i][k], dp[i - 1][2] + costs[i][l])*/
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                if (j == 0)
                    dp[i][j] = Math.min(dp[i - 1][1] + costs[i][j], dp[i - 1][2] + costs[i][j]);
                else if (j == 1)
                    dp[i][j] = Math.min(dp[i - 1][2] + costs[i][j], dp[i - 1][0] + costs[i][j]);
                else
                    dp[i][j] = Math.min(dp[i - 1][1] + costs[i][j], dp[i - 1][0] + costs[i][j]);
            }
        }
        /*取最后一个房子粉刷成三种颜色各自的最小花费的最小值*/
        return Math.min(Math.min(dp[dp.length - 1][0], dp[dp.length - 1][1]), dp[dp.length - 1][2]);
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
