package org.example.剑指offer.红黑树;

import java.util.TreeSet;

/**
 * <p>Title: LCR056 </p >
 * <p>Description: LCR056 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 17:10
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR057存在重复元素3 {
    public static void main(String[] args) {
        LCR057存在重复元素3 a = new LCR057存在重复元素3();
        System.out.println(a.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

    /*采用TreeSet 存放数组里的每一个值，控制set的长度为k*/
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            /*找到集合中大于等于该元素的最小数字*/
            Long high = set.ceiling((long) (nums[i]));
            /*找到集合中小于等于该元素的最大数字*/
            Long low = set.floor((long) nums[i]);
            if (high != null) {
                /*计算绝对值，如果小于t则符合条件*/
                if (Math.abs(high - nums[i]) <= t)
                    return true;
            }
            if (low != null) {
                if (Math.abs(low - nums[i]) <= t)
                    return true;
            }
            set.add((long) nums[i]);
            /*始终控制set的长度为k，移出超出范围的元素*/
            if (i >= k)
                set.remove((long) nums[i - k]);
        }
        return false;
    }
}
