package org.example.剑指offer.图;

import java.util.*;

/**
 * <p>Title: LCR109打开转盘锁 </p >
 * <p>Description: LCR109打开转盘锁 </p >
 * Package: org.example.剑指offer.图
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/20 13:20
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR109打开转盘锁 {
    public static void main(String[] args) {
        LCR109打开转盘锁 a = new LCR109打开转盘锁();
        System.out.println(a.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }

    public int openLock(String[] deadends, String target) {
        /*存放死锁状态*/
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000")) {
            return -1;
        }
        if ("0000".equals(target)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        /*存放已经产生的状态，从而避免重复遍历*/
        HashSet<String> status = new HashSet<>();
        status.add("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int len = queue.size();
            /*按层处理，确保路径最短*/
            while (len > 0) {
                String temp = queue.poll();
                List<String> spins = spin(temp);
                for (String spin : spins) {
                    /*如果不存在于状态集合而且不存在于死锁集合，代表这个状态还没有被遍历到而且可以进行遍历*/
                    if (!status.contains(spin) && !set.contains(spin)) {
                        /*加入队列之前判断如果这个状态就是想要的结果，就直接返回最短路径*/
                        if (spin.equals(target))
                            return count;
                        /*如果不等则加入到队列和集合中*/
                        queue.offer(spin);
                        status.add(spin);
                    }
                }
                len--;
            }
        }
        return -1;
    }

    /*用于获得旋转某个状态时锁的每一位从而产生的所有状态*/
    public List<String> spin(String a) {
        List<String> strings = new LinkedList<>();
        char[] charArray = a.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char temp = charArray[i];
            /*每一位都有加1和减1两种可能*/
            charArray[i] = charArray[i] == '0' ? '9' : (char) (charArray[i] - 1);
            strings.add(new String(charArray));
            charArray[i] = charArray[i] == '9' ? '0' : (char) (charArray[i] + 1);
            strings.add(new String(charArray));
            /*还原原来的值*/
            charArray[i] = temp;
        }
        return strings;
    }
    /*时间复杂度o(n),空间复杂度o(n)*/

}
