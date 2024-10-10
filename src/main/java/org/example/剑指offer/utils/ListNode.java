package org.example.剑指offer.utils;

/**
 * <p>Title: ListNode </p >
 * <p>Description: ListNode </p >
 * Package: org.example.剑指offer.utils
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/10 15:58
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}