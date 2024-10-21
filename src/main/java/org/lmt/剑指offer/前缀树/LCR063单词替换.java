package org.lmt.剑指offer.前缀树;

import org.lmt.剑指offer.utils.Trie;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR063单词替换 </p >
 * <p>Description: LCR063单词替换 </p >
 * Package: org.example.剑指offer.前缀树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/14 11:03
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR063单词替换 {
    public static void main(String[] args) {
        LCR063单词替换 a = new LCR063单词替换();
        List<String> dictionary = new LinkedList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        System.out.println(a.replaceWords(dictionary, "the cattle was rattled by the battery"));
    }

    /*判断每个词是不是包含某个前缀树里的单词，包含就替换*/
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        /*往前缀树里插入单词*/
        for (String s : dictionary) {
            trie.insert(s);
        }
        /*分割句子*/
        String[] splits = sentence.split(" ");
        for (int i = 0; i < splits.length; i++) {
            /*前缀树中存在当前单词的子单词，就替换该单词*/
            if (!trie.startsEnd(splits[i]).isEmpty())
                splits[i] = trie.startsEnd(splits[i]);
        }
        StringBuilder sb = new StringBuilder();
        /*还原句子*/
        for (String split : splits) {
            sb.append(split);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
