package org.lmt.剑指offer.动态规划;

import java.util.Arrays;

/**
 * <p>Title: LCR094分割回文串 </p >
 * <p>Description: LCR094分割回文串 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/17 13:32
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR094分割回文串 {
    public static void main(String[] args) {
        LCR094分割回文串 a = new LCR094分割回文串();
        System.out.println(a.minCut("aab"));
    }

    public int minCut(String s) {
        int n = s.length();
        /*g[i][j] 表示子串是否为回文串，初始时假设所有子串都是回文串*/
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                /*如果s[i] == s[j]并且s是回文，则s从i到j也是回文*/
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        /*返回将整个字符串s[0，n-1]分割成回文子串的最少切割次数*/
        return f[n - 1];
    }

}
