package org.lmt.剑指offer.树;

import org.lmt.剑指offer.utils.Tree;
import org.lmt.剑指offer.utils.TreeNode;

/**
 * <p>Title: LCR054把二叉搜索树转换为累加树 </p >
 * <p>Description: LCR054把二叉搜索树转换为累加树 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 14:22
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR054把二叉搜索树转换为累加树 {
    int sum = 0;

    public static void main(String[] args) {
        TreeNode p9 = new TreeNode(8, null, null);
        TreeNode p8 = new TreeNode(3, null, null);
        TreeNode p7 = new TreeNode(7, null, p9);
        TreeNode p6 = new TreeNode(5, null, null);
        TreeNode p5 = new TreeNode(2, null, p8);
        TreeNode p4 = new TreeNode(0, null, null);
        TreeNode p3 = new TreeNode(6, p6, p7);
        TreeNode p2 = new TreeNode(1, p4, p5);
        TreeNode p1 = new TreeNode(4, p2, p3);
        LCR054把二叉搜索树转换为累加树 a = new LCR054把二叉搜索树转换为累加树();
        Tree.level_print(a.convertBST(p1));
    }

    /*倒中序遍历*/
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    /*右、中、左顺序遍历*/
    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.right);
        /*加上当前节点的和*/
        sum += root.val;
        /*替换为大于等于该节点的和*/
        root.val = sum;
        dfs(root.left);
    }
}
