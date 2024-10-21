package org.lmt.剑指offer.拓扑排序;

import java.util.*;

/**
 * <p>Title: LCR115序列重建 </p >
 * <p>Description: LCR115序列重建 </p >
 * Package: org.example.剑指offer.拓扑排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/20 22:49
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR115序列重建 {
    public static void main(String[] args) {
        LCR115序列重建 a = new LCR115序列重建();
        System.out.println(a.sequenceReconstruction(new int[]{1, 2, 3}, new int[][]{{1, 2}, {1, 3}}));
    }

    /*判断拓扑排序是否唯一*/
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        /*map<元素，必须出现在该元素后的元素>*/
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        /*map<元素，元素的入度>*/
        HashMap<Integer, Integer> inDegrees = new HashMap<>();
        for (int[] sequence : sequences) {
            for (int i : sequence) {
                if (i < 1 || i > nums.length) {
                    return false;
                }
                /*初始化*/
                graph.putIfAbsent(i, new HashSet<>());
                inDegrees.putIfAbsent(i, 0);
            }
            /*建立元素先后顺序关系*/
            for (int i = 0; i < sequence.length - 1; i++) {
                int left = sequence[i];
                int right = sequence[i + 1];
                if (!graph.get(left).contains(right)) {
                    graph.get(left).add(right);
                    inDegrees.put(right, inDegrees.get(right) + 1);
                }
            }
        }
        /*基于bfs遍历*/
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0)
                queue.offer(entry.getKey());
        }
        LinkedList<Integer> result = new LinkedList<>();
        /*如果队列有超过1个元素，代表队列中有入度大于0的元素不止一个，因此拓扑排列顺序一定有多种*/
        while (queue.size() == 1) {
            Integer temp = queue.poll();
            result.add(temp);
            for (Integer i : graph.get(temp)) {
                inDegrees.put(i, inDegrees.get(i) - 1);
                if (inDegrees.get(i) == 0)
                    queue.offer(i);
            }
        }
        int[] re = result.stream().mapToInt(i -> i).toArray();
        /*判断拓扑排序后的元素顺序和给出的超序列是否相等*/
        return Arrays.equals(re, nums);
    }
}
