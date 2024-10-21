package org.example.剑指offer.动态规划;

/**
 * <p>Title: LCR097不同的子序列 </p >
 * <p>Description: LCR097不同的子序列 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/17 14:57
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR097不同的子序列 {
    public static void main(String[] args) {
        LCR097不同的子序列 a = new LCR097不同的子序列();
        System.out.println(a.numDistinct("", ""));
    }

    public int numDistinct(String s, String t) {
        /*获取字符串s和t的长度*/
        int m = s.length(), n = t.length();
        /*如果源字符串长度小于目标字符串，直接返回 0*/
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        /*当t是空字符串时s中有1个匹配，即空子序列*/
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                /*如果s[i]==t[j]，可以选择匹配或不匹配*/
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                }
                /*如果s[i]!=t[j],只能选择不匹配*/
                else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        /*返回dp[0][0]，即s中匹配t的子序列个数*/
        return dp[0][0];
    }


}
