package org.example.剑指offer.动态规划;

/**
 * <p>Title: LCR099最小路径和 </p >
 * <p>Description: LCR099最小路径和 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/17 15:22
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR099最小路径和 {
    public static void main(String[] args) {
        LCR099最小路径和 a = new LCR099最小路径和();
        System.out.println(a.minPathSum(new int[][]{
                {1, 2},
                {1, 1}}
        ));
    }

    public int minPathSum(int[][] grid) {
        /*dp[i][j]代表走到坐标为i,j的最小路径和*/
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        /*处理边界*/
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                /*走到坐标为i,j的最小路径和为坐标为i-1,j的最小路径和 和 坐标为i,j-1的最小路径和的最小值加上当前格子的值*/
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        /*返回走到右下角结点的最小路径和*/
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
