package org.example.剑指offer.动态规划;

/**
 * <p>Title: LCR104组合总和2 </p >
 * <p>Description: LCR104组合总和2 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/18 15:23
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR104组合总和2 {
    public static void main(String[] args) {
        LCR104组合总和2 a = new LCR104组合总和2();
        System.out.println(a.combinationSum4(new int[]{1, 2, 3}, 33));
    }

    public int combinationSum4(int[] nums, int target) {
        /*dp[i]代表总和为i的组合方案个数*/
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            /*总和为i的组合方案个数*/
            for (int num : nums) {
                /*遍历每一个元素，总和为i的组合方案个数为 总和为i-num的组合方案个数加上已有的总和为i的组合方案个数*/
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    /*时间复杂度o(n^2),空间复杂度o(n)*/
}
