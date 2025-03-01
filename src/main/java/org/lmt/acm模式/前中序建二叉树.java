package org.lmt.acm模式;

import org.lmt.剑指offer.utils.Tree;
import org.lmt.剑指offer.utils.TreeNode;

import java.util.Scanner;

/**
 * <p>Title: 前中序建二叉树</p>
 * <p>Description: 前中序建二叉树</p>
 * Package: org.lmt.acm模式
 * Copyright: Copyright(c) LMT
 * Date: 2025/3/1 20:33
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class 前中序建二叉树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*前序ABDECFG*/
        /*中序DBEAFCG*/
        String pre = sc.next();
        String mid = sc.next();
        前中序建二叉树 前中序建二叉树 = new 前中序建二叉树();
        TreeNode root = 前中序建二叉树.build(pre, mid);
        Tree.level_print(root);
    }

    public TreeNode build(String a, String b) {
        if (a.isEmpty() || b.isEmpty())
            return null;
        /*先从前序遍历序列中找到根节点*/
        char c = a.charAt(0);
        /*再从中序遍历序列中定位到根节点，左边就是左子树，右边就是右子树*/
        int reg = b.indexOf(c);
        /*建立左子树*/
        TreeNode left = build(a.substring(1, reg + 1), b.substring(0, reg));
        /*建立右子树*/
        TreeNode right = build(a.substring(reg + 1), b.substring(reg + 1));
        /*根节点连接左右两棵树*/
        TreeNode root = new TreeNode(c, left, right);
        return root;
    }
}