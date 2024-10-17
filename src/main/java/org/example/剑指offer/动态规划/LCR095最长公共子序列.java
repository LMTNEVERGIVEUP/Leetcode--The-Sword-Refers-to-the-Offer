package org.example.剑指offer.动态规划;

/**
 * <p>Title: LCR095最长公共子序列 </p >
 * <p>Description: LCR095最长公共子序列 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/17 13:32
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR095最长公共子序列 {
    public static void main(String[] args) {
        LCR095最长公共子序列 a = new LCR095最长公共子序列();
        System.out.println(a.longestCommonSubsequence("abcde", "ace"));
    }

    /*dp[i][j]代表字符串text1[0，i)和字符串text2[0,j)存在的最长公共子序列*/
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length() + 1; i++) {
            for (int j = 0; j < text2.length() + 1; j++) {
                /*如果处于边界，那么值为0*/
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    /*字符串text1 i-1和字符串text2 j-1位置的字符一致*/
                    if (text1.charAt(i - 1) == text2.charAt(j - 1))
                        /*那么字符串text1[0，i)和字符串text2[0,j)存在的最长公共子序列的长度为字符串text1[0，i-1)和字符串text2[0,j-1)存在的最长公共子序列+1*/
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        /*否则选择字符串text1[0，i-1)和字符串text2[0,j)存在的最长公共子序列的长度和字符串text1[0，i)和字符串text2[0,j-1)存在的最长公共子序列的长度的最大值*/
                    else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }
        /*返回最大值*/
        return dp[text1.length()][text2.length()];
    }
    /*时间复杂度o(n^2)，空间复杂度o(n)*/
}
