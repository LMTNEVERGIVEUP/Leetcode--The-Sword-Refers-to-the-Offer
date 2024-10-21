package org.lmt.剑指offer.字符串;

/**
 * <p>Title: LCR020回文字串 </p >
 * <p>Description: LCR020回文字串 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/10 13:59
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR020回文字串 {
    public static void main(String[] args) {
        LCR020回文字串 a = new LCR020回文字串();
        System.out.println(a.countSubstrings("abc"));
    }

    /*从左向右依次将该字符当作中心字符串进行两边延申就可以求出以该字符串为中心存在多少个回文字符串，但是要分奇偶性讨论*/
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            /*回文串个数=以每个字符为中心的回文字符串个数的总和*/
            /*以该字符为中心的回文字符串的个数=以该字符为中心的奇数回文字符串的个数+以该字符为中心的偶数回文字符串的个数*/
            count = count + check(s, i, i) + check(s, i, i + 1);
        }
        return count;
    }

    /*判断某个字符串是否为回文字符串*/
    public int check(String s, int p1, int p2) {
        int count = 0;
        while (p1 >= 0 && p2 < s.length()) {
            if (s.charAt(p1) != s.charAt(p2))
                return count;
            count++;
            p1--;
            p2++;
        }
        return count;
    }

}
