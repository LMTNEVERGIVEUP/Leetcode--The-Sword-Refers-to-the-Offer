package org.lmt.剑指offer.二分查找;

/**
 * <p>Title: LCR070有序数组中的单一元素 </p >
 * <p>Description: LCR070有序数组中的单一元素 </p >
 * Package: org.example.剑指offer.二分查找
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/14 15:34
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR070有序数组中的单一元素 {
    public static void main(String[] args) {
        int[] p = {1, 1, 2};
        LCR070有序数组中的单一元素 a = new LCR070有序数组中的单一元素();
        System.out.println(a.singleNonDuplicate(p));
    }

    /*二分*/
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 <= p2) {
            int mid = (p1 + p2) / 2;
            /*left为中点左边的一个*/
            int left = Math.max(mid - 1, 0);
            /*right为中点右边的一个*/
            int right = Math.min(mid + 1, nums.length - 1);
            /*如果mid和left相等或者mid和right相等，代表达到边界，代表除了边界的元素都符合，所以一定就是边界*/
            if (mid == left || mid == right) {
                return mid;
            }
            /*如果mid为奇数*/
            if (mid % 2 != 0) {
                /*如果前面的不等于自身，后面的等于自身代表要找的元素在前面*/
                if (nums[mid] != nums[left] && nums[mid] == nums[right])
                    p2 = mid - 1;
                    /*如果前面的元素等于自身，代表要找的元素在后面*/
                else if (nums[mid] == nums[left])
                    p1 = mid + 1;
                    /*如果前面的不等于自身，后面的也不等于自身，那么mid就是要找的元素*/
                else if (nums[mid] != nums[left] && nums[mid] != nums[right])
                    return mid;
            }
            /*如果mid为偶数同理*/
            else {
                if (nums[mid] != nums[right] && nums[mid] == nums[left])
                    p2 = mid - 1;
                else if (nums[mid] == nums[right])
                    p1 = mid + 1;
                else if (nums[mid] != nums[right] && nums[mid] != nums[left])
                    return nums[mid];
            }
        }
        return -1;
    }
}
