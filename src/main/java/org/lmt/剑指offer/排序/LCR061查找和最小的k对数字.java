package org.lmt.剑指offer.排序;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>Title: LCR061查找和最小的k对数字 </p >
 * <p>Description: LCR061查找和最小的k对数字 </p >
 * Package: org.example.剑指offer.排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/14 09:51
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR061查找和最小的k对数字 {
    public static void main(String[] args) {
        LCR061查找和最小的k对数字 a = new LCR061查找和最小的k对数字();
        System.out.println(a.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        /*使用优先队列（最小堆），根据数对的和从小到大排序*/
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        /*初始化队列，将nums1中前k或m个元素和nums2第一个元素的组合放入队列*/
        /*这里最多只考虑nums1的前k个元素，因为最多只需要k个数对*/
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            /*如果nums2中还有下一个元素，可以与nums1[idxPair[0]] 组成新的数对*/
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }
        return ans;
    }

}
