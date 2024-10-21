package org.lmt.剑指offer.链表;

import org.lmt.剑指offer.utils.ListNode;

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

    /*从中间将链表一分为二，翻转第二条链表，而后合并到第一条当中去*/
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        /*设置快慢指针，慢指针一次走一步，快指针一次走两步，当快指针走到表的尽头，慢指针刚好就是链表的中心位置*/
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /*将链表沿中心位置一分为二并翻转第二条链表*/
        ListNode p2 = reverse(slow.next);
        slow.next = null;
        ListNode p1 = head;
        /*双指针指向两条链表*/
        while (p2 != null) {
            /*记录每个指针的下一个节点位置*/
            ListNode p1_su = p1.next;
            ListNode p2_su = p2.next;
            /*合并链表到第一条链表当中*/
            p1.next = p2;
            p2.next = p1_su;
            p1 = p2.next;
            p2 = p2_su;
        }
        /*时间复杂度o(n)，空间复杂度o(1)*/
    }

    /*反转链表*/
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
