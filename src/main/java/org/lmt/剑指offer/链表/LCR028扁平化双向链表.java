package org.lmt.剑指offer.链表;

import org.lmt.剑指offer.utils.Node;

import java.util.Stack;

/**
 * <p>Title: LCR028扁平化双向链表 </p >
 * <p>Description: LCR028扁平化双向链表 </p >
 * Package: org.example.剑指offer.链表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/11 14:18
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR028扁平化双向链表 {
    public static void main(String[] args) {
        Node p12 = new Node(null, null, null, 12);
        Node p11 = new Node(null, p12, null, 11);
        Node p10 = new Node(null, null, null, 10);
        Node p9 = new Node(null, null, null, 9);
        Node p8 = new Node(p11, p9, null, 8);
        Node p7 = new Node(null, p8, null, 7);
        Node p6 = new Node(null, null, null, 6);
        Node p5 = new Node(null, p6, null, 5);
        Node p4 = new Node(null, p5, null, 4);
        Node p3 = new Node(p7, p4, null, 3);
        Node p2 = new Node(null, p3, null, 2);
        Node p1 = new Node(null, p2, null, 1);
        p2.setPrev(p1);
        p3.setPrev(p2);
        p4.setPrev(p3);
        p5.setPrev(p4);
        p6.setPrev(p5);
        p10.setPrev(p9);
        p9.setPrev(p8);
        p8.setPrev(p7);
        p12.setPrev(p11);
        LCR028扁平化双向链表 a = new LCR028扁平化双向链表();
        a.flatten(p1);
    }

    public Node flatten(Node head) {
        Node k = head;
        Stack<Node> stack = new Stack<>();
        stack.push(k);
        while (!stack.isEmpty())
            while (k.child != null) {
                k = k.child;
            }
        return null;
    }
}
