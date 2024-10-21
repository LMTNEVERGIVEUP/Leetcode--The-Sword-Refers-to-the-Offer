package org.lmt.剑指offer.二分查找;

/**
 * <p>Title: LCR069山脉数组的峰顶索引 </p >
 * <p>Description: LCR069山脉数组的峰顶索引 </p >
 * Package: org.example.剑指offer.二分查找
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/14 14:53
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR069山脉数组的峰顶索引 {
    public static void main(String[] args) {
        LCR069山脉数组的峰顶索引 a = new LCR069山脉数组的峰顶索引();
        System.out.println(a.peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0}));
    }

    /*二分查找*/
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            /*找到中点*/
            int mid = (low + high) / 2;
            int midLeft = Math.max(mid - 1, 0);
            int midRight = Math.min(mid + 1, arr.length - 1);
            /*中点左边的如果比中点大，代表应该往左找*/
            if (arr[midLeft] > arr[mid])
                high = midLeft;
            /*中点右边的如果比中点大，代表应该往右找*/
            if (arr[midRight] > arr[mid])
                low = midRight;
            /*中点左边的如果比中点小，中点右边的如果比中点小则符合条件*/
            if (arr[midLeft] < arr[mid] && arr[midRight] < arr[mid]) {
                return mid;
            }
        }
        return -1;
    }
}
