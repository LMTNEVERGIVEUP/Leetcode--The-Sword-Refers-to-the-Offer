package org.lmt.剑指offer.二分查找;

import java.util.Random;

/**
 * <p>Title: LCR071按权重随机选择 </p >
 * <p>Description: LCR071按权重随机选择 </p >
 * Package: org.example.剑指offer.二分查找
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 08:56
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR071按权重随机选择 {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 3});
        System.out.println(solution.pickIndex());
    }

}

class Solution {
    int[] weight;

    /*前缀和*/
    public Solution(int[] w) {
        int sum = 0;
        weight = new int[w.length];
        /*计算前缀和*/
        for (int i = 0; i < w.length; i++) {
            if (i == 0)
                weight[i] = w[i];
            else
                weight[i] = weight[i - 1] + w[i];
        }

    }

    /*假设数组为{1,3},前缀和数组为{1,4}，即随机生成[0,4)之间的整数，如果落在[0,1)就代表抽中了第0号元素，落在了[1,4)就代表抽中了第1号元素*/
    public int pickIndex() {
        Random random = new Random();
        int rand = random.nextInt(weight[weight.length - 1]);
        int low = 0;
        int high = weight.length - 1;
        /*二分查找*/
        while (low <= high) {
            int mid = (low + high) / 2;
            /*中间元素的值小于等于随机数，代表抽中的数还在后面*/
            if (weight[mid] <= rand)
                low = mid + 1;
            /*中间元素的值大于随机数，代表抽中的数就在前面或者是自身*/
            if (weight[mid] > rand)
                /*如果同时前面的元素小于等于随机数或者前面没有元素了就代表抽中的数是自身*/
                if (mid == 0 || weight[mid - 1] <= rand)
                    return mid - 1;
                    /*否则代表抽中的数还在前面*/
                else
                    high = mid - 1;
        }
        return -1;
    }
    /*时间复杂度o(logn)，空间复杂度o(1)*/
}