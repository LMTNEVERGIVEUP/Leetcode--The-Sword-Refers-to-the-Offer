package org.example.剑指offer.数组;

/**
 * <p>Title: LCR003比特位计数 </p >
 * <p>Description: LCR003比特位计数 </p >
 * Package: org.example.剑指offer.数组
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/21 11:18
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR003比特位计数 {
    public static void main(String[] args) {
        LCR003比特位计数 a = new LCR003比特位计数();
        for (int i : a.countBits(2)) {
            System.out.print(i + " ");
        }
    }

    public int[] countBits(int n) {
        int result[] = new int[n + 1];
        int i = 0;
        result[0] = 0;
        while (i <= n) {
            /*result[i>>1]表示i除以2后的1的个数,i&1用于检查i的最低位是否为1*/
            result[i] = result[i >> 1] + (i & 1);
            i++;
        }
        return result;
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
