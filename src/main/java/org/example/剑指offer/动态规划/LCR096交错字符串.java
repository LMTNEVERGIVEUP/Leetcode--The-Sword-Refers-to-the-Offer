package org.example.剑指offer.动态规划;

/**
 * <p>Title: LCR096交错字符串 </p >
 * <p>Description: LCR096交错字符串 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/17 14:19
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR096交错字符串 {
    public static void main(String[] args) {
        LCR096交错字符串 a = new LCR096交错字符串();
        System.out.println(a.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        /*dp[i][j]代表s1的前i个元素和s2的前j个元素能否组成s3的前i+j个元素*/
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                /*处理边界，当i为0时，代表只是s2和s3做比较*/
                if (i == 0)
                    dp[i][j] = s2.substring(0, j).equals(s3.substring(0, j));
                    /*处理边界，当j为0时，代表只是s1和s3做比较*/
                else if (j == 0)
                    dp[i][j] = s1.substring(0, i).equals(s3.substring(0, i));
                    /*如果s1的第i个字符和s3的第i + j个字符相等而且s1的前i - 1个字符和s2的前j个字符可以组成s3的前i+j-1个字符*/
                    /*代表s3的前i+j个字符也可以被组成*/
                else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
                    dp[i][j] = true;
                    /*如果s2的第j个字符和s3的第i + j个字符相等而且s1的前i个字符和s2的前j-1个字符可以组成s3的前i+j-1个字符*/
                    /*代表s3的前i+j个字符也可以被组成*/
                else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])
                    dp[i][j] = true;
            }
        }
        /*返回s1的前s1.length()个元素和s2的前s1.length()个元素能否组成s3的所有元素*/
        return dp[s1.length()][s2.length()];
    }
}
