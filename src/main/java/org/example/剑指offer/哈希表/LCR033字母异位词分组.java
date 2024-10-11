package org.example.剑指offer.哈希表;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR033字母异位词分组 </p >
 * <p>Description: LCR033字母异位词分组 </p >
 * Package: org.example.剑指offer.哈希表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/11 21:10
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR033字母异位词分组 {
    public static void main(String[] args) {
        LCR033字母异位词分组 a = new LCR033字母异位词分组();
        List<List<String>> lists = a.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    /*可以将26个英文字母映射到一个个质数上，这样可以使得变位词的因式唯一，因此如果找到了两个字符串对应一样的数，那么这两个字符串一定是一对变位词*/
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        /*26个质数*/
        int[] p = new int[]{3, 5, 7, 11, 13, 17, 19, 23, 27, 29, 31, 37, 39, 41, 43, 47, 51, 53, 57, 59, 61, 67, 71, 73, 79, 83};
        /*使用hashmap存储每个单词的乘积以及他们的变位词列表*/
        HashMap<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            long value = 1L;
            /*计算乘积*/
            for (int j = 0; j < str.length(); j++) {
                value *= p[str.charAt(j) - 'a'];
            }
            /*如果map中存在乘积，则加入到列表当中*/
            if (map.containsKey(value))
                map.get(value).add(str);
                /*如果不存在，则新建一个列表并放入hashmap*/
            else {
                List<String> list = new LinkedList<>();
                /*map的value设为list的好处是将list加入到result中后hashmap和result引用了其实是同样的list对象（因为hashmap存放value的是引用，而result为list，里面存放的也是对象的引用）
                 这样我通过hashmap在list里面加节点其实也是在result里面的那个list里面加节点*/
                result.add(list);
                list.add(str);
                map.put(value, list);
            }
        }

        return result;
    }
}
