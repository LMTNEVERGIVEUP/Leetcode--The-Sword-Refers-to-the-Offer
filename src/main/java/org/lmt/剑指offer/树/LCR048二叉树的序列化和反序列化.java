package org.lmt.剑指offer.树;

import org.lmt.剑指offer.utils.Tree;
import org.lmt.剑指offer.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR048二叉树的序列化和反序列化 </p >
 * <p>Description: LCR048二叉树的序列化和反序列化 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 16:17
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR048二叉树的序列化和反序列化 {
    public static void main(String[] args) {
        TreeNode p5 = new TreeNode(5, null, null);
        TreeNode p4 = new TreeNode(4, null, null);
        TreeNode p3 = new TreeNode(3, p4, p5);
        TreeNode p2 = new TreeNode(2, null, null);
        TreeNode p1 = new TreeNode(1, p2, p3);
        Codec codec = new Codec();
        System.out.println("序列化之前：");
        Tree.level_print(p1);
        System.out.println("----------------------------");
        System.out.println("序列化之后：");
        System.out.println(codec.serialize(p1));
        System.out.println("----------------------------");
        System.out.println("反序列化之后：");
        Tree.level_print(p1);
    }

}

class Codec {
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode deserialize(String data) {
        /*将字符串按逗号分割成数组*/
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root, String str) {
        /*如果当前节点为空加入"None,"表示空节点*/
        if (root == null) {
            str += "None,";
        } else {
            /*处理当前节点，加入节点值，并递归处理左右子树*/
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        /*返回最终序列化字符串*/
        return str;
    }

    public TreeNode rdeserialize(List<String> dataList) {
        /*如果当前数据为 "None"，表示此节点为空*/
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        /*移除已处理的元素*/
        dataList.remove(0);
        /*递归反序列化左子树*/
        root.left = rdeserialize(dataList);
        /*递归反序列化右子树*/
        root.right = rdeserialize(dataList);

        return root;
    }

}