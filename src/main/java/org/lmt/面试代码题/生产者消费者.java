package org.lmt.面试代码题;

import java.util.concurrent.Semaphore;

/**
 * <p>Title: 生产者消费者</p>
 * <p>Description: 生产者消费者</p>
 * Package: org.lmt.面试代码题
 * Copyright: Copyright(c) LMT
 * Date: 2025/2/15 22:52
 *
 * @author LiMengTing
 * @version 1.0.0
 */
/*设计代码实现生产者消费者，假设最多放10个物品*/
public class 生产者消费者 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Producer producer = new Producer(solution);
        Producer producer1 = new Producer(solution);
        Consumer consumer = new Consumer(solution);
        Consumer consumer1 = new Consumer(solution);
        new Thread(producer::produce).start();
        new Thread(consumer::consume).start();
        new Thread(producer1::produce).start();
        new Thread(consumer1::consume).start();
    }
}

class Solution {
    /*互斥信号量*/
    Semaphore flag;
    /*表示离全空还差full个*/
    Semaphore full;
    /*表示离满了还差empty个*/
    Semaphore empty;

    public void setCount(int count) {
        this.count = count;
    }

    volatile int count;

    public Semaphore getEmpty() {
        return empty;
    }

    public Semaphore getFull() {
        return full;
    }

    public Semaphore getFlag() {
        return flag;
    }

    public int getCount() {
        return count;
    }

    public Solution() {
        flag = new Semaphore(1);
        full = new Semaphore(0);
        empty = new Semaphore(10);
        count = 0;
    }
}

class Producer {
    Solution solution;

    public Producer(Solution solution) {
        this.solution = solution;
    }

    public void produce() {

        while (true) {
            try {
                /*先保证至少有一个空位*/
                solution.empty.acquire();
                /*获得互斥锁*/
                solution.getFlag().acquire();
                System.out.println(Thread.currentThread().getName() + "生产者获取flag");
                solution.setCount(solution.getCount() + 1);
                System.out.println(Thread.currentThread().getName() + "生产者：当前数量" + solution.getCount());
                System.out.println(Thread.currentThread().getName() + "生产者释放full");
                /*生产了一个，那么离满就还差更少了一个*/
                solution.getFull().release();
                System.out.println(Thread.currentThread().getName() + "生产者释放flag");
                /*释放互斥锁*/
                solution.getFlag().release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer {
    Solution solution;

    public Consumer(Solution solution) {
        this.solution = solution;
    }

    public void consume() {
        while (true) {
            try {
                /*先保证至少有一个可以消费*/
                solution.full.acquire();
                /*获得互斥锁*/
                solution.getFlag().acquire();
                System.out.println(Thread.currentThread().getName() + "消费者获取flag");
                solution.setCount(solution.getCount() - 1);
                System.out.println(Thread.currentThread().getName() + "消费者：当前数量" + solution.getCount());
                System.out.println(Thread.currentThread().getName() + "消费者释放empty");
                /*消费了一个，代表距离空着有多了一个位置*/
                solution.getEmpty().release();
                System.out.println(Thread.currentThread().getName() + "消费者释放flag");
                /*释放互斥锁*/
                solution.getFlag().release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}