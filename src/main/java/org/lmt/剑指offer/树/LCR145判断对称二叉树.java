package org.lmt.剑指offer.树;

import org.lmt.剑指offer.utils.TreeNode;

/**
 * <p>Title: LCR145判断对称二叉树</p>
 * <p>Description: LCR145判断对称二叉树</p>
 * Package: org.lmt.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2025/3/1 18:26
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR145判断对称二叉树 {
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(8, null, null);
        TreeNode p2 = new TreeNode(9, null, null);
        TreeNode p3 = new TreeNode(9, null, null);
        TreeNode p4 = new TreeNode(8, null, null);
        TreeNode p5 = new TreeNode(7, p2, p1);
        TreeNode p6 = new TreeNode(7, p4, p3);
        TreeNode p7 = new TreeNode(6, p6, p5);
        LCR145判断对称二叉树 lcr145判断对称二叉树 = new LCR145判断对称二叉树();
        System.out.println(lcr145判断对称二叉树.checkSymmetricTree(p7));
    }

    public boolean checkSymmetricTree(TreeNode root) {
        /*如果树为空，一定对称*/
        if (root == null)
            return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        /*如果左子树为空且右子树为空代表是叶子节点*/
        if (left == null && right == null)
            return true;
        /*有一个为空代表不对称*/
        if (left == null || right == null)
            return false;
        /*左子树的左节点等于右子树的右节点，左子树的右节点等于右子树的左节点，左子树的根节点等于右子树的根节点，三个条件都必须成立*/
        return dfs(left.left, right.right) && dfs(left.right, right.left) && left.val == right.val;
    }

}