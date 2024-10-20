package org.example.剑指offer.图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Title: LCR10701矩阵 </p >
 * <p>Description: LCR10701矩阵 </p >
 * Package: org.example.剑指offer.图
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/20 10:57
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR107零一矩阵 {
    int count = 0;

    public static void main(String[] args) {
        LCR107零一矩阵 a = new LCR107零一矩阵();
        int[][] result = a.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        /*保存每个元素最短距离结果*/
        int[][] dists = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /*如果该元素为0，将该元素的位置加入队列，并且该元素距离0的最短路径长度就是0*/
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    dists[i][j] = 0;
                }
                /*否则设置为无穷大*/
                else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        /*0 0 0
          0 1 0
          1 0 0*/
        /*定义边界数组（上，下，左，右）*/
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        /*BFS遍历*/
        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            int dist = dists[pos[0]][pos[1]];
            /*计算上下左右四个元素*/
            for (int[] dir : dirs) {
                int r = dir[0] + pos[0];
                int c = dir[1] + pos[1];
                /*如果没有超出边界*/
                if (r >= 0 && c >= 0 && r < rows && c < cols) {
                    /*更新距离最小值，并将该元素的位置加入队列*/
                    if (dists[r][c] > dist + 1) {
                        dists[r][c] = dist + 1;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return dists;

    }
}
