package org.lmt.剑指offer.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Title: LCR074 </p >
 * <p>Description: LCR074 </p >
 * Package: org.example.剑指offer.二分查找
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 11:33
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR074合并区间 {
    public static void main(String[] args) {
        LCR074合并区间 A = new LCR074合并区间();
        int[][] merge = A.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> List = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < intervals.length; ) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            int[] temp = new int[2];
            temp[0] = left;
            temp[1] = right;
            for (j = i + 1; j < intervals.length; j++) {
                /*当且仅当如果区间左边的值小于下一个区间左边的值并且区间右边的值大于下一个区间左边的值时需要合并*/
                if (left <= intervals[j][0]
                        && right >= intervals[j][0]) {
                    /*如果下一个区间的右边的值大于这个区间右边的值，那么就将这个区间右边的值改成下一个区间右边的值*/
                    right = Math.max(right, intervals[j][1]);
                    /*更新右端点值*/
                    temp[1] = right;
                } else
                    break;
            }
            List.add(temp);
            i = j;
        }
        int[][] result = new int[List.size()][];
        return List.toArray(result);
    }
    /*时间复杂度o(nlogn) 空间复杂度o(n)*/
}

