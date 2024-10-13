package org.example.剑指offer.树;

import org.example.剑指offer.utils.Tree;
import org.example.剑指offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR052递增顺序搜索树 </p >
 * <p>Description: LCR052递增顺序搜索树 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 11:39
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR052递增顺序搜索树 {
    public static void main(String[] args) {
        TreeNode p9 = new TreeNode(9, null, null);
        TreeNode p8 = new TreeNode(7, null, null);
        TreeNode p7 = new TreeNode(1, null, null);
        TreeNode p6 = new TreeNode(8, p8, p9);
        TreeNode p5 = new TreeNode(4, null, null);
        TreeNode p4 = new TreeNode(2, p7, null);
        TreeNode p3 = new TreeNode(6, null, p6);
        TreeNode p2 = new TreeNode(3, p4, p5);
        TreeNode p1 = new TreeNode(5, p2, p3);
        LCR052递增顺序搜索树 a = new LCR052递增顺序搜索树();
        Tree.pre_print(a.increasingBST(p1));
    }

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        dfs(root, list);
        TreeNode node = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            node.left = null;
            node.right = list.get(i);
            node = node.right;
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
