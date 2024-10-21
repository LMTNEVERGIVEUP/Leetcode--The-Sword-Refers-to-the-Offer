package org.lmt.剑指offer.utils;

/**
 * <p>Title: Node </p >
 * <p>Description: Node </p >
 * Package: org.example.剑指offer.utils
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/11 14:19
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(Node child, Node next, Node prev, int val) {
        this.child = child;
        this.next = next;
        this.prev = prev;
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
};
