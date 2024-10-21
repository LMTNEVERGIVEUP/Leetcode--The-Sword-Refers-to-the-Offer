package org.lmt.剑指offer.图;

import java.util.*;

/**
 * <p>Title: LCR108单词接龙 </p >
 * <p>Description: LCR108单词接龙 </p >
 * Package: org.example.剑指offer.图
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/20 13:19
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR108单词接龙 {
    /*记录每个单词的编号*/
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    /*记录图中每个节点的相邻节点*/
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    /*nodeNum 记录当前节点的编号，初始值为 0*/
    int nodeNum = 0;

    public static void main(String[] args) {
        LCR108单词接龙 a = new LCR108单词接龙();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(a.ladderLength("hit", "cog", list));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*为每个 wordList 中的单词建立边*/
        for (String word : wordList) {
            addEdge(word);
        }
        /*将 beginWord 也加入图中*/
        addEdge(beginWord);
        /*如果 wordId 中没有 endWord，无法转换，返回 0*/
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        /*dis 数组用于存储每个节点的距离，初始时都为无穷大*/
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        /*获取 beginWord 和 endWord 的编号*/
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        /*bfs*/
        while (!que.isEmpty()) {
            int x = que.poll();
            /*除以2是因为存储双向边*/
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    /*更新该节点的距离*/
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        /*构建该单词的所有通配符形式*/
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            /*给该单词分配一个新编号，并将其加入到邻接表中*/
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }

}
