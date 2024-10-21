package org.lmt.剑指offer.前缀树;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: LCR065单词的压缩编码 </p >
 * <p>Description: LCR065单词的压缩编码 </p >
 * Package: org.example.剑指offer.前缀树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/14 13:59
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR065单词的压缩编码 {
    public static void main(String[] args) {
        LCR065单词的压缩编码 a = new LCR065单词的压缩编码();
        System.out.println(a.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    /*字典树*/
    public int minimumLengthEncoding(String[] words) {
        Tr trie = new Tr();
        /*创建Map用来保存每个字典树叶子节点和对应的单词索引*/
        Map<Tr, Integer> nodes = new HashMap<Tr, Integer>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            Tr cur = trie;
            for (int j = word.length() - 1; j >= 0; --j) {
                cur = cur.get(word.charAt(j));
            }
            /*将当前单词的最后节点记录到Map 中*/
            nodes.put(cur, i);
        }

        int ans = 0;
        /*遍历字典树中的叶子节点*/
        for (Tr node : nodes.keySet()) {
            /*如果该节点的 count 为 0，说明该节点是叶子节点，没有后续字符*/
            if (node.count == 0) {
                /*加上该叶子节点对应的单词长度 + 1 (表示 # 符号)*/
                ans += words[nodes.get(node)].length() + 1;
            }
        }
        /*返回最短编码长度*/
        return ans;

    }
}

class Tr {
    Tr[] children;
    int count;

    Tr() {
        children = new Tr[26];
        count = 0;
    }

    public Tr get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new Tr();
            count++;
        }
        return children[c - 'a'];
    }

}
