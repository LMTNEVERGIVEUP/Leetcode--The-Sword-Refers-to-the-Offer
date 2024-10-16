package org.example.剑指offer.集合;

/**
 * <p>Title: LCR086分割回文串 </p >
 * <p>Description: LCR086分割回文串 </p >
 * Package: org.example.剑指offer.集合
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 13:59
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR086分割回文串 {
    public static void main(String[] args) {
        LCR086分割回文串 a = new LCR086分割回文串();
        String[][] result = a.partition("google");
        for (String[] strings : result) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public String[][] partition(String s) {
        StringBuilder sb = new StringBuilder(s);
        //todo
        return null;

    }

    public void dfs(StringBuilder sb,int index)
    {}
}
