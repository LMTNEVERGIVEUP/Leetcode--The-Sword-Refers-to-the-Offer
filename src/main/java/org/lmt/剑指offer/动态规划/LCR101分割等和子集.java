package org.lmt.剑指offer.动态规划;

/**
 * <p>Title: LCR101分割等和子集 </p >
 * <p>Description: LCR101分割等和子集 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/18 08:58
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR101分割等和子集 {
    public static void main(String[] args) {
        LCR101分割等和子集 a = new LCR101分割等和子集();
        System.out.println(a.canPartition(new int[]{9, 5}));
    }

    public boolean canPartition(int[] nums) {
        /*数组长度小于2不可分割*/
        if (nums.length < 2)
            return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        /*数组和为奇数不可分割*/
        if (sum % 2 != 0)
            return false;
        /*dp[i][j]代表nums下标[0,i]之内是否存在和等于j的数字组合*/
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < sum / 2 + 1; j++) {
                /*处理边界*/
                if (i == 0) {
                    if (sum / 2 + 1 >= nums[i])
                        dp[i][nums[0]] = true;
                    /*如果当前元素小于等于j，那么只要nums下标[0,i-1]之内存在和等于j的数字组合或者下标[0,i-1]之内存在和等于j-nums[i]的数字组合两个条件成立一个就证明nums下标[0,i]之内存在数字组合等于j*/
                } else if (j >= nums[i])
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                    /*如果当前元素小于等于j，那么必须要nums下标[0,i-1]之内存在和等于j的数字组合才证明nums下标[0,i]之内存在数字组合等于j，因为往前无法找不到j - nums[i]的数组组合(j - nums[i]<0)*/
                else if (j < nums[i])
                    dp[i][j] = dp[i - 1][j];
            }
        }
        /*返回nums下标[0,i]之内是否存在和等于sum / 2的数字组合*/
        return dp[dp.length - 1][sum / 2];
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
