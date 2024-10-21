package org.lmt.剑指offer.集合;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR085括号生成 </p >
 * <p>Description: LCR085括号生成 </p >
 * Package: org.example.剑指offer.集合
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 13:29
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR085括号生成 {
    public static void main(String[] args) {
        LCR085括号生成 a = new LCR085括号生成();
        List<String> result = a.generateParenthesis(3);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    /*"((()))","(()())","(())()","()(())","()()()"*/
    public List<String> generateParenthesis(int n) {
        LinkedList<String> list = new LinkedList<>();
        dfs(list, 0, 0, n, new StringBuilder());
        return list;
    }

    /*dfs*/
    /*一定是左括号的个数先比右括号多，不可能出现某个时刻左括号的个数小于右括号的个数。而且左括号和右括号最终一定都是2/n个*/
    public void dfs(LinkedList<String> list, int left, int right, int n, StringBuilder sb) {
        /*如果左括号的个数加上右括号的个数等于所需要的括号数，代表一种括号表达式生成完毕*/
        if (left + right == 2 * n) {
            list.add(sb.toString());
        }
        /*如果左括号的个数小于需要的左括号数，加左括号*/
        if (left < n) {
            sb.append("(");
            dfs(list, left + 1, right, n, sb);
            /*回溯，删除新加进来的元素*/
            sb.deleteCharAt(sb.length() - 1);
        }
        /*如果左括号数大于右括号数，加右括号*/
        if (right < left) {
            sb.append(")");
            dfs(list, left, right + 1, n, sb);
            /*回溯，删除新加进来的元素*/
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
