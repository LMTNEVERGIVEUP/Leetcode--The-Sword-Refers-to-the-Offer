package org.lmt.剑指offer.树;

import org.lmt.剑指offer.utils.TreeNode;

/**
 * <p>Title: LCR053二叉搜索树的中序后继 </p >
 * <p>Description: LCR053二叉搜索树的中序后继 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 11:55
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR053二叉搜索树的中序后继 {
    public TreeNode pre;
    public TreeNode result;

    public static void main(String[] args) {
        TreeNode p6 = new TreeNode(1, null, null);
        TreeNode p5 = new TreeNode(4, null, null);
        TreeNode p4 = new TreeNode(2, p6, null);
        TreeNode p3 = new TreeNode(6, null, null);
        TreeNode p2 = new TreeNode(3, p4, p5);
        TreeNode p1 = new TreeNode(5, p2, p3);
        LCR053二叉搜索树的中序后继 a = new LCR053二叉搜索树的中序后继();
        System.out.println(a.inorderSuccessor(p1, p3).val);
    }

    /*设置一个pre用于指向前驱*/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return result;
    }

    /*中序遍历*/
    public void dfs(TreeNode root, TreeNode p) {
        if (root == null)
            return;
        dfs(root.left, p);
        /*当前驱节点等于想要的节点，那么下一个节点就是它的中序后继*/
        if (pre == p)
            result = root;
        pre = root;
        dfs(root.right, p);
    }
    /*时间复杂度o(n),空间复杂度o(1)*/
}
