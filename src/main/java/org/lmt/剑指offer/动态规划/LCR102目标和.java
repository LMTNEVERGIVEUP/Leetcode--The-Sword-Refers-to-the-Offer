package org.lmt.剑指offer.动态规划;

/**
 * <p>Title: LCR102目标和 </p >
 * <p>Description: LCR102目标和 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/18 11:40
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR102目标和 {
    public static void main(String[] args) {
        LCR102目标和 a = new LCR102目标和();
        System.out.println(a.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    /*令负数部分的绝对值为k，将负数替换为绝对值计算出的总元素和为sum,那么sum-2k=target,由此可得(sum-target)/2 = k*/
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        /*计算数组总和*/
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) % 2 != 0 || (sum - target) < 0)
            return 0;
        int k = (sum - target) / 2;
        /*转化为寻找数组中元素和为k的方案数问题，dp[i][j]代表在下标[0,i)中和为j的元素有几种*/
        int[][] dp = new int[nums.length + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                /*如果j>= nums[i - 1]，代表在下标[0,i)中和为j的元素的方案数有两种可能，第一种可能是在下标[0,i-1)中和为j的元素的方案数（不选当前元素作为和的一部分），第二种可能是在下标[0,i-1)中和为j - nums[i - 1]的元素的方案数（选择当前元素作为和的一部分加起来为j）*/
                if (j >= nums[i - 1])
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    /*如果j< nums[i - 1]，代表只有可能是下标[0,i-1)中和为j的元素的方案数（不选当前元素作为和的一部分）*/
                else if (j < nums[i - 1])
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length][k];
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
