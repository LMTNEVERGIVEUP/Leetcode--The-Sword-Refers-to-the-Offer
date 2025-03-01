package org.lmt.手写排序;

/**
 * <p>Title: 快排</p>
 * <p>Description: 快排</p>
 * Package: org.lmt.手写排序
 * Copyright: Copyright(c) LMT
 * Date: 2025/3/1 18:09
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class 快排 {
    public static void main(String[] args) {
        int[] p = {7, 2, 9, 1, 5, 8, 3, 6, 4, 0};
        new 快排().quickSort(p, 0, p.length - 1);
        for (int i : p) {
            System.out.print(i + " ");
        }
    }

    public void quickSort(int[] p, int start, int end) {
        if (start >= end)
            return;
        int index = sort(p, start, end);
        quickSort(p, start, index - 1);
        quickSort(p, index + 1, end);
    }

    public int sort(int[] p, int start, int end) {
        int p1 = start + 1;
        int p2 = end;
        while (p1 <= p2) {
            /*从左往右找到第一个大于等于基准元素的元素*/
            while (p1 <= p2 && p[p1] < p[start])
                p1++;
            /*从右往左找到第一个小于等于基准元素的元素*/
            while (p1 <= p2 && p[p2] > p[start])
                p2--;
            /*交换二者*/
            if (p1 < p2)
                swap(p, p1, p2);
        }
        /*p2就是基准元素的位置*/
        swap(p, start, p2);
        return p2;
    }

    /*交换数组的两个位置上的数字*/
    public void swap(int[] p, int a, int b) {
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }

}