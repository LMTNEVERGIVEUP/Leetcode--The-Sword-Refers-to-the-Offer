package org.lmt.acm模式;

import org.lmt.剑指offer.utils.Tree;
import org.lmt.剑指offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * <p>Title: 层次建二叉树</p>
 * <p>Description: 层次建二叉树</p>
 * Package: org.lmt.acm模式
 * Copyright: Copyright(c) LMT
 * Date: 2025/3/1 20:32
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class 层次建二叉树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*1,2,null,null,3,4*/
        String s = sc.next();
        String[] split = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]), null, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        /*index用于标识结点序号*/
        int index = 1;
        while (index < split.length && !queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (!split[index].equals("null")) {
                temp.left = new TreeNode(Integer.parseInt(split[index]), null, null);
                queue.add(temp.left);
            }
            index++;
            if (index < split.length && !split[index].equals("null")) {
                temp.right = new TreeNode(Integer.parseInt(split[index]), null, null);
                queue.add(temp.right);
            }
            index++;
        }
        Tree.level_print(root);
    }

}