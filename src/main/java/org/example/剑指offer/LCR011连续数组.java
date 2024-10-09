package org.example.剑指offer;

import java.util.HashMap;

/**
 * <p>Title: LCR011连续数组 </p >
 * <p>Description: LCR011连续数组 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/9 11:27
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR011连续数组 {
    public static void main(String[] args) {
        int[] p = {-1, 1, -1};
        LCR011连续数组 a = new LCR011连续数组();
        System.out.println(a.findMaxLength(p));
    }

    /*先将所有0换成-1，这样的话具有相同数量的0和1加起来就一定是0*/
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }
        /*这样就转化成了求连续子数组为0的长度*/
        int sum = 0;
        int max_length = 0;
        /*map<前缀和，对应最小下标>*/
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum))
                max_length = Math.max(max_length, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return max_length;
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
