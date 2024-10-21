package org.lmt.剑指offer.动态规划;

/**
 * <p>Title: LCR090打家劫舍2 </p >
 * <p>Description: LCR090打家劫舍2 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 14:41
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR090打家劫舍2 {
    public static void main(String[] args) {
        LCR090打家劫舍2 a = new LCR090打家劫舍2();
        System.out.println(a.rob(new int[]{1, 2, 1, 1}));
    }

    /*dp1[i]代表偷到第i个房子所能偷到的最大金额（偷第一个房子）*/
    /*dp2[i]代表偷到第i个房子所能偷到的最大金额（不偷第一个房子）*/
    /*环形房屋*/
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = dp1[0];
        for (int i = 2; i < dp1.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        /*得出偷第一个房子方案下最大盗取金额*/
        int dp1_max = Math.max(dp1[dp1.length - 2], dp1[dp1.length - 3]);
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < dp2.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        /*得出不偷第一个房子方案下最大盗取金额*/
        int dp2_max = Math.max(dp2[dp2.length - 1], dp2[dp2.length - 2]);
        /*取二者最大值*/
        return Math.max(dp1_max, dp2_max);
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
