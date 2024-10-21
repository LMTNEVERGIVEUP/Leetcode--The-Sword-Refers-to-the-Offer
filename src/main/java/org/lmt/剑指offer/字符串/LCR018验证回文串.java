package org.lmt.剑指offer.字符串;

/**
 * <p>Title: LCR018 </p >
 * <p>Description: LCR018 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/10 10:42
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR018验证回文串 {
    public static void main(String[] args) {
        LCR018验证回文串 A = new LCR018验证回文串();
        System.out.println(A.isPalindrome("0P"));
    }

    /*双指针判断指针所指位置是否一致*/
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        /*全部转换为小写字母*/
        s = s.toLowerCase();
        while (p1 <= p2) {
            /*每个字符必须在0~9,a~z之间，如果不在就直接跳过*/
            if (s.charAt(p1) > 'z' || s.charAt(p1) < '0' || (s.charAt(p1) > '9' && s.charAt(p1) < 'a'))
                p1++;
            else if (s.charAt(p2) > 'z' || s.charAt(p2) < '0' || (s.charAt(p2) > '9' && s.charAt(p2) < 'a'))
                p2--;
            else {
                /*判断是否一致，不一致直接返回false*/
                if (s.charAt(p1) != s.charAt(p2))
                    return false;
                    /*一致继续前进两个指针*/
                else {
                    p1++;
                    p2--;
                }
            }
        }
        return true;
    }
    /*时间复杂度o(n)，空间复杂度o(1)*/
}
