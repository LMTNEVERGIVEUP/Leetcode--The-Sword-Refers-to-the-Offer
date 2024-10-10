package org.example.剑指offer.字符串;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR015找到字符串中所有字母的异位词 </p >
 * <p>Description: LCR015找到字符串中所有字母的异位词 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/9 15:50
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR015找到字符串中所有字母的异位词 {
    public static void main(String[] args) {
        LCR015找到字符串中所有字母的异位词 a = new LCR015找到字符串中所有字母的异位词();
        List<Integer> result = a.findAnagrams("cbaebabacd", "abc");
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    /*数组模拟hash表，和上一题几乎完全一致*/
    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> result = new LinkedList<>();
        if (s.length() < p.length())
            return result;
        int[] k = new int[26];
        for (char c : p.toCharArray()) {
            k[c - 'a']++;
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            k[cs[i] - 'a']--;
        }
        if (check(k))
            result.add(0);
        int p1 = 0, p2 = p.length() - 1;
        while (p2 < s.length() - 1) {
            p2++;
            k[cs[p2] - 'a']--;
            k[cs[p1] - 'a']++;
            p1++;
            if (check(k))
                result.add(p1);
        }
        return result;
    }

    public boolean check(int[] p) {
        for (int i : p) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
