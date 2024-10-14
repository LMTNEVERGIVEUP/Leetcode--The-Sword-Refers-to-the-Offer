package org.example.剑指offer.排序;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>Title: LCR060前k个高频元素 </p >
 * <p>Description: LCR060前k个高频元素 </p >
 * Package: org.example.剑指offer.排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 21:43
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR060前k个高频元素 {
    public static void main(String[] args) {
        LCR060前k个高频元素 a = new LCR060前k个高频元素();
        for (int i : a.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)) {
            System.out.println(i);
        }
    }

    /*堆元素排序*/
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /*构建小根堆*/
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int i = 0;
        /*遍历map 如果当前堆里元素个数小于k，就往里插入*/
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            }
            /*否则对比当前元素和堆顶元素的大小，如果堆顶元素大，那么代表堆里已经有k个元素比当前元素大，所以不可能是当前元素。如果当前元素大，代表堆顶元素不可能是前k个元素之内，就移除堆顶元素，然后插入当前元素*/
            else {
                if (entry.getValue() >= queue.peek()[1]) {
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
            i++;
        }
        int[] result = new int[k];
        i = 0;
        /*剩余堆里的元素都符合要求*/
        while (!queue.isEmpty()) {
            result[i] = queue.poll()[0];
            i++;
        }
        return result;
    }
}
