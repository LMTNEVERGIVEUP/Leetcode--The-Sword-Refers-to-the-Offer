package org.lmt.剑指offer.链表;

import org.lmt.剑指offer.utils.ListNode;

/**
 * <p>Title: LCR027回文链表 </p >
 * <p>Description: LCR027回文链表 </p >
 * Package: org.example.剑指offer.链表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/11 13:56
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR027回文链表 {
    public static void main(String[] args) {
        LCR027回文链表 a = new LCR027回文链表();
        ListNode p6 = new ListNode(1, null);
        ListNode p5 = new ListNode(2, p6);
        ListNode p4 = new ListNode(3, p5);
        ListNode p3 = new ListNode(3, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(1, p2);
        System.out.println(a.isPalindrome(p1));
    }

    /*从中间一劈两半，翻转第二条链表进行一一对比*/
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode slow = head, fast = head;
        /*利用快慢指针寻找链表中点*/
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        /*劈成两半*/
        slow.next = null;
        /*翻转第二条链表*/
        mid = reverse(mid);
        ListNode start = head;
        /*开始一一对比*/
        while (mid != null) {
            /*有一个不一样就不是回文链表*/
            if (mid.val != start.val)
                return false;
            mid = mid.next;
            start = start.next;
        }
        return true;
    }

    /*反转链表*/
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
