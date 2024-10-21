package org.lmt.剑指offer.树;

import org.lmt.剑指offer.utils.TreeNode;

/**
 * <p>Title: LCR051二叉树中的最大路径和 </p >
 * <p>Description: LCR051二叉树中的最大路径和 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 11:39
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR051二叉树中的最大路径和 {
    int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode p3 = new TreeNode(3, null, null);
        TreeNode p2 = new TreeNode(2, null, null);
        TreeNode p1 = new TreeNode(1, p2, p3);
        LCR051二叉树中的最大路径和 a = new LCR051二叉树中的最大路径和();
        System.out.println(a.maxPathSum(p1));
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        /*如果当前节点为空，则路径增益为0*/
        if (node == null) {
            return 0;
        }
        /*递归计算左子树和右子树的最大增益，负增益时视为0（即不选该子树）*/
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        /*当前节点作为路径的起点，计算路径和*/
        int priceNewpath = node.val + leftGain + rightGain;
        /*更新全局最大路径和*/
        maxSum = Math.max(maxSum, priceNewpath);
        /*返回从当前节点向下选择一条路径的最大增益*/
        return node.val + Math.max(leftGain, rightGain);
    }


}
