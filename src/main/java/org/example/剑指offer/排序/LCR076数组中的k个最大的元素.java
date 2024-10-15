package org.example.剑指offer.排序;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Title: LCR076数组中的k个最大的元素 </p >
 * <p>Description: LCR076数组中的k个最大的元素 </p >
 * Package: org.example.剑指offer.排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 16:43
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR076数组中的k个最大的元素 {
    public static void main(String[] args) {
        LCR076数组中的k个最大的元素 A = new LCR076数组中的k个最大的元素();
        System.out.println(A.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    /*大根堆*/
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int result = 0;
        /*出堆k次就是第k大的元素*/
        for (int i = 0; i < k; i++) {
            result = queue.poll();
        }
        return result;
    }
}
