package org.lmt.剑指offer.集合;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: LCR087复原IP地址 </p >
 * <p>Description: LCR087复原IP地址 </p >
 * Package: org.example.剑指offer.集合
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/16 14:07
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR087复原IP地址 {
    private List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        LCR087复原IP地址 a = new LCR087复原IP地址();
        System.out.println(a.restoreIpAddresses("25525511135"));
    }
    /*startIndex: 搜索的起始位置，pointNum: 添加逗号的数量*/
    private void backtracking(StringBuilder s, int startIndex, int pointNum) {
        /*如果逗号数量为3，则判断最后一个子字符串是否合法*/
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s.toString());
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            /*判断[startIndex, i]区间的子串是否合法*/
            if (isValid(s, startIndex, i)) {
                s.insert(i + 1, '.');
                pointNum++;
                backtracking(s, i + 2, pointNum);
                pointNum--;
                s.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }
  /* 判断字符串s在左闭右闭区间 [start, end] 所组成的数字是否合法*/
    private boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) return false;
         /*0开头的数字不合法，但允许单独为0*/
        if (s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
             /*判断是否为数字字符*/
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
             /*字符转数字并检查是否大于255*/
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }

    public List<String> restoreIpAddresses(String s) {
        result.clear();
        /* 剪枝操作，长度不符合则直接返回空结果*/
        if (s.length() < 4 || s.length() > 12)
            return result;
        /*回溯*/
        backtracking(new StringBuilder(s), 0, 0);
        return result;
    }

}
