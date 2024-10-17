package org.example.剑指offer.动态规划;

/**
 * <p>Title: LCR098 </p >
 * <p>Description: LCR098 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/17 14:58
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR098不同路径 {
    public static void main(String[] args) {
        LCR098不同路径 a = new LCR098不同路径();
        System.out.println(a.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        /*dp[i][j]代表走到坐标为i,j的路径数*/
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /*处理边界*/
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                }
                /*走到坐标为i,j的路径数为走到坐标为i-1,j的路径数（再向下走一步到）加上坐标为i,j-1的路径数（再向右走一步到）*/
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
