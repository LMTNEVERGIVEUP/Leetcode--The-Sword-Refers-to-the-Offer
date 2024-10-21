package org.lmt.剑指offer.哈希表;

/**
 * <p>Title: LCR032有效的字母异位词 </p >
 * <p>Description: LCR032有效的字母异位词 </p >
 * Package: org.example.剑指offer.哈希表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/11 21:04
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR032有效的字母异位词 {
    public static void main(String[] args) {
        LCR032有效的字母异位词 a = new LCR032有效的字母异位词();
        System.out.println(a.isAnagram("anagram", "nagaram"));
    }

    /*使用数组模拟hashmap，因为数组可以遍历而且字符串由小写字母组成*/
    public boolean isAnagram(String s, String t) {
        if (s.equals(t))
            return false;
        int[] p = new int[26];
        for (int i = 0; i < s.length(); i++) {
            p[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            p[t.charAt(i) - 'a']--;
        }
        for (int i : p) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
