package org.example.剑指offer.队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * <p>Title: LCR042最近的请求次数 </p >
 * <p>Description: LCR042最近的请求次数 </p >
 * Package: org.example.剑指offer.队列
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 13:50
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR042最近的请求次数 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(recentCounter.ping(100));   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }


}

/*采用队列*/
class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        /*先插入元素*/
        queue.offer(t);
        /*从队列中删除所有与当前值插值大于3000的节点*/
        while (t - queue.peek() > 3000)
            queue.remove();
        /*队列长度就是次数*/
        return queue.size();
    }
}