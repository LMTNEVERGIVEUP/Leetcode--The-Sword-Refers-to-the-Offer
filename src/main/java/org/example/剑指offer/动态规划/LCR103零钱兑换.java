package org.example.剑指offer.动态规划;

/**
 * <p>Title: LCR103零钱兑换 </p >
 * <p>Description: LCR103零钱兑换 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/18 14:08
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR103零钱兑换 {
    public static void main(String[] args) {
        LCR103零钱兑换 a = new LCR103零钱兑换();
        System.out.println(a.coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        /*dp[i]代表兑换成i值需要的最小硬币数量*/
        /*兑换金额为amount，最小硬币面额一定大于1，代表兑换的硬币数一定不可能大于amount个(假设全部用1元兑换也最多需要amount个硬币)*/
        int[] dp = new int[amount + 1];
        /*相当于给每个元素量化了一个不可能的数，即如果最终dp[i]的值为amount + 1，那么代表不存在兑换面额为i值的硬币组合*/
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                /*如果当前硬币面额小于所需兑换钱的金额*/
                if (coin <= i) {
                    /*选择兑换金额为dp[i - coin]的硬币数量加上自己本身和dp[i]之间的最小值，因为dp[i]可能已经有很多方式。*/
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        /*如果dp[amount] == amount + 1，代表找不到方案*/
        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }
}
