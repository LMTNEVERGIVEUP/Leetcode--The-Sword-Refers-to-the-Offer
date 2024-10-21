package org.lmt.剑指offer.图;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR110所有可能的路径 </p >
 * <p>Description: LCR110所有可能的路径 </p >
 * Package: org.example.剑指offer.图
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/20 16:31
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR110所有可能的路径 {
    public static void main(String[] args) {
        LCR110所有可能的路径 a = new LCR110所有可能的路径();
        int[][] ints = a.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /*dfs*/
    public int[][] allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        dfs(graph, 0, list, result);
        /*二维动态数组转静态数组*/
        int[][] p = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            p[i] = new int[result.get(i).size()];
            for (int j = 0; j < result.get(i).size(); j++) {
                p[i][j] = result.get(i).get(j);
            }
        }
        return p;
    }

    /*dfs*/
    public void dfs(int[][] graph, int i, LinkedList<Integer> list, List<List<Integer>> result) {
        /*如果数组为空，加上元素本身*/
        if (list.isEmpty())
            list.add(i);
        /*如果已经到达了n-1号节点，则已经找到了一条路径，直接加入到结果集中并返回*/
        if (i == graph.length - 1) {
            result.add(new LinkedList<>(list));
            return;
        }
        /*遍历该节点的所有邻接节点*/
        for (int k = 0; k < graph[i].length; k++) {
            list.add(graph[i][k]);
            dfs(graph, graph[i][k], list, result);
            /*list为引用类型，回溯到上一层需要移出刚刚下一层加进来的节点*/
            list.removeLast();
        }
    }
    /*时间复杂度o(n^2)，空间复杂度o(n)*/
}
