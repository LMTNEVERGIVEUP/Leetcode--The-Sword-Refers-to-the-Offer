package org.example.剑指offer.前缀树;

/**
 * <p>Title: LCR067数组中两个数的最大异或值 </p >
 * <p>Description: LCR067数组中两个数的最大异或值 </p >
 * Package: org.example.剑指offer.前缀树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/14 14:40
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR067数组中两个数的最大异或值 {
    public static void main(String[] args) {
        LCR067数组中两个数的最大异或值 a = new LCR067数组中两个数的最大异或值();
        System.out.println(a.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }

    // 字典树的根节点
    TRI root = new TRI();
    // 最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int x = 0;
        for (int i = 1; i < n; ++i) {
            // 将 nums[i-1] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
            add(nums[i - 1]);
            // 将 nums[i] 看作 ai，找出最大的 x 更新答案
            x = Math.max(x, check(nums[i]));
        }
        return x;
    }

    public void add(int num) {
        TRI cur = root;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (cur.left == null) {
                    cur.left = new TRI();
                }
                cur = cur.left;
            }
            else {
                if (cur.right == null) {
                    cur.right = new TRI();
                }
                cur = cur.right;
            }
        }
    }

    public int check(int num) {
        TRI cur = root;
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走
                if (cur.right != null) {
                    cur = cur.right;
                    x = x * 2 + 1;
                } else {
                    cur = cur.left;
                    x = x * 2;
                }
            } else {
                // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
                if (cur.left != null) {
                    cur = cur.left;
                    x = x * 2 + 1;
                } else {
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }
}

class TRI {
    // 左子树指向表示 0 的子节点
    TRI left = null;
    // 右子树指向表示 1 的子节点
    TRI right = null;
}


