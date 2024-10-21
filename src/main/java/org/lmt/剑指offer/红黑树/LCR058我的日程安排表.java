package org.lmt.剑指offer.红黑树;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: LCR058我的日程安排表 </p >
 * <p>Description: LCR058我的日程安排表 </p >
 * Package: org.example.剑指offer.树
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 17:41
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR058我的日程安排表 {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(15, 25)); // returns false ，第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了
        System.out.println(myCalendar.book(20, 30)); // returns true ，第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20
    }

}

class MyCalendar {
    List<int[]> booked;

    public MyCalendar() {
        booked = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}