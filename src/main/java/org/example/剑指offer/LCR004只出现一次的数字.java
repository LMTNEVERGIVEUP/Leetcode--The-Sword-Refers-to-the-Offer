package org.example.剑指offer;

/**
 * <p>Title: _004只出现一次的数字 </p >
 * <p>Description: _004只出现一次的数字 </p >
 * Package: org.example.offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/8 13:46
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR004只出现一次的数字 {

    /*位运算，每个数的每一位的和余3就是多出来那个数的对应位的值*/
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                /*取出第i位：右移i位再和1做与运算*/
                sum = (nums[j] >> i & 1) + sum;
            }
            /*获取这个数第i位的值：左移i位*/
            result = result | sum % 3 << i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 100};
        LCR004只出现一次的数字 a = new LCR004只出现一次的数字();
        System.out.println(a.singleNumber(nums));

    }


}
