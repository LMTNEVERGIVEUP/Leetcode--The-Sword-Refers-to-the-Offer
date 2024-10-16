package org.example.剑指offer.集合;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR084全排列2 </p >
 * <p>Description: LCR084全排列2 </p >
 * Package: org.example.剑指offer.集合
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 11:35
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR084全排列2 {
    public static void main(String[] args) {
        LCR084全排列2 a = new LCR084全排列2();
        List<List<Integer>> lists = a.permuteUnique(new int[]{3, 3, 0, 3});  //112 121
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println(" ");
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums, result, new LinkedList<>(), new int[nums.length]);
        return result;
    }

    /*dfs 定义标志数组flag用于判断对应元素是否被使用过*/
    public void dfs(int[] nums, List<List<Integer>> result, LinkedList<Integer> list, int[] flag) {
        /*达到数组长度就增加*/
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
        }
        /*定义temp保存上一次循环的变量*/
        int temp = -11;
        for (int i = 0; i < nums.length; i++) {
            /*如果这次变量不等于上次的变量且这个变量还没有被用过*/
            if (temp != nums[i] && flag[i] == 0) {
                list.add(nums[i]);
                /*修改标志位代表使用过*/
                flag[i] = 1;
                dfs(nums, result, list, flag);
                /*结束后再把标志位修改回来*/
                flag[i] = 0;
                list.removeLast();
                temp = nums[i];
            }
        }

    }
}
