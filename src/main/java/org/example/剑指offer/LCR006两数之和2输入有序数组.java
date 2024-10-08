package org.example.剑指offer;

import java.util.HashMap;

/**
 * <p>Title: LCR006两数之和2输入有序数组 </p >
 * <p>Description: LCR006两数之和2输入有序数组 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) AI+X
 * Date: 2024/10/8 15:32
 *
 * @author LiMengTing
 * @version 1.0.0
 */

public class LCR006两数之和2输入有序数组 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 6, 10};
        LCR006两数之和2输入有序数组 a = new LCR006两数之和2输入有序数组();
        for (int i : a.twoSum(numbers, 8)) {
            System.out.print(i + " ");
        }
    }

    /*使用hashmap存储<当前值，当前索引位置>*/
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            /*如果map中存在（target-当前遍历数字）的值，代表同时找到了这两个数*/
            if (map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]);
                result[1] = i;
            }
            /*否则插入key,value*/
            else
                map.put(numbers[i], i);
        }
        return result;
    }
    /*时间复杂度o(n),空间复杂度o(n)*/

}