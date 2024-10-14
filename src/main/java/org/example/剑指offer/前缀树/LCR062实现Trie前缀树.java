package org.example.剑指offer.前缀树;

/**
 * <p>Title: LCR062实现Trie前缀树 </p >
 * <p>Description: LCR062实现Trie前缀树 </p >
 * Package: org.example.剑指offer.排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/14 10:11
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR062实现Trie前缀树 {
    public static void main(String[] args) {
        TREE TRI = new TREE();
        TRI.insert("apple");
        System.out.println(TRI.search("apple"));   // 返回 True
        System.out.println(TRI.search("app"));     // 返回 False
        System.out.println(TRI.startsWith("app")); // 返回 True
        TRI.insert("app");
        System.out.println(TRI.search("app"));
    }

}


class TREE {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public TREE() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new TrieNode();
                if (i == word.length() - 1)
                    node.children[word.charAt(i) - 'a'].isWord = true;
                node = node.children[word.charAt(i) - 'a'];
            } else {
                node = node.children[word.charAt(i) - 'a'];
                if (i == word.length() - 1)
                    node.isWord = true;
            }
        }

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null)
                return false;
            else {
                node = node.children[word.charAt(i) - 'a'];
                if (i == word.length() - 1)
                    if (!node.isWord)
                        return false;
            }
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children[prefix.charAt(i) - 'a'] == null)
                return false;
            else {
                node = node.children[prefix.charAt(i) - 'a'];
            }
        }
        return true;
    }

}

class TrieNode {
    TrieNode[] children;
    boolean isWord = false;

    public TrieNode() {
        this.children = new TrieNode[26];
    }

    public TrieNode(boolean isWord) {
        this.isWord = isWord;
    }
}