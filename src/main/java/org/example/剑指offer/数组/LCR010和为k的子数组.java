package org.example.剑指offer.数组;

import java.util.HashMap;

/**
 * <p>Title: LCR010和为k的子数组 </p >
 * <p>Description: LCR010和为k的子数组 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/9 10:27
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR010和为k的子数组 {
    public static void main(String[] args) {
        int[] nums = {1};
        LCR010和为k的子数组 a = new LCR010和为k的子数组();
        System.out.println(a.subarraySum(nums, 0));
    }

    /*整数数组可能是负数,考虑前缀和*/
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化前缀和为0的计数为1，这是因为如果sum-k为0，则说明从头到当前位置的和就是k
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            // 如果存在某个之前的位置的前缀和使得当前的前缀和减去这个值等于k，则说明找到了符合条件的子数组
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // 更新当前前缀和的计数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
