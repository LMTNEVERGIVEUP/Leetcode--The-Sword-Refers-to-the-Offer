package org.lmt.剑指offer.栈;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: LCR035最小时间差 </p >
 * <p>Description: LCR035最小时间差 </p >
 * Package: org.example.剑指offer.栈
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 09:01
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR035最小时间差 {
    public static void main(String[] args) {
        LCR035最小时间差 a = new LCR035最小时间差();
        LinkedList<String> list = new LinkedList<>();
        list.add("23:59");
        list.add("00:00");
        System.out.println(a.findMinDifference(list));
    }

    /*先转化成分钟，然后排序，两两求差，注意还需要将第一个时刻+一天的时间和最后一个时刻作比较*/
    public int findMinDifference(List<String> timePoints) {
        int[] p = new int[timePoints.size()];
        /*全部转化为分钟*/
        for (int i = 0; i < timePoints.size(); i++) {
            String[] split = timePoints.get(i).split(":");
            p[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        /*排序*/
        Arrays.sort(p);
        int length = 20001;
        /*两两比较，计算最小值*/
        for (int i = 0; i < p.length - 1; i++) {
            length = Math.min(Math.abs(p[i] - p[i + 1]), length);
        }
        /*需要将第一个时刻+一天的时间和最后一个时刻作比较，为的是计算第一天的最晚时刻和第二天的最早时刻之间的差*/
        length = Math.min(p[0] + 24 * 60 - p[p.length - 1], length);
        return length;
    }
    /*时间复杂度o(nlogn)，空间复杂度o(1)*/
}
