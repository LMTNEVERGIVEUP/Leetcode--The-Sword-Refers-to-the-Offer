package org.example.剑指offer.树;

import org.example.剑指offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Title: LCR044在每个树行中找最大值 </p >
 * <p>Description: LCR044在每个树行中找最大值 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 14:49
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR044在每个树行中找最大值 {
    public static void main(String[] args) {
        TreeNode p6 = new TreeNode(9, null, null);
        TreeNode p5 = new TreeNode(3, null, null);
        TreeNode p4 = new TreeNode(5, null, null);
        TreeNode p3 = new TreeNode(2, null, p6);
        TreeNode p2 = new TreeNode(3, p4, p5);
        TreeNode p1 = new TreeNode(1, p2, p3);
        LCR044在每个树行中找最大值 a = new LCR044在每个树行中找最大值();
        List<Integer> list = a.largestValues(p1);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    /*层序遍历，一层层找最大值即可*/
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            int length = queue.size();
            int max = Integer.MIN_VALUE;
            /*当前队列长度即是上一层的节点个数*/
            while (length > 0) {
                TreeNode treeNode = queue.remove();
                /*求出上一层节点的最大值*/
                max = Math.max(max, treeNode.val);
                if (treeNode.left != null)
                    queue.offer(treeNode.left);
                if (treeNode.right != null)
                    queue.offer(treeNode.right);
                length--;
            }
            list.add(max);
        }
        return list;
    }

    /*时间复杂度o(n),空间复杂度o(n)*/
}
