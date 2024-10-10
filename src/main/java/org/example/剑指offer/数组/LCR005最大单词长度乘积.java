package org.example.剑指offer.数组;

/**
 * <p>Title: LCR005最大单词长度乘积 </p >
 * <p>Description: LCR005最大单词长度乘积 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/8 15:02
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR005最大单词长度乘积 {

    public static void main(String[] args) {
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        LCR005最大单词长度乘积 a = new LCR005最大单词长度乘积();
        System.out.println(a.maxProduct(words));
    }

    /*每一个单词用一个24位数字表示，代表a~z，有哪个字母对应位置就为1，否则为0*/
    public int maxProduct(String[] words) {
        /*k中每一个元素代表这个单词的位编码*/
        int[] k = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            /*针对每一个单词中的每一个字母和a的偏移量来决定对应的位编码中哪位为1*/
            for (char c : words[i].toCharArray()) {
                k[i] = k[i] | 1 << c - 'a';
            }
        }

        /*开始两两单词比较*/
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                /*如果两个单词的位编码每一位与出来都为0，代表这两个单词的每一位都不一样*/
                if ((k[i] & k[j]) == 0)
                    max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }
    /*时间复杂度：o(n^2),空间复杂度:o(n)*/
}
