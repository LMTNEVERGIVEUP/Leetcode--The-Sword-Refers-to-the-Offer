package org.example.剑指offer.链表;

import org.example.剑指offer.utils.ListNode;

/**
 * <p>Title: LCR022环形链表2 </p >
 * <p>Description: LCR022环形链表2 </p >
 * Package: org.example.剑指offer.链表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/10 15:29
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR022环形链表2 {


    public static void main(String[] args) {
        LCR022环形链表2 a = new LCR022环形链表2();
        ListNode p4 = new ListNode(-4, null);
        ListNode p3 = new ListNode(0, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(3, p2);
        p4.next = p2;
        ListNode head = a.detectCycle(p1);
        System.out.println(head.val);
    }

    /*令起始点到入口点长度为L1,入口点到相遇点为L2，相遇点到入口点为L3
    ，根据快指针速度是慢指针速度的两倍可以推出L3+K(环周长)=L1
    ，即从相遇点再走到入口点的距离与从起始点到入口点距离的差是环周长的整数倍*/
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        /*判断是否有环，慢指针一次走一步，快指针一次走两步*/
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            /*快慢指针相撞*/
            if (slow == fast) {
                /*一个指针指向头节点，一个指针原地不动，二者一起每次前进一步*/
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                /*相撞点就是入口点*/
                return slow;
            }
        }
        return null;
    }
    /*时间复杂度o(n)，空间复杂度o(1)*/

}

