package org.example.剑指offer.数组;

/**
 * <p>Title: LCR013二维区域和检索矩阵不可变 </p >
 * <p>Description: LCR013二维区域和检索矩阵不可变 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/9 13:49
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR013二维区域和检索矩阵不可变 {


    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2}
                , {5, 6, 3, 2, 1}
                , {1, 2, 0, 1, 5}
                , {4, 1, 0, 1, 7}
                , {1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (红色矩形框的元素总和)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (绿色矩形框的元素总和)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (蓝色矩形框的元素总和)
    }


}

class NumMatrix {
    public int[][] pre_matrix;
    public int[][] matrix;
    /*建立前缀矩阵*/
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        pre_matrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int row = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                row += matrix[i][j];
                if (i == 0)
                    pre_matrix[i][j] = row;
                else
                    pre_matrix[i][j] = pre_matrix[i - 1][j] + row;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == row2 && col1 == col2)
            return matrix[row1][col1];
        if (row1 == 0 && col1 == 0)
            return pre_matrix[row2][col2];
        if (row1 == 0)
            return pre_matrix[row2][col2] - pre_matrix[row2][col1 - 1];
        if (col1 == 0)
            return pre_matrix[row2][col2] - pre_matrix[row1 - 1][col2];
        return pre_matrix[row2][col2] - pre_matrix[row2][col1 - 1] - pre_matrix[row1 - 1][col2] + pre_matrix[row1 - 1][col1 - 1];
    }

}
