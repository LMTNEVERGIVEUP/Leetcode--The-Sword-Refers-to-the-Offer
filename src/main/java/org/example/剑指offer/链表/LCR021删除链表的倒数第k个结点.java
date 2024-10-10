package org.example.剑指offer.链表;

import org.example.剑指offer.utils.ListNode;

/**
 * <p>Title: LCR021删除链表的倒数第k个结点 </p >
 * <p>Description: LCR021删除链表的倒数第k个结点 </p >
 * Package: org.example.剑指offer
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/10 14:29
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR021删除链表的倒数第k个结点 {
    public static void main(String[] args) {
        LCR021删除链表的倒数第k个结点 a = new LCR021删除链表的倒数第k个结点();
        ListNode p2 = new ListNode(2, null);
        ListNode p1 = new ListNode(1, p2);
        ListNode head = a.removeNthFromEnd(p1, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /*递归*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*数组第一个位置的元素用于记录倒数第几个节点数，第二个位置记录链表的长度*/
        int[] p = new int[]{n, 0};
        recurse(head, p);
        /*如果链表长度等于要删除的节点，那么返回首节点的下一个节点*/
        if (p[1] == n)
            return head.next;
        return head;
    }

    /*递归具体函数内容*/
    public void recurse(ListNode head, int[] p) {
        if (head == null)
            return;
        recurse(head.next, p);
        p[0]--;
        /*当回溯到要删除的节点*/
        if (p[0] == -1)
            head.next = head.next.next;
        /*链表长度加1*/
        p[1]++;
    }
}

