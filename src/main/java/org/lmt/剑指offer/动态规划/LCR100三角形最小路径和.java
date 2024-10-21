package org.lmt.剑指offer.动态规划;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR100三角形最小路径和 </p >
 * <p>Description: LCR100三角形最小路径和 </p >
 * Package: org.example.剑指offer.动态规划
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/17 16:04
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR100三角形最小路径和 {
    public static void main(String[] args) {
        LCR100三角形最小路径和 a = new LCR100三角形最小路径和();
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> list3 = new LinkedList<>();
        List<Integer> list4 = new LinkedList<>();
        list1.add(2);               /*          2
                                               3 4
                                              6 5 7
                                             4 1 8 3*/
        list2.add(3);
        list2.add(4);
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        System.out.println(a.minimumTotal(lists));
    }

    /*                 2 0 0 0
     *                 3 4 0 0
     *                 6 5 7 0
     *                 4 1 8 3
     * */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.get(triangle.size() - 1).size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        /*考虑边界，边界有两条，一条是第一列，还有一条是对角线*/
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
        }
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        /*开始动态规划*/
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j < triangle.get(i).size(); j++) {
                /*边界已经考虑过了，所以跳过*/
                if (i != j)
                    /*走到坐标i,j位置的最小和等于 走到正上一个元素的最小和 和 走到左上个元素的最小和 的最小值加上本身元素的值*/
                    dp[i][j] = Math.min(dp[i - 1][j] + triangle.get(i).get(j), dp[i - 1][j - 1] + triangle.get(i).get(j));
            }
        }
        int min = dp[dp.length - 1][0];
        /*遍历 走到最后一行每一个元素的最小值，找其中的最小值*/
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        return min;
    }
    /*时间复杂度o(n^2)，空间复杂度O(n)*/
}
