package org.lmt.剑指offer.数组;

/**
 * <p>Title: LCR001两数相除 </p >
 * <p>Description: LCR001两数相除 </p >
 * Package: org.example.剑指offer.数组
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/21 11:22
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR001两数相除 {
    public static void main(String[] args) {
        LCR001两数相除 a = new LCR001两数相除();
        System.out.println(a.divide(15, 2));
    }
    /*位运算*/
    public int divide(int dividend, int divisor) {
        /*处理特殊情况：若 dividend 为 Integer.MAX_VALUE 且 divisor 为 -1，则结果超出范围，应返回 Integer.MAX_VALUE*/
        if (dividend == Integer.MAX_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        /*取被除数和除数的绝对值*/
        long m = Math.abs((long) dividend), n = Math.abs((long) divisor), res = 0;
        /*判断结果的符号：如果两者符号不同，则结果为负数*/
        int sign = ((dividend > 0) ^ (divisor > 0)) ? -1 : 1;
        /*如果除数为 1，直接返回结果*/
        if (n == 1) {
            return sign == 1 ? (int) m : (int) -m;
        }
        /*使用位运算进行除法操作*/
        while (m >= n) {
            long t = n, p = 1;
            /*将除数乘以2直到大于被除数*/
            while (m >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            /*累加当前倍数到结果中*/
            res += p;
            /*减去当前倍数的除数*/
            m -= t;
        }
        /*根据符号返回最终结果*/
        return sign == 1 ? (int) res : (int) -res;
    }
    /*时间复杂度o(logn)，空间复杂度o(1)*/
}
