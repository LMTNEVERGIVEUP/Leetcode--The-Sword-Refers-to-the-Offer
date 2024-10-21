package org.lmt.剑指offer.集合;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR081组合总和2 </p >
 * <p>Description: LCR081组合总和2 </p >
 * Package: org.example.剑指offer.集合
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 10:40
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR082组合总和2 {
    public static void main(String[] args) {
        LCR082组合总和2 a = new LCR082组合总和2();
        List<List<Integer>> lists = a.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);     //1,1,2,5,6,7,10
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        /*排序数组，用于去重*/
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new LinkedList<Integer>(), list, 0);
        return list;
    }

    /*dfs，需要注意去重*/
    public void dfs(int[] candidates, int target, int index, LinkedList<Integer> list, List<List<Integer>> result, int sum) {
        if (sum > target)
            return;
        if (sum == target) {
            result.add(new LinkedList<>(list));
        }
        /*定义temp记录当前循环到的元素的前一个元素，用于去重*/
        int temp = 0;
        for (int i = index; i < candidates.length; i++) {
            /*前一个元素不等于当前元素，代表并没有重复*/
            if (candidates[i] != temp) {
                list.add(candidates[i]);
                sum += candidates[i];
                dfs(candidates, target, i + 1, list, result, sum);
                list.removeLast();
                sum -= candidates[i];
                /*更新temp*/
                temp = candidates[i];
            }

        }
    }
}
