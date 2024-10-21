package org.lmt.剑指offer.集合;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR081组合总和 </p >
 * <p>Description: LCR081组合总和 </p >
 * Package: org.example.剑指offer.集合
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 08:55
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR081组合总和 {
    int sum = 0;

    public static void main(String[] args) {
        LCR081组合总和 a = new LCR081组合总和();
        List<List<Integer>> lists = a.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        dfs(candidates, 0, list, new LinkedList<Integer>(), target, 0);
        return list;
    }

    /*dfs*/
    public void dfs(int[] nums, int index, List<List<Integer>> result, LinkedList<Integer> list, int target, int sum) {
        /*如果target==sum，则找到了*/
        if (sum == target) {
            result.add(new LinkedList<>(list));
        }
        /*如果target大于sum，则返回*/
        if (sum > target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            sum = sum + nums[i];
            dfs(nums, i, result, list, target, sum);
            /*用完元素需要移出元素*/
            list.removeLast();
            /*在循环内移出元素需要减去该元素的值*/
            sum = sum - nums[i];
        }
    }
}
