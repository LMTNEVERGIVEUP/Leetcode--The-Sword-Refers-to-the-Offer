package org.example.剑指offer.图;

/**
 * <p>Title: LCR112矩阵中的最长递增路径 </p >
 * <p>Description: LCR112矩阵中的最长递增路径 </p >
 * Package: org.example.剑指offer.图
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/20 19:52
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR112矩阵中的最长递增路径 {
    public static void main(String[] args) {
        LCR112矩阵中的最长递增路径 a = new LCR112矩阵中的最长递增路径();
        System.out.println(a.longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}}));
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] length = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(dfs(matrix, length, i, j), max);
            }
        }
        return max;
    }

    /*[
    [9,9,4],
    [6,6,8],
    [2,1,1]
    ]*/
    public int dfs(int[][] matrix, int[][] lengths, int i, int j) {
        /*如果不为零，更新最大长度*/
        if (lengths[i][j] != 0)
            return lengths[i][j];
        int rows = matrix.length;
        int cols = matrix[0].length;
        /*边界数组*/
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int length = 1;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < rows && c >= 0 && c < cols && matrix[r][c] > matrix[i][j]) {
                /*返回长度*/
                int path = dfs(matrix, lengths, r, c);
                length = Math.max(path + 1, length);
            }
        }
        /*更新最大长度*/
        lengths[i][j] = length;
        return length;
    }

}
