package org.example.剑指offer.字符串;

import java.util.HashMap;

/**
 * <p>Title: LCR017最小覆盖字串 </p >
 * <p>Description: LCR017最小覆盖字串 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/9 16:47
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR017最小覆盖字串 {
    public static void main(String[] args) {
        LCR017最小覆盖字串 a = new LCR017最小覆盖字串();
        System.out.println(a.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = hashMap.size();
        int p1 = 0;
        int p2 = 0;
        int minp1 = 0;
        int minp2 = 0;
        int minlength = 100001;
        while (p2 < s.length() || count == 0 && p2 == s.length()) {
            if (count > 0) {
                if (hashMap.containsKey(s.charAt(p2))) {
                    hashMap.put(s.charAt(p2), hashMap.get(s.charAt(p2)) - 1);
                    if (hashMap.get(s.charAt(p2)) == 0)
                        count--;
                }
                p2++;
            } else {
                if (p2 - p1 < minlength) {
                    minp1 = p1;
                    minp2 = p2;
                    minlength = p2 - p1;
                }
                if(hashMap.containsKey(s.charAt(p1))) {
                    hashMap.put(s.charAt(p1), hashMap.get(s.charAt(p1)) + 1);
                    if (hashMap.get(s.charAt(p1)) > 0)
                        count++;
                }
                p1++;
            }
        }
        return s.substring(minp1, minp2);
    }
}
