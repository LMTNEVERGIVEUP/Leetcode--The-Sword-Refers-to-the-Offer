package org.example.剑指offer.拓扑排序;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Title: LCR113课程表 </p >
 * <p>Description: LCR113课程表 </p >
 * Package: org.example.剑指offer.拓扑排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/20 21:44
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR113课程表 {
    public static void main(String[] args) {
        LCR113课程表 a = new LCR113课程表();
        int[] order = a.findOrder(2, new int[][]{{1, 0}});
        for (int i : order) {
            System.out.print(i + " ");
        }
    }

    /*输出拓扑路径*/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*hashmap<该课程，学习顺序必须在该课程后的课程列表>*/
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<Integer>());
        }
        /*计算入度的数组*/
        int[] inDegrees = new int[numCourses];
        /*建立每个课程的先后顺序*/
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }
        /*基于bfs遍历*/
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            /*将入度为0的节点作为首节点，放入队列中*/
            if (inDegrees[i] == 0)
                queue.add(i);
        }
        /*建立结果集*/
        List<Integer> order = new LinkedList<>();
        /*开始遍历*/
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            order.add(course);
            for (Integer i : graph.get(course)) {
                /*入度减1*/
                inDegrees[i]--;
                /*将新的入度为0的节点加入队列*/
                if (inDegrees[i] == 0) {
                    queue.add(i);
                }
            }
        }
        /*遍历结束判断课程数量是否等于结果集中课程数量，如果不等代表不存在拓扑路径，否则转为静态数组返回结果*/
        return order.size() == numCourses ? order.stream().mapToInt(i -> i).toArray() : new int[0];
    }

}
