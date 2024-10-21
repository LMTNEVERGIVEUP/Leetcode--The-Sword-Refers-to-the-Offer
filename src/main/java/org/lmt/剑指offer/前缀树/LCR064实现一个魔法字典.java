package org.lmt.剑指offer.前缀树;


/**
 * <p>Title: LCR064实现一个魔法字典 </p >
 * <p>Description: LCR064实现一个魔法字典 </p >
 * Package: org.example.剑指offer.前缀树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/14 13:29
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR064实现一个魔法字典 {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello")); // 返回 False
        System.out.println(magicDictionary.search("hhllo")); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        System.out.println(magicDictionary.search("hell")); // 返回 False
        System.out.println(magicDictionary.search("leetcoded")); // 返回 False
    }

}

class MagicDictionary {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        root = new TrieNode();

    }

    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            TrieNode root = this.root;
            for (int j = 0; j < dictionary[i].length(); j++) {
                if (root.children[dictionary[i].charAt(j) - 'a'] == null) {
                    root.children[dictionary[i].charAt(j) - 'a'] = new TrieNode();
                }
                root = root.children[dictionary[i].charAt(j) - 'a'];

            }
            root.isWord = true;
        }


    }

    public boolean search(String searchWord) {
        int edit = 0;
        int i = 0;
        return dfs(root, searchWord, i, edit);
    }

    public boolean dfs(TrieNode root, String word, int i, int edit) {
        if (root == null)
            return false;
        if (i == word.length() && root.isWord && edit == 1)
            return true;
        if (i < word.length() && edit <= 1) {
            boolean found = false;
            for (int j = 0; j < 26 && !found; j++) {
                int next = j == word.charAt(i) - 'a' ? edit : edit + 1;
                found = dfs(root.children[j], word, i + 1, next);
            }
            return found;
        }
        return false;
    }
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        private TrieNode root;

        TrieNode() {
            children = new TrieNode[26];
        }

    }
}


