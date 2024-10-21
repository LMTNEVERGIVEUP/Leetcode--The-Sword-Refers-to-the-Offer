package org.lmt.剑指offer.图;

/**
 * <p>Title: LCR105岛屿的最大面积 </p >
 * <p>Description: LCR105岛屿的最大面积 </p >
 * Package: org.example.剑指offer.图
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/18 16:52
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR105岛屿的最大面积 {
    int max_area = 0;
    int max = 0;

    public static void main(String[] args) {
        int[][] p = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        LCR105岛屿的最大面积 a = new LCR105岛屿的最大面积();
        System.out.println(a.maxAreaOfIsland(p));
    }

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = 1;
                dfs(grid, i, j);
            }
        }
        return max_area;
    }

    public void dfs(int[][] grid, int i, int j) {
        /*如果为0直接返回*/
        if (grid[i][j] == 0)
            return;
        /*如果为1，需要改成0，防止递归的时候反复遍历*/
        if (grid[i][j] == 1)
            grid[i][j] = 0;
        /*不能超过边界，往四个方向遇到为1就进入dfs*/
        if (i != 0 && grid[i - 1][j] == 1) {
            max += 1;
            dfs(grid, i - 1, j);
        }
        if (i != grid.length - 1 && grid[i + 1][j] == 1) {
            max += 1;
            dfs(grid, i + 1, j);
        }
        if (j != 0 && grid[i][j - 1] == 1) {
            max += 1;
            dfs(grid, i, j - 1);
        }
        if (j != grid[i].length - 1 && grid[i][j + 1] == 1) {
            max += 1;
            dfs(grid, i, j + 1);
        }
        /*四个方向延展完之后算出以i,j为中心的最大岛屿面积，并与全局最大值max_area比较，取较大者*/
        max_area = Math.max(max_area, max);
    }
}
