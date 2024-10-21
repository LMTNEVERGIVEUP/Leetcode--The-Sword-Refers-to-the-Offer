package org.lmt.剑指offer.并查集;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: LCR119最长连续序列 </p >
 * <p>Description: LCR119最长连续序列 </p >
 * Package: org.lmt.剑指offer.并查集
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/21 13:26
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR119最长连续序列 {
    public static void main(String[] args) {
        LCR119最长连续序列 a = new LCR119最长连续序列();
        System.out.println(a.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    private int[] root;
    /*记录每个数对应的索引位置*/
    private Map<Integer, Integer> pos = new HashMap<>(); //

    /*并查集*/
    public int longestConsecutive(int[] nums) {
        root = new int[nums.length];
        /*将 root 数组所有元素初始化为 -1，表示初始状态*/
        Arrays.fill(root, -1);
        int ans = 0;
        /*遍历数组*/
        for (int i = 0; i < nums.length; i++) {
            /*如果当前数字已经出现过，跳过*/
            if (pos.containsKey(nums[i])) {
                continue;
            }
            /*记录 nums[i] 的位置*/
            pos.put(nums[i], i);
            if (pos.containsKey(nums[i] - 1)) {
                int rtIndex = findRoot(pos.get(nums[i] - 1));
                root[rtIndex]--;
                root[i] = rtIndex;
            }
            if (pos.containsKey(nums[i] + 1)) {
                int rtIndex = findRoot(i);
                root[rtIndex] += root[pos.get(nums[i] + 1)];
                root[pos.get(nums[i] + 1)] = rtIndex;
            }
            /*更新答案为当前最长连续序列*/
            ans = Math.max(ans, -root[findRoot(i)]);
        }
        return ans;
    }
    /*路径压缩*/
    private int findRoot(int index) {
        if (root[index] < 0) {
            return index;
        }
        root[index] = findRoot(root[index]);
        return root[index];
    }
}
