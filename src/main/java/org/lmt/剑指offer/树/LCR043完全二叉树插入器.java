package org.lmt.剑指offer.树;

import org.lmt.剑指offer.utils.Tree;
import org.lmt.剑指offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Title: LCR043完全二叉树插入器 </p >
 * <p>Description: LCR043完全二叉树插入器 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 14:26
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR043完全二叉树插入器 {
    public static void main(String[] args) {
        CBTInserter cbtInserter = new CBTInserter(new TreeNode(1, null, null));
        System.out.println(cbtInserter.insert(2));
        System.out.println("------------------------");
        TreeNode root = cbtInserter.get_root();
        new Tree().pre_print(root);
    }

}

/*使用队列层序遍历即可*/
class CBTInserter {
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            /*左为空且右为空，插入左并返回*/
            if (node.left == null && node.right == null) {
                node.left = new TreeNode(v, null, null);
                return node.val;
            }
            /*左不为空右为空，插入右并返回*/
            if (node.left != null && node.right == null) {
                node.right = new TreeNode(v, null, null);
                return node.val;
            }
            /*否则层序遍历*/
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return 0;
    }

    public TreeNode get_root() {
        return root;
    }
}