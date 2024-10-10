package org.example.剑指offer.链表;

import org.example.剑指offer.utils.ListNode;

/**
 * <p>Title: LCR023相交链表 </p >
 * <p>Description: LCR023相交链表 </p >
 * Package: org.example.剑指offer.链表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/10 17:03
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR023相交链表 {
    public static void main(String[] args) {
        LCR023相交链表 a = new LCR023相交链表();
        ListNode p15 = new ListNode(5, null);
        ListNode p14 = new ListNode(4, p15);
        ListNode p13 = new ListNode(8, p14);
        ListNode p12 = new ListNode(1, p13);
        ListNode p11 = new ListNode(4, p12);
        ListNode p26 = new ListNode(5, null);
        ListNode p23 = new ListNode(1, p13);
        ListNode p22 = new ListNode(0, p23);
        ListNode p21 = new ListNode(5, p22);
        System.out.println(a.getIntersectionNode(p11, p21).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int length = 0;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null) {
            while (p2 != null) {
                p2 = p2.next;
                length++;
            }
            while (length > 0) {
                p2 = headB.next;
                length--;
            }
            p1 = headA;
        }
        if (p2 == null) {
            while (p1 != null) {
                p1 = p1.next;
                length++;
            }
            while (length > 0) {
                p1 = headA.next;
                length--;
            }
            p2 = headB;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }
}
