package org.lmt.剑指offer.数组;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR007三数之和 </p >
 * <p>Description: LCR007三数之和 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) AI+X
 * Date: 2024/10/8 15:45
 *
 * @author LiMengTing
 * @version 1.0.0
 */

public class LCR007三数之和 {
    public List<List<Integer>> list = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, -2, -1};      //-2, -1 ,1 ,2
        LCR007三数之和 a = new LCR007三数之和();
        for (List<Integer> integers : a.threeSum(nums)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /*可以退化成两数之和，但是注意要不能重复*/
    public List<List<Integer>> threeSum(int[] nums) {
        /*为了去重，可以先排序*/
        Arrays.sort(nums);
        int temp = -100001;
        /*因为有序，固定住一个之后可以二分*/
        for (int i = 0; i < nums.length - 1; i++) {
            if (temp != nums[i]) {
                temp = nums[i];
                twoSum(i, i + 1, nums, -nums[i]);
            }
        }
        return list;
    }

    /*二分查找两数之和*/
    public List<List<Integer>> twoSum(int index, int start, int[] sums, int target) {
        int temp = -10001;
        for (int i = start; i < sums.length - 1; i++) {
            List<Integer> result = new LinkedList<>();
            if (sums[i] != temp) {
                temp = sums[i];
                int left = i + 1;
                int right = sums.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (sums[mid] == target - sums[i]) {
                        result.add(sums[index]);
                        result.add(sums[i]);
                        result.add(sums[mid]);
                        break;
                    }
                    if (sums[mid] < target - sums[i]) {
                        left = mid + 1;
                    }
                    if (sums[mid] > target - sums[i]) {
                        right = mid - 1;
                    }
                }
                if (!result.isEmpty())
                    list.add(result);
            }
        }
        return list;
    }

}