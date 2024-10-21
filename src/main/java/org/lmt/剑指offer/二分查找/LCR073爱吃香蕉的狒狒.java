package org.lmt.剑指offer.二分查找;

import java.util.Arrays;

/**
 * <p>Title: LCR073爱吃香蕉的狒狒 </p >
 * <p>Description: LCR073爱吃香蕉的狒狒 </p >
 * Package: org.example.剑指offer.二分查找
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 10:51
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR073爱吃香蕉的狒狒 {
    public static void main(String[] args) {
        LCR073爱吃香蕉的狒狒 z = new LCR073爱吃香蕉的狒狒();
        System.out.println(z.minEatingSpeed(new int[]{312884470}, 968709470));
    }

    /*二分查找*/
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        /*最少1小时吃1根香蕉*/
        int low = 1;
        /*最多1小时吃（数组中最大值）根香蕉，因为吃了更多时间还是一样*/
        int high = piles[piles.length - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            /*如果需要时间小于等于警卫离开的时间*/
            if (getTime(piles, mid) <= h) {
                /*如果速度已经降到1，代表找不到更小的速度使得需要时间小于等于警卫离开的时间，直接返回1*/
                if (mid - 1 == 0)
                    return 1;
                /*如果以比mid-1的速度吃完香蕉所需要的时间大于警卫离开的时间，代表mid就是在警卫回来之前吃完香蕉的最小速度*/
                if (getTime(piles, mid - 1) > h)
                    return mid;
                    /*否则还可以继续压缩吃香蕉速度*/
                else
                    high = mid - 1;
            }
            /*如果需要时间大于警卫离开的时间，代表吃香蕉的速度不够快，因此加快速度*/
            if (getTime(piles, mid) > h) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /*计算以速度k吃完香蕉所需要的时间*/
    public int getTime(int[] piles, int k) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] % k != 0)
                count += piles[i] / k + 1;
            else
                count += piles[i] / k;
        }
        return count;
    }

    /*时间复杂度o(nlogn)，空间复杂度o(1)*/
}
