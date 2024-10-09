package org.example.剑指offer;

/**
 * <p>Title: LCR008长度最小的子数组 </p >
 * <p>Description: LCR008长度最小的子数组 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) AI+X
 * Date: 2024/10/9 08:54
 *
 * @author LiMengTing
 * @version 1.0.0
 */

public class LCR008长度最小的子数组 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        LCR008长度最小的子数组 a = new LCR008长度最小的子数组();
        System.out.println(a.minSubArrayLen(11, nums));
    }

    /*双指针模拟窗口，由于都是正数，所以窗口内的和大了左指针右移，小了右指针左移*/
    public int minSubArrayLen(int target, int[] nums) {
        int min_length = nums.length + 1;
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        while (p1 < nums.length && p2 < nums.length) {
            sum = sum + nums[p2];
            /*和大了，左指针右移*/
            while (sum > target && p1 < nums.length) {
                min_length = Math.min(min_length, p2 - p1 + 1);
                sum = sum - nums[p1];
                p1++;
            }
            if (sum == target) {
                min_length = Math.min(min_length, p2 - p1 + 1);
                p2++;
            }
            /*和小了，右指针右移*/
            if (sum < target)
                p2++;
        }
        return min_length == nums.length + 1 ? 0 : min_length;
    }


}