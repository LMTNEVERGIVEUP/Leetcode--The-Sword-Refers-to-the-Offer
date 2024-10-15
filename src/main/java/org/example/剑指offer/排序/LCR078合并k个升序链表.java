package org.example.剑指offer.排序;

import org.example.剑指offer.utils.ListNode;

/**
 * <p>Title: LCR078合并k个升序链表 </p >
 * <p>Description: LCR078合并k个升序链表 </p >
 * Package: org.example.剑指offer.排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 15:41
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR078合并k个升序链表 {
    public static void main(String[] args) {
        LCR078合并k个升序链表 a = new LCR078合并k个升序链表();
        ListNode p13 = new ListNode(5, null);
        ListNode p12 = new ListNode(4, p13);
        ListNode p11 = new ListNode(1, p12);
        ListNode p23 = new ListNode(4, null);
        ListNode p22 = new ListNode(3, p23);
        ListNode p21 = new ListNode(1, p22);
        ListNode p32 = new ListNode(6, null);
        ListNode p31 = new ListNode(2, p32);
        ListNode[] lists = {p11, p21, p31};
        ListNode start = a.mergeKLists(lists);
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        /*两两合并链表*/
        for (int i = 0; i < lists.length - 1; i++) {
            /*如果二者有一个为空，始终让后一个保存合并后的结果*/
            if (lists[i] == null || lists[i + 1] == null)
                /*如果有一个为空，直接让后一个保存不为空的那一条链表*/
                lists[i + 1] = (lists[i] != null ? lists[i] : lists[i + 1]);
                /*否则两两合并*/
            else
                lists[i + 1] = merge(lists[i], lists[i + 1]);
        }
        return lists[lists.length - 1];
    }

    /*合并链表*/
    public ListNode merge(ListNode l1, ListNode l2) {
        /*设置一个空的头节点*/
        ListNode head = new ListNode();
        /*temp代表已经排好序链表的最后一个结点*/
        ListNode temp;
        temp = head;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            /*如果p1的结点的值小于等于p2的值，链接该结点，p1向后移动一次*/
            if (p1.val <= p2.val) {
                temp.next = p1;
                p1 = p1.next;
            }
            /*反之同理*/
            else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        /*链接剩余的部分*/
        if (p1 != null) {
            temp.next = p1;
        }
        if (p2 != null) {
            temp.next = p2;
        }
        return head.next;
    }
    /*时间复杂度o(n)，空间复杂度o(1)*/

}
