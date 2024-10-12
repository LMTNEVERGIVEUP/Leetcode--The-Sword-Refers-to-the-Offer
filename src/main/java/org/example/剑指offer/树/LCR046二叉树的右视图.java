package org.example.剑指offer.树;

import org.example.剑指offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Title: LCR046二叉树的右视图 </p >
 * <p>Description: LCR046二叉树的右视图 </p >
 * Package: org.example.剑指offer.栈
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 15:20
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR046二叉树的右视图 {
    public static void main(String[] args) {
        TreeNode p5 = new TreeNode(4, null, null);
        TreeNode p4 = new TreeNode(5, null, null);
        TreeNode p3 = new TreeNode(3, null, p5);
        TreeNode p2 = new TreeNode(2, null, p4);
        TreeNode p1 = new TreeNode(1, p2, p3);
        LCR046二叉树的右视图 a = new LCR046二叉树的右视图();
        for (Integer i : a.rightSideView(p1)) {
            System.out.print(i + " ");
        }
    }

    /*相当于求每一行的最右边的结点，依然采用层序遍历*/
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode result = null;
            /*一层一层的遍历*/
            while (size > 0) {
                TreeNode node = queue.remove();
                /*此处不需要size==1，因为最后一次就是size==1直接可以覆盖前面的result*/
                result = node;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            list.add(result.val);
        }
        return list;
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
