package org.example.剑指offer.字符串;

/**
 * <p>Title: LCR019验证回文字串2 </p >
 * <p>Description: LCR019验证回文字串2 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/10 13:41
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR019验证回文字串2 {
    public static void main(String[] args) {
        LCR019验证回文字串2 a = new LCR019验证回文字串2();
        System.out.println(a.validPalindrome("abc"));
    }

    /*双指针，如果两个指针对应不一致，则判断左指针右移一位的字符串和右指针左移一位的字符串是否有一个是回文串，是的话原串就是回文串，反之原串不是回文串*/
    public boolean validPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2))
                /*左指针右移一位的字符串和右指针左移一位的字符串有一个是回文串那么原串就是回文串*/
                return check(p1 + 1, p2, s) || check(p1, p2 - 1, s);
            p1++;
            p2--;
        }
        return true;
    }

    public boolean check(int start, int end, String s) {
        if (start == end)
            return true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    /*时间复杂度o(n)，空间复杂度o(1)*/
}
