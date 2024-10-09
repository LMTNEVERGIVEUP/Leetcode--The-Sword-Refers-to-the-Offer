package org.example.剑指offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <p>Title: LCR016无重复字符的最长字串 </p >
 * <p>Description: LCR016无重复字符的最长字串 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/9 15:59
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR016无重复字符的最长字串 {
    public static void main(String[] args) {
        LCR016无重复字符的最长字串 a = new LCR016无重复字符的最长字串();
        System.out.println(a.lengthOfLongestSubstring("abc"));
    }

    /*双指针，hashSet记录出现的每个字符*/
    public int lengthOfLongestSubstring(String s) {
        /*字符串为空，直接返回0*/
        if (s.isEmpty())
            return 0;
        int max_length = 1;
        /*建立hashset用于记录出现过的字符*/
        HashSet<Character> set = new HashSet<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 <= p2 && p2 < s.length()) {
            /*如果set存在当前字符，更新不重复子串的最大长度，并且一步步移动左指针并从set中删除元素，直到集合不存在该元素*/
            if (set.contains(s.charAt(p2))) {
                max_length = Math.max(p2 - p1, max_length);
                set.remove(s.charAt(p1));
                p1++;
            }
            /*如果set不存在当前字符，往set中加入该字符*/
            else {
                set.add(s.charAt(p2));
                p2++;
            }
        }
        /*记录终止时的不重复字符串长度*/
        if (p1 <= p2) {
            max_length = Math.max(max_length, p2 - p1);
        }
        return max_length;
    }
    /*时间复杂度o(n),空间复杂度o(n)*/
}
