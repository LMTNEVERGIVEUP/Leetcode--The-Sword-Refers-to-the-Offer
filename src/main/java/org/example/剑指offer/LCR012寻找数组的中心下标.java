package org.example.剑指offer;

/**
 * <p>Title: LCR012寻找数组的中心下标 </p >
 * <p>Description: LCR012寻找数组的中心下标 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/9 13:28
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR012寻找数组的中心下标 {
    public static void main(String[] args) {
        LCR012寻找数组的中心下标 a = new LCR012寻找数组的中心下标();
        System.out.println(a.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        /*求数组总和*/
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            /*如果数组总和减去当前元素除以2正好为之前元素的和，就找到了中心元素*/
            if ((sum - nums[i]) / 2 == pre && (sum - nums[i]) % 2 == 0)
                return i;
            pre += nums[i];
        }
        return -1;
    }
}
