package org.lmt.剑指offer.链表;

import org.lmt.剑指offer.utils.ListNode;

/**
 * <p>Title: LCR024翻转链表 </p >
 * <p>Description: LCR024翻转链表 </p >
 * Package: org.example.剑指offer.链表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/10 19:22
 *
 * @author LiMengTing
 * @version 1.0.0
 */

public class LCR024翻转链表 {

    public static void main(String[] args) {
        ListNode p5 = new ListNode(5, null);
        ListNode p4 = new ListNode(4, p5);
        ListNode p3 = new ListNode(3, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(1, p2);
        LCR024翻转链表 a = new LCR024翻转链表();
        ListNode listNode = a.reverseList(p1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /*递归链表*/
    public ListNode reverseList(ListNode head) {
        /*如果是空链表或者链表遍历到最后一个节点就返回最后一个节点的地址*/
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        /*翻转*/
        head.next.next = head;
        head.next = null;
        return p;
    }
}