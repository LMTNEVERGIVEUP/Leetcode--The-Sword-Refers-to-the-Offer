package org.example.剑指offer.链表;

import org.example.剑指offer.utils.ListNode;

/**
 * <p>Title: LCR026重排链表 </p >
 * <p>Description: LCR026重排链表 </p >
 * Package: org.example.剑指offer.链表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/10 19:30
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR026重排链表 {
    public static void main(String[] args) {
        LCR026重排链表 a = new LCR026重排链表();
        ListNode p4 = new ListNode(4, null);
        ListNode p3 = new ListNode(3, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(1, p2);
        a.reorderList(p1);
        while (p1 != null) {
            System.out.println(p1.val);
            p1 = p1.next;
        }
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = reverse(slow.next);
        ListNode p = head;
        while (p != null && temp != null) {
            //TODO
            ListNode su = temp.next;
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
            temp = su;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
