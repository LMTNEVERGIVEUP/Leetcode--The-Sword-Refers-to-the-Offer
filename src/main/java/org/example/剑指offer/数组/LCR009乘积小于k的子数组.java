package org.example.剑指offer.数组;

/**
 * <p>Title: LCR009 </p >
 * <p>Description: LCR009 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/9 09:33
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR009乘积小于k的子数组 {

    public static void main(String[] args) {
        int[] p = {10, 5, 2, 6};
        LCR009乘积小于k的子数组 a = new LCR009乘积小于k的子数组();
        System.out.println(a.numSubarrayProductLessThanK(p, 100));
    }

    /*双指针模拟窗口，窗口内乘积大了左指针右移，乘积小了右指针左移*/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int p1 = 0;
        int p2 = 0;
        int product = 1;
        while (p1 < nums.length && p2 < nums.length) {
            product = product * nums[p2];
            while (product >= k && p1 <= p2) {
                product = product / nums[p1];
                p1++;
            }
            /*count为以右指针为中心增加的符合标准的子数组*/
            count = count + p2 - p1 + 1;
            p2++;
        }
        return count;
    }
    /*时间复杂度o(n)，空间复杂度o(1)*/
}
