package org.example.剑指offer.集合;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR080组合 </p >
 * <p>Description: LCR080组合 </p >
 * Package: org.example.剑指offer.集合
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 17:45
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR080组合 {
    public static void main(String[] args) {
        LCR080组合 a = new LCR080组合();
        List<List<Integer>> combine = a.combine(4, 2);  //[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /*dfs回溯*/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        dfs(result, new LinkedList<>(), nums, 0, k);
        return result;
    }

    /*递归*/
    public void dfs(List<List<Integer>> result, LinkedList<Integer> list, int[] nums, int index, int k) {
        /*每次进入递归，k减少1*/
        k--;
        /*当k<0，代表集合中的元素个数已经k个了，直接返回*/
        if (k < 0)
            return;
        for (int i = index; i < nums.length; i++) {
            /*k==0代表元素个数刚好为k个，加入result集合*/
            if (k == 0) {
                list.add(nums[i]);
                result.add(new LinkedList<>(list));
            } else
                /*否则代表不满k个，继续往集合里增加元素*/
                list.add(nums[i]);
            dfs(result, list, nums, i + 1, k);
            /*因为list为引用类型，因此往上回溯需要移出最后一个元素*/
            list.removeLast();
        }

    }
}
