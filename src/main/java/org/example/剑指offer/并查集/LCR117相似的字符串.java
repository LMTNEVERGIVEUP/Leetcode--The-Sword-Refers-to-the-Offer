package org.example.剑指offer.并查集;

/**
 * <p>Title: LCR117相似的字符串 </p >
 * <p>Description: LCR117相似的字符串 </p >
 * Package: org.example.剑指offer.并查集
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/21 09:47
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR117相似的字符串 {
    public static void main(String[] args) {
        LCR117相似的字符串 a = new LCR117相似的字符串();
        System.out.println(a.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
    }

    /*采用并查集判断有多少个子图*/
    public int numSimilarGroups(String[] strs) {
        int[] fathers = new int[strs.length];
        /*初始化父节点数组*/
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        /*初始化子图个数*/
        int groups = strs.length;
        /*字符串两两合并*/
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length - 1; j++) {
                /*判断相邻两个字符串时候相似并且还没有被合并*/
                if (similar(strs[i], strs[j]) && union(fathers, i, j))
                    groups--;
            }
        }
        return groups;
    }

    /*判断其中一个字符串是否交换两个字母就和第二个字符串相等*/
    public boolean similar(String s1, String s2) {
        int diff = 0;
        /*因为都是异位词，所以只需要判断两个字符串中是否最多有两个字符不一致即可（相当于交换一次两个字母）*/
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        /*只交换了一次就返回true*/
        return diff <= 2;
    }

    /*并查集路径压缩优化*/
    public int findFather(int[] fathers, int i) {
        if (fathers[i] != i)
            fathers[i] = findFather(fathers, fathers[i]);
        return fathers[i];
    }

    /*合并*/
    public boolean union(int[] fathers, int i, int j) {
        /*寻找i和j的父节点*/
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        /*如果不等，建立父子关系*/
        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        /*否则代表已经是一个集合了*/
        return false;
    }
}
