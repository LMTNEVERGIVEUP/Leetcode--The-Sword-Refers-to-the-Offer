package org.example.剑指offer.链表;

import org.example.剑指offer.utils.ListNode;

/**
 * <p>Title: LCR025两数相加2 </p >
 * <p>Description: LCR025两数相加2 </p >
 * Package: org.example.剑指offer.链表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/10 20:08
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR025两数相加2 {
    public static void main(String[] args) {
        LCR025两数相加2 a = new LCR025两数相加2();
        ListNode p24 = new ListNode(3, null);
        ListNode p23 = new ListNode(4, p24);
        ListNode p22 = new ListNode(2, p23);
        ListNode p21 = new ListNode(7, p22);

        ListNode p13 = new ListNode(4, null);
        ListNode p12 = new ListNode(6, p13);
        ListNode p11 = new ListNode(5, p12);
        ListNode head = a.addTwoNumbers(p11, p21);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //TODO

        return l1;
    }
}
