package org.lmt.剑指offer.utils;

/**
 * <p>Title: Trie </p >
 * <p>Description: Trie </p >
 * Package: org.example.剑指offer.utils
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/14 11:02
 *
 * @author LiMengTing
 * @version 1.0.0
 */
/*前缀树*/
public class Trie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
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


    /*前缀树里是否存在输入词的前缀*/
    public String startsEnd(String word) {
        TrieNode node = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null)
                if (node.isWord)
                    return stringBuilder.toString();
                else
                    return "";
            else {
                node = node.children[word.charAt(i) - 'a'];
                stringBuilder.append(word.charAt(i));
                if (node.isWord)
                    return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
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