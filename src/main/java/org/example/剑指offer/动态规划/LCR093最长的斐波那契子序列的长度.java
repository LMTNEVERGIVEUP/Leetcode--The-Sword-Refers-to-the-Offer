package org.example.剑指offer.动态规划;

import java.util.HashMap;

/**
 * <p>Title: LCR093最长的斐波那契子序列的长度 </p >
 * <p>Description: LCR093最长的斐波那契子序列的长度 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/17 08:53
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR093最长的斐波那契子序列的长度 {
    public static void main(String[] args) {
        LCR093最长的斐波那契子序列的长度 a = new LCR093最长的斐波那契子序列的长度();
        System.out.println(a.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    /*dp[j][i]代表最后两个元素以arr[i]和arr[j]结尾的最长斐波那契子数列*/
    public int lenLongestFibSubseq(int[] arr) {
        /*hashmap存放从元素到下标的映射*/
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int[][] dp = new int[arr.length][arr.length];
        int max_length = 0;
        for (int i = 2; i < arr.length; i++) {
            /*选中i，倒过来找j*/
            for (int j = i - 1; j >= 0; j--) {
                /*判断map中是否存在一个元素，使得该元素和arr[i] ， arr[j]共同构成斐波那契序列*/
                if (map.containsKey(arr[i] - arr[j])) {
                    /*将它取出来*/
                    int index = map.get(arr[i] - arr[j]);
                    /*判断下标是否小于j*/
                    if (index < j) {
                        /*以j，i为最后两位的斐波那契数列的最长子序列长度是以index，j为最后两位的斐波那契子序列的长度+1*/
                        /*如果j,i是第二个和第三个（总共序列长度为3），那么以j，i为最后两位的斐波那契数列的最长子序列长度就是3*/
                        dp[j][i] = Math.max(dp[index][j] + 1, 3);
                        /*更新最大长度*/
                        max_length = Math.max(max_length, dp[j][i]);
                    }
                }
            }
        }
        return max_length;
    }
    /*时间复杂度o(n^2),空间复杂度o(n)*/

}
