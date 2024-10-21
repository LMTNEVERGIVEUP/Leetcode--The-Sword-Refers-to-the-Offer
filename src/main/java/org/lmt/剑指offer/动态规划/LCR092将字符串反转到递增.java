package org.lmt.剑指offer.动态规划;

/**
 * <p>Title: LCR092将字符串反转到递增 </p >
 * <p>Description: LCR092将字符串反转到递增 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 15:34
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR092将字符串反转到递增 {
    public static void main(String[] args) {
        LCR092将字符串反转到递增 a = new LCR092将字符串反转到递增();
        System.out.println(a.minFlipsMonoIncr("00011000"));
    }

    /*dp[i][0]代表字符串到达第i个位置时，以0为结尾的字符串需要翻转的最小次数*/
    /*dp[i][1]代表字符串到达第i个位置时，以1为结尾的字符串需要翻转的最小次数*/
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[s.length()][2];
        dp[0][0] = s.charAt(0) - '0';
        dp[0][1] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            int value = s.charAt(i);
            /*当前位置是否为0，为0则不需要翻转，不为0的话还得翻转一次*/
            dp[i][0] = dp[i - 1][0] + value - '0';
            /*当前位置是否为1，为1则不需要翻转，不为1的话还得翻转一次*/
            /*当前位置为1所需要的翻转最小次数是前一个位置为0和前一个位置为1的翻转次数最小值*/
            dp[i][1] = Math.min(dp[i - 1][1] + (value == '1' ? 0 : 1), dp[i - 1][0] + (value == '1' ? 0 : 1));
        }
        /*返回最后一个位置为0或者最后一个位置为1二者之间的最小值*/
        return Math.min(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
    /*时间复杂度o(n),空间复杂度o(n)*/
}
