package org.lmt.剑指offer.树;

import org.lmt.剑指offer.utils.Tree;
import org.lmt.剑指offer.utils.TreeNode;

/**
 * <p>Title: LCR047二叉树减枝 </p >
 * <p>Description: LCR047二叉树减枝 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 15:31
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR047二叉树减枝 {
    public static void main(String[] args) {
        TreeNode p7 = new TreeNode(1, null, null);
        TreeNode p6 = new TreeNode(0, null, null);
        TreeNode p5 = new TreeNode(0, null, null);
        TreeNode p4 = new TreeNode(0, null, null);
        TreeNode p3 = new TreeNode(1, p6, p7);
        TreeNode p2 = new TreeNode(0, p4, p5);
        TreeNode p1 = new TreeNode(1, p2, p3);
        LCR047二叉树减枝 a = new LCR047二叉树减枝();
        Tree.level_print(a.pruneTree(p1));
    }

    /*dfs后序遍历*/
    public TreeNode pruneTree(TreeNode root) {
        /*因为还需要判断根节点，所以递归入口传入根节点的左节点和右节点而不是根节点*/
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (!left)
            root.left = null;
        if (!right)
            root.right = null;
        if (!left && !right && root.val == 0)
            return null;
        return root;
    }

    /*后序遍历*/
    public boolean dfs(TreeNode root) {
        if (root == null)
            return false;
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (!left)
            root.left = null;
        if (!right)
            root.right = null;
        /*当左子树和右子树不包含0且该结点的值为0，向上返回false*/
        if (root.val == 0 && !left && !right)
            return false;
            /*否则返回true*/
        else
            return true;

    }
    /*时间复杂度o(n)，空间复杂度o(1)*/
}
