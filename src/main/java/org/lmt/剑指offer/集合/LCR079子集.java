package org.lmt.剑指offer.集合;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR079子集 </p >
 * <p>Description: LCR079子集 </p >
 * Package: org.example.剑指offer.排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 16:50
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR079子集 {
    public static void main(String[] args) {
        LCR079子集 a = new LCR079子集();
        List<List<Integer>> subsets = a.subsets(new int[]{1, 2, 3});  // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        for (List<Integer> subset : subsets) {
            for (Integer i : subset) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /*dfs即可*/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(nums, new LinkedList<>(), result, 0);
        return result;
    }

    public void dfs(int[] nums, LinkedList<Integer> list, List<List<Integer>> result, int index) {
        /*因为list是引用类型，所以往一个双层list添加一个list的时候需要深拷贝一个*/
        result.add(new LinkedList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, list, result, i + 1);
            /*因为list是引用类型，所以需要回溯时需要删除刚加进来的*/
            list.removeLast();
        }
    }
}
