package org.example.剑指offer.集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /*定义布尔二维数组，f[i][j] 表示从i到j的子串是否为回文*/
    boolean[][] f;
    /*存储当前的所有回文分割组合*/
    List<List<String>> tmp = new ArrayList<List<String>>();
    /*存储当前的回文分割路径*/
    List<String> ans = new ArrayList<String>();
    int n;
    public String[][] partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        /*初始时假设每个子串都是回文串*/
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        /*从后往前遍历，判断所有长度大于1的子串是否为回文*/
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                /*如果 s[i] 和 s[j] 相等，且中间的子串 f[i + 1][j - 1] 是回文，则 f[i][j] 为回文*/
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        /*通过深度优先搜索 (DFS) 查找所有的回文分割组合*/
        dfs(s, 0);

        /*将结果 tmp 转换为二维字符串数组*/
        int rows = tmp.size();
        String[][] ret = new String[rows][];
        for (int i = 0; i < rows; ++i) {
            int cols = tmp.get(i).size();
            ret[i] = new String[cols]; // 创建列
            for (int j = 0; j < cols; ++j) {
                ret[i][j] = tmp.get(i).get(j); // 将列表中的元素逐个复制到二维数组中
            }
        }
        return ret;
    }


    public void dfs(String s, int i) {
        /*如果已经到达字符串的末尾，说明找到了一种分割方式，将其加入 tmp 中*/
        if (i == n) {
            tmp.add(new ArrayList<String>(ans)); // 将当前的回文路径 ans 加入到结果中
            return;
        }

        /*尝试将当前的字符 s[i] 到 s[j] 分割出来，如果是回文则递归处理剩余部分*/
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                /*回溯，移除最后一个加入的子串*/
                ans.remove(ans.size() - 1);
            }
        }
    }


}
