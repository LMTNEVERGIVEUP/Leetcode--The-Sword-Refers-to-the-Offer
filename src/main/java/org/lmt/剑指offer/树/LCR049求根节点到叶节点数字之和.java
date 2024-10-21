package org.lmt.剑指offer.树;

import org.lmt.剑指offer.utils.TreeNode;

/**
 * <p>Title: LCR049求根节点到叶节点数字之和 </p >
 * <p>Description: LCR049求根节点到叶节点数字之和 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 10:23
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR049求根节点到叶节点数字之和 {
    int result = 0;

    public static void main(String[] args) {
        TreeNode p5 = new TreeNode(1, null, null);
        TreeNode p4 = new TreeNode(5, null, null);
        TreeNode p3 = new TreeNode(0, null, null);
        TreeNode p2 = new TreeNode(9, p4, p5);
        TreeNode p1 = new TreeNode(4, p2, p3);
        LCR049求根节点到叶节点数字之和 a = new LCR049求根节点到叶节点数字之和();
        System.out.println(a.sumNumbers(p1));

    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    /*先序遍历*/
    public void dfs(TreeNode root, int sum) {
        /*当前结点的左孩子为空且右孩子为空代表当前节点是叶子节点*/
        if (root.left == null && root.right == null) {
            /*加上叶子节点的值并且返回这条路径的和*/
            result = sum * 10 + result + root.val;
            return;
        }
        /*每遍历一层将和乘10+当前节点*/
        sum = sum * 10 + root.val;
        /*左或者右有一个为空是代表这条路径不存在*/
        if (root.left != null)
            dfs(root.left, sum);
        if (root.right != null)
            dfs(root.right, sum);
    }
    /*时间复杂度o(n)，空间复杂度o(1)*/
}
