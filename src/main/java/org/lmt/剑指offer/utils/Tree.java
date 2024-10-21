package org.lmt.剑指offer.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Title: Tree </p >
 * <p>Description: Tree </p >
 * Package: org.example.剑指offer.utils
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 14:28
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class Tree {
    /*前序遍历*/
    public static void pre_print(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.val);
        pre_print(node.left);
        pre_print(node.right);
    }

    /*层序遍历*/
    public static void level_print(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            System.out.println(treeNode.val);
            if (treeNode.left != null)
                queue.offer(treeNode.left);
            if (treeNode.right != null)
                queue.offer(treeNode.right);
        }
    }
}
