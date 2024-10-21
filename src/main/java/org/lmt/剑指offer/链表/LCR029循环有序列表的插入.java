package org.lmt.剑指offer.链表;

import org.lmt.剑指offer.utils.ListNode;

/**
 * <p>Title: LCR029循环有序列表的插入 </p >
 * <p>Description: LCR029循环有序列表的插入 </p >
 * Package: org.example.剑指offer.链表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/11 15:39
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR029循环有序列表的插入 {
    public static void main(String[] args) {
        LCR029循环有序列表的插入 a = new LCR029循环有序列表的插入();
        ListNode p3 = new ListNode(3, null);
        ListNode p2 = new ListNode(3, p3);
        ListNode p1 = new ListNode(3, p2);
        p3.next = p1;
        a.insert(p1, 2);
    }

    /*双指针，找到一个比插入数大另一个比插入数小就找到了它的位置，如果指针经过同一个地方两次，代表环内所有节点都比插入数大或者小，只需要在最大点后面插入该数即可*/
    public ListNode insert(ListNode head, int insertVal) {
        ListNode temp = null;
        /*如果传入链表为空就建立一个包含一个节点的循环链表*/
        if (head == null) {
            temp = new ListNode(insertVal, null);
            temp.next = temp;
            return temp;
        }
        /*当链表只有一个节点，直接插入*/
        if (head.next == head) {
            temp = new ListNode(insertVal, head);
            head.next = temp;
            return head;
        }
        /*建立双指针*/
        ListNode pre = head;
        ListNode p = head.next;
        /*标志是否找到位置*/
        boolean flag = false;
        ListNode maxListNode = p;
        do {
            /*用于记录最大节点的位置*/
            if (p.val >= maxListNode.val)
                maxListNode = p;
            /*找到前一个比插入数大，后一个比插入数小的位置*/
            if (pre.val <= insertVal && p.val >= insertVal) {
                temp = new ListNode(insertVal, p);
                pre.next = temp;
                flag = true;
                break;
            }
            pre = p;
            p = p.next;
        }
        while (p != head.next);
        /*没有找到代表环内所有数均被插入数大或者小*/
        if (!flag) {
            /*插入数到最大数的后面*/
            temp = new ListNode(insertVal, maxListNode.next);
            maxListNode.next = temp;
        }
        return head;
    }
}
