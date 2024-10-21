package org.lmt.剑指offer.树;

import org.lmt.剑指offer.utils.TreeNode;

import java.util.Stack;

/**
 * <p>Title: LCR055二叉搜索树迭代器 </p >
 * <p>Description: LCR055二叉搜索树迭代器 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 14:30
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR055二叉搜索树迭代器 {
    public static void main(String[] args) {
        TreeNode p5 = new TreeNode(20, null, null);
        TreeNode p4 = new TreeNode(9, null, null);
        TreeNode p3 = new TreeNode(15, p4, p5);
        TreeNode p2 = new TreeNode(3, null, null);
        TreeNode p1 = new TreeNode(7, p2, p3);
        BSTIterator bSTIterator = new BSTIterator(p1);
        System.out.println(bSTIterator.next());    // 返回 3
        System.out.println(bSTIterator.next());    // 返回 7
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 9
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 15
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 20
        System.out.println(bSTIterator.hasNext()); // 返回 False
    }

}

class BSTIterator {

    TreeNode head;
    Stack<TreeNode> stack;


    public BSTIterator(TreeNode root) {
        head = root;
        stack = new Stack<>();
    }

    public int next() {
        while (head != null) {
            stack.push(head);
            head = head.left;
        }
        head = stack.pop();
        int value = head.val;
        head = head.right;
        return value;
    }


    public boolean hasNext() {
        return head != null || !stack.isEmpty();

    }
}

