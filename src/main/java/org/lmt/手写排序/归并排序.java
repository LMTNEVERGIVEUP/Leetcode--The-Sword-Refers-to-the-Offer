package org.lmt.手写排序;



/**
 * <p>Title: 归并排序 </p >
 * <p>Description: 归并排序 </p >
 * Package: org.example.手写排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 14:21
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class 归并排序 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 2, 5, 14, 8, 3};
        归并排序 a = new 归并排序();
        a.sort(nums, 0, nums.length);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /*数组范围[start,end)*/
    public void sort(int[] nums, int start, int end) {
        /*有一个元素就返回*/
        if (start >= end - 1)
            return;
        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid, end);
        merge(nums, start, mid, end);

    }

    /*第一个数组[start,mid),第二个数组[mid,end)*/
    public void merge(int[] nums, int start, int mid, int end) {
        int length = end - start;
        int[] temp = new int[length];
        int p1 = start, p2 = mid, p3 = 0;
        /*双指针合并*/
        while (p1 < mid && p2 < end) {
            if (nums[p1] <= nums[p2]) {
                temp[p3] = nums[p1];
                p1++;
            } else {
                temp[p3] = nums[p2];
                p2++;
            }
            p3++;
        }
        while (p1 < mid) {
            temp[p3++] = nums[p1];
            p1++;
        }
        while (p2 < end) {
            temp[p3++] = nums[p2];
            p2++;
        }
        /*深拷贝copy回数组*/
        System.arraycopy(temp, 0, nums, start, temp.length);
    }
}
