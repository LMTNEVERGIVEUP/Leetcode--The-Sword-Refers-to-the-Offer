package org.example.剑指offer.树;

import org.example.剑指offer.utils.Tree;
import org.example.剑指offer.utils.TreeNode;

/**
 * <p>Title: LCR048二叉树的序列化和反序列化 </p >
 * <p>Description: LCR048二叉树的序列化和反序列化 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 16:17
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR048二叉树的序列化和反序列化 {
    public static void main(String[] args) {
        TreeNode p5 = new TreeNode(5, null, null);
        TreeNode p4 = new TreeNode(4, null, null);
        TreeNode p3 = new TreeNode(3, p4, p5);
        TreeNode p2 = new TreeNode(2, null, null);
        TreeNode p1 = new TreeNode(1, p2, p3);
        Codec codec = new Codec();
        System.out.println("序列化之前：");
        Tree.level_print(p1);
        System.out.println("----------------------------");
        System.out.println("序列化之后：");
        System.out.println(codec.serialize(p1));
        System.out.println("----------------------------");
        System.out.println("反序列化之后：");
        Tree.level_print(p1);
    }

}
//todo
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}