package org.lmt.剑指offer.动态规划;

/**
 * <p>Title: LCR089打家劫舍 </p >
 * <p>Description: LCR089打家劫舍 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 14:23
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR089打家劫舍 {
    public static void main(String[] args) {
        LCR089打家劫舍 a = new LCR089打家劫舍();
        System.out.println(a.rob(new int[]{2, 7, 9, 3, 1}));
    }

    /*动态规划*/
    /*dp[i]代表偷到第i个房子所能偷到的最大金额*/
    /*dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])*/
    public int rob(int[] nums) {
        /*数组只有1个元素，那么一定偷钱最大值只可能是它本身*/
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            /*由于不能偷相邻的房子，因此偷到第i个房子所能偷到的最大金额为前一个偷盗的最大金额或者前两个偷盗的最大金额加上第i个房子能偷盗的金额*/
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        /*偷盗金额最大值要么包括偷最后一个，要么不偷最后一个，取二者的最大值*/
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
