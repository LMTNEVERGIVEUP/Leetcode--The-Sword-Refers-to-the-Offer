package org.example.剑指offer.哈希表;

import java.util.HashMap;

/**
 * <p>Title: LCR034验证外星语字典 </p >
 * <p>Description: LCR034验证外星语字典 </p >
 * Package: org.example.剑指offer.红黑树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/11 21:49
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR034验证外星语字典 {
    public static void main(String[] args) {
        LCR034验证外星语字典 a = new LCR034验证外星语字典();
        System.out.println(a.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    /*使用hashmap<字符，字符在order中的顺序>存储字典*/
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        /*存储order中的字符以及它们的位置*/
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        /*两两进行对比*/
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(map, words[i], words[i + 1]))
                return false;
        }
        return true;
    }

    /*对比过程*/
    public boolean compare(HashMap<Character, Integer> map, String a, String b) {
        int i = 0;
        while (i < a.length() && i < b.length()) {
            /*如果左边相同位置的字符小于右边的，则不用看后面的，直接符合语法*/
            if (map.get(a.charAt(i)) < map.get(b.charAt(i)))
                return true;
                /*如果左边相同位置的字符大于右边的，则不用看后面的，直接不符合语法*/
            else if (map.get(a.charAt(i)) > map.get(b.charAt(i)))
                return false;
                /*如果左边相同位置的字符等于右边的，则继续往下比较*/
            else
                i++;
        }
        /*如果一个字符串是另一个字符串的字串，则判断左边的字符串长度是否大于右边，大于右边则不符合语法，反之符合语法*/
        return a.length() <= b.length();
    }
}
