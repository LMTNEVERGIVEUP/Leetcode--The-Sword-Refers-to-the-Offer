package org.lmt.剑指offer.utils;

/**
 * <p>Title: TreeNode </p >
 * <p>Description: TreeNode </p >
 * Package: org.example.剑指offer.utils
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 14:26
 *
 * @author LiMengTing
 * @version 1.0.0
 */
/*树*/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
