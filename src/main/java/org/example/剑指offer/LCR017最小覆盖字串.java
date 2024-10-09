package org.example.剑指offer;

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
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
/*        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), s.charAt(i) - 1);
                if (map.get(s.charAt(i)) == 0)
            }
        }*/
        int min_length = 10000;
        int p1 = 0, p2 = t.length() - 1;
        int size = map.size();
        while (p1 <= p2 && p2 < s.length() - 1) {
            p2++;
            if (map.containsKey(s.charAt(p2))) {
                map.put(s.charAt(p2), map.get(s.charAt(p2)) - 1);
                if (map.get(s.charAt(p2)) == 0) {
                    size--;
                    if (size == 0)
                        min_length = Math.min(p2 - p1 + 1, min_length);
                }
            }

        }
        //todo
        return "";
    }
}
