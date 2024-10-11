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

    /*翻转两条链表后依次相加链接到新链表上，要注意进位和相加多出一位的可能性*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*翻转链表*/
        ListNode p1 = reverse(l1);
        ListNode p2 = reverse(l2);
        ListNode p3 = null;
        /*标记进位符*/
        int count = 0;
        while (p1 != null && p2 != null) {
            int value = p1.val + p2.val;
            /*如果前一次存在进位则先加上*/
            value = count > 0 ? value + 1 : value;
            /*加上后的值大于等于10代表此个数位发生了进位，需要减去10并将进位符置1*/
            count = value >= 10 ? 1 : 0;
            value = value >= 10 ? value - 10 : value;
            /*创建新节点连接到新链表上*/
            p3 = new ListNode(value, p3);
            p1 = p1.next;
            p2 = p2.next;
        }
        /*如果第一条链表的长度大于第二条链表，则根据剩余链表的节点创建新节点依次连接到新链表上，要注意进位*/
        while (p1 != null) {
            int value = p1.val;
            value = count > 0 ? value + 1 : value;
            count = value >= 10 ? 1 : 0;
            value = value >= 10 ? value - 10 : value;
            p3 = new ListNode(value, p3);
            p1 = p1.next;
        }
        /*如果第二条链表的长度大于第一条链表，则根据剩余链表的节点创建新节点依次连接到新链表上，要注意进位*/
        while (p2 != null) {
            int value = p2.val;
            value = count > 0 ? value + 1 : value;
            count = value >= 10 ? 1 : 0;
            value = value >= 10 ? value - 10 : value;
            p3 = new ListNode(value, p3);
            p2 = p2.next;
        }
        /*如果链接完新链表后进位还是大于零，代表最后还多出一个进位，需要创建一个值为1新节点作为新链表的表头*/
        if (count > 0)
            p3 = new ListNode(1, p3);
        return p3;
    }

    /*时间复杂度o(n)，空间复杂度o(1)*/
    /*反转链表，返回反转后链表的头节点*/
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
