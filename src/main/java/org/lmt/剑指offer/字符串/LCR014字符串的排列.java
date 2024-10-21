package org.lmt.剑指offer.字符串;

/**
 * <p>Title: LCR014字符串的排列 </p >
 * <p>Description: LCR014字符串的排列 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/9 15:03
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR014字符串的排列 {


    public static void main(String[] args) {
        LCR014字符串的排列 a = new LCR014字符串的排列();
        System.out.println(a.checkInclusion("food", "money"));
    }

    /*数组模拟hashmap*/
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        /*每个字符只能是24个英文字母中的一个*/
        int[] p = new int[24];
        char[] cs1 = s1.toCharArray();
        /*变位词对应数组元素加1*/
        for (int i = 0; i < cs1.length; i++) {
            p[cs1[i] - 'a']++;
        }
        char[] cs2 = s2.toCharArray();
        for (int i = 0; i < cs1.length; i++) {
            p[cs2[i] - 'a']--;
        }
        int p1 = 0, p2 = s1.length() - 1;
        if (check(p))
            return true;
        /*建立长度为变位词长度的滑动窗口*/
        while (p2 < s2.length() - 1) {
            p2++;
            p[cs2[p2] - 'a']--;
            p[cs2[p1] - 'a']++;
            p1++;
            if (check(p))
                return true;
        }
        return false;
    }
    /*时间复杂度o(n)，空间复杂度o(1)*/

    /*如果数组全为0，代表是变位词*/
    public boolean check(int[] k) {
        for (int i : k) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
