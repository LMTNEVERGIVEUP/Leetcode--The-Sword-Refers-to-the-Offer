package org.lmt.剑指offer.拓扑排序;

import java.util.*;

/**
 * <p>Title: LCR114外星文字典 </p >
 * <p>Description: LCR114外星文字典 </p >
 * Package: org.example.剑指offer.拓扑排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/20 22:04
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR114火星字典 {
    public static void main(String[] args) {
        LCR114火星字典 a = new LCR114火星字典();
        System.out.println(a.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }

    /*拓扑排序*/
    public String alienOrder(String[] words) {
        /*hashmap<该字符，必须出现在该字符之后的字符集>*/
        HashMap<Character, Set<Character>> graph = new HashMap<>();
        /*hashmap<该字符，该字符的入度>*/
        HashMap<Character, Integer> inDegrees = new HashMap<>();
        /*遍历字典，初始化map和入度数组*/
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<Character>());
                inDegrees.putIfAbsent(c, 0);
            }
        }
        /*比较相邻的两个单词*/
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            /*如果w2是w1的子串，代表不存在排序*/
            if (w1.startsWith(w2) && !w1.equals(w2)) {
                return "";
            }
            /*遍历相邻两个单词对应位置的两个字符*/
            for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                /*直到遇到二者不等的情况，根据二者字符存放先后顺序关系*/
                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        /*增加第二个字符的入度*/
                        inDegrees.put(ch2, inDegrees.get(ch2) + 1);
                    }
                    /*后面的顺序就不再是规则了*/
                    break;
                }
            }
        }
        /*基于bfs遍历*/
        Queue<Character> queue = new LinkedList<>();
        for (Character c : inDegrees.keySet()) {
            /*存放入度为0的节点作为第一个遍历的节点*/
            if (inDegrees.get(c) == 0) {
                queue.add(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            Character temp = queue.poll();
            stringBuilder.append(temp);
            for (Character c : graph.get(temp)) {
                inDegrees.put(c, inDegrees.get(c) - 1);
                /*添加新的节点*/
                if (inDegrees.get(c) == 0)
                    queue.add(c);
            }
        }
        /*节点全部放入结果集代表找到了一条拓扑路径，否则代表不存在拓扑路径，返回空*/
        return stringBuilder.length() == graph.size() ? stringBuilder.toString() : "";
    }
}
