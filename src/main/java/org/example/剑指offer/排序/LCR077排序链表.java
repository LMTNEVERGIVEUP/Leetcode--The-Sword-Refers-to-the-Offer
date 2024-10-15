package org.example.剑指offer.排序;

import org.example.剑指offer.utils.ListNode;

/**
 * <p>Title: LCR076排序链表 </p >
 * <p>Description: LCR076排序链表 </p >
 * Package: org.example.剑指offer.排序
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 14:14
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR077排序链表 {
    public static void main(String[] args) {
        ListNode p3 = new ListNode(3, null);
        ListNode p2 = new ListNode(1, p3);
        ListNode p1 = new ListNode(2, p2);
        ListNode p0 = new ListNode(4, p1);
        LCR077排序链表 a = new LCR077排序链表();
        ListNode s = a.sortList(p0);
        while (s != null) {
            System.out.print(s.val + " ");
            s = s.next;
        }
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    /*归并排序*/
    public ListNode sortList(ListNode head, ListNode tail) {
        /*如果head为空，返回空*/
        if (head == null) {
            return head;
        }
        /*如果只有一个元素，直接返回*/
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        /*获得链表中点*/
        ListNode mid = getMid(head, tail);
        /*获得第一条链表*/
        ListNode a = sortList(head, mid);
        /*获得第二条链表*/
        ListNode b = sortList(mid, tail);
        /*合并a节点到b节点链表*/
        return merge(a, b);
    }

    /*合并链表*/
    public ListNode merge(ListNode head, ListNode mid) {
        /*双指针合并链表*/
        ListNode p3 = null, p2 = head, p1 = mid;
        while (p1 != null && p2 != null) {
            /*哪个小就放哪个到新链表中*/
            if (p1.val <= p2.val) {
                p3 = new ListNode(p1.val, p3);
                p1 = p1.next;
            } else {
                p3 = new ListNode(p2.val, p3);
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            p3 = new ListNode(p1.val, p3);
            p1 = p1.next;
        }
        while (p2 != null) {
            p3 = new ListNode(p2.val, p3);
            p2 = p2.next;
        }
        /*因为是反向链接，所以合并完需要翻转链表*/
        return reverse(p3);
    }


    /*找到以head为首，tail为尾的链表中点*/
    public ListNode getMid(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        /*快慢指针寻找链表中点，当fast到头，slow就是中点（如果链表长度是偶数，就是靠右的那个节点）*/
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*递归反转链表*/
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
