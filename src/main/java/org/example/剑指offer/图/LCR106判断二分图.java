package org.example.剑指offer.图;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Title: LCR106判断二分图 </p >
 * <p>Description: LCR106判断二分图 </p >
 * Package: org.example.剑指offer.图
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/20 10:20
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR106判断二分图 {
    public static void main(String[] args) {
        int[][] p = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        LCR106判断二分图 a = new LCR106判断二分图();
        System.out.println(a.isBipartite(p));
    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        /*采用color数组标记每个元素属于二分图的哪个部分,0代表第一个部分，1代表第二个部分，-1代表还没有遍历到*/
        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, color, i, 0))
                    return false;
            }
        }
        return true;
    }

    /*修改bfs*/
    public boolean bfs(int[][] graph, int[] colors, int i, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        colors[i] = 0;
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            for (int neighbour : graph[temp]) {
                /*遍历相连的节点，如果相邻节点的color大于等于0，代表已经遍历过了*/
                if (colors[neighbour] >= 0) {
                    /*接着判断相邻节点和自身节点是否属于同一个部分，属于就代表不是2分图*/
                    if (colors[neighbour] == colors[temp])
                        return false;
                }
                /*否则代表还没有遍历到，将相邻节点划分到不是自己的阵营中并加入队列进行后续遍历（二分图需要一条边的两个端点从属不同阵营）*/
                else {
                    queue.offer(neighbour);
                    colors[neighbour] = 1 - colors[temp];
                }
            }
        }
        return true;
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
