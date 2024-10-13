package org.example.剑指offer.树;

import org.example.剑指offer.utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <p>Title: LCR056两数之和4输入二叉搜索树 </p >
 * <p>Description: LCR056两数之和4输入二叉搜索树 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 17:00
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR056两数之和4输入二叉搜索树 {
    boolean flag = false;

    public static void main(String[] args) {
        TreeNode p7 = new TreeNode(11, null, null);
        TreeNode p6 = new TreeNode(9, null, null);
        TreeNode p5 = new TreeNode(7, null, null);
        TreeNode p4 = new TreeNode(5, null, null);
        TreeNode p3 = new TreeNode(10, p6, p7);
        TreeNode p2 = new TreeNode(6, p4, p5);
        TreeNode p1 = new TreeNode(8, p2, p3);
        LCR056两数之和4输入二叉搜索树 a = new LCR056两数之和4输入二叉搜索树();
        System.out.println(a.findTarget(p1, 12));
    }

    /*hashset存放元素*/
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        dfs(root, k, set);
        return flag;
    }

    public void dfs(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null)
            return;
        dfs(root.left, k, set);
        /*如果set中存在k-该元素，就找到了一对答案*/
        if (set.contains(k - root.val))
            flag = true;
        set.add(root.val);
        dfs(root.right, k, set);
    }
}
