package org.lmt.剑指offer.树;

import org.lmt.剑指offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Title: LCR045找树左下角的值 </p >
 * <p>Description: LCR045找树左下角的值 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 15:07
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR045找树左下角的值 {
    public static void main(String[] args) {
        TreeNode p3 = new TreeNode(3, null, null);
        TreeNode p2 = new TreeNode(1, null, null);
        TreeNode p1 = new TreeNode(2, p2, p3);
        LCR045找树左下角的值 a = new LCR045找树左下角的值();
        System.out.println(a.findBottomLeftValue(p1));
    }

    /*采用层序遍历*/
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode result = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = true;
            /*一层一层处理，size代表上一层节点的节点个数*/
            while (size > 0) {
                TreeNode node = queue.remove();
                /*如果找到了第一个节点，就更新result，并禁止后续更新*/
                if (flag) {
                    result = node;
                    flag = false;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
        }
        return result.val;
    }
    /*时间复杂度o(n),空间复杂度o(n)*/
}
