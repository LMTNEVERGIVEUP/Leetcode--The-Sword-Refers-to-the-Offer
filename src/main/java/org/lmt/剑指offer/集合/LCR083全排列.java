package org.lmt.剑指offer.集合;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR083全排列 </p >
 * <p>Description: LCR083全排列 </p >
 * Package: org.example.剑指offer.集合
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 11:02
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR083全排列 {
    public static void main(String[] args) {
        LCR083全排列 a = new LCR083全排列();
        List<List<Integer>> permute = a.permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(nums, new LinkedList<Integer>(), result, new int[nums.length]);
        return result;
    }

    /*dfs，传入flag数组，用于标记使用过的元素。假如有数组[1,2,3]。1->2之后1和2都被打上了标记，因此往后只能1->2->3*/
    public void dfs(int[] nums, LinkedList<Integer> list, List<List<Integer>> result, int[] flag) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            /*只能使用未使用过的元素*/
            if (flag[i] == 0) {
                list.add(nums[i]);
                flag[i] = 1;
                dfs(nums, list, result, flag);
                /*使用过后还原该元素的标记*/
                flag[i] = 0;
                list.removeLast();
            }
        }
    }
    /*时间复杂度o(n*n!),空间复杂度o(n*n)*/
}
