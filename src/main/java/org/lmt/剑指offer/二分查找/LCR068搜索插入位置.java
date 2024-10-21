package org.lmt.剑指offer.二分查找;

/**
 * <p>Title: LCR068搜索插入位置 </p >
 * <p>Description: LCR068搜索插入位置 </p >
 * Package: org.example.剑指offer.二分查找
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/14 14:44
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR068搜索插入位置 {
    public static void main(String[] args) {
        LCR068搜索插入位置 a = new LCR068搜索插入位置();
        System.out.println(a.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    /*二分查找*/
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else
                return mid;
        }
        return low;
    }
}
