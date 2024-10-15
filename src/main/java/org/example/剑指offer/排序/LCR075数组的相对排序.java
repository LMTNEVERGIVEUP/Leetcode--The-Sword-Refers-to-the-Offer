package org.example.剑指offer.排序;

/**
 * <p>Title: LCR075数组的相对排序 </p >
 * <p>Description: LCR075数组的相对排序 </p >
 * Package: org.example.剑指offer.排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 13:33
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR075数组的相对排序 {
    public static void main(String[] args) {
        LCR075数组的相对排序 a = new LCR075数组的相对排序();
        int[] result = a.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /*计数排序*/
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] a = new int[1001];
        /*针对arr1的每一个元素，在a数组的对应位置+1计数*/
        for (int value : arr1) {
            a[value]++;
        }
        int[] result = new int[arr1.length];
        int i = 0, j = 0;
        /*遍历arr2*/
        while (j < arr2.length) {
            /*获得对应arr1该元素出现的次数，出现几次就往数组里增加几个*/
            while (a[arr2[j]] > 0) {
                result[i] = arr2[j];
                /*辅助数组对应计数-1，是为了方便下面步骤中得到arr2中未出现的元素*/
                a[arr2[j]]--;
                i++;
            }
            j++;
        }
        /*遍历辅助数组，不为0的元素就是arr2中未出现的元素将剩余的元素加入到数组中*/
        for (int k = 0; k < a.length; k++) {
            while (a[k] > 0) {
                result[i] = k;
                i++;
                a[k]--;
            }
        }
        return result;
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
