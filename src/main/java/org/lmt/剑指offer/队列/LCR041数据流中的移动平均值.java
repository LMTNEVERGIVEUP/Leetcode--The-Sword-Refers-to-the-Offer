package org.lmt.剑指offer.队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Title: 数据流中的移动平均值 </p >
 * <p>Description: 数据流中的移动平均值 </p >
 * Package: org.example.剑指offer.队列
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 13:41
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR041数据流中的移动平均值 {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1)); // 返回 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // 返回 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // 返回 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // 返回 6.0 = (10 + 3 + 5) / 3
    }
}

/*采用队列数据结构*/
class MovingAverage {
    Queue<Integer> queue;
    int capacity;
    double sum = 0;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.capacity = size;
    }

    public double next(int val) {
        /*如果已经达到总容量弹出队头元素，并修正sum值*/
        if (queue.size() == capacity) {
            sum = sum - queue.remove() + val;
            queue.offer(val);
        }
        /*否则直接插入元素并修正sum值*/
        else {
            queue.offer(val);
            sum = sum + val;
        }
        return sum / queue.size();
    }
}