package org.lmt.面试代码题;

/**
 * <p>Title: 依次打印零到一百</p>
 * <p>Description: 依次打印零到一百</p>
 * Package: org.lmt.面试代码题
 * Copyright: Copyright(c) LMT
 * Date: 2025/2/15 21:42
 *
 * @author LiMengTing
 * @version 1.0.0
 */
/*编辑代码实现三个线程从零到一百依次按顺序打印*/
public class 依次打印零到一百 {
    /*volatile变量保证该变量变化时可被所有线程感知*/
    volatile int state = 0;

    /*根据state对3的取余判断由哪个方法打印*/
    public void A() {
        while (state < 100) {
            /*通过锁实现同步*/
            synchronized (this) {
                /*双重检查锁避免超出100*/
                if (state % 3 == 0 && state < 100) {
                    state++;
                    System.out.println(Thread.currentThread().getName() + "打印了" + state);
                }
            }

        }
    }

    public void B() {
        while (state < 100) {
            synchronized (this) {
                if (state % 3 == 1 && state < 100) {
                    state++;
                    System.out.println(Thread.currentThread().getName() + "打印了" + state);
                }
            }

        }
    }

    public void C() {
        while (state < 100) {
            synchronized (this) {
                if (state % 3 == 2 && state < 100) {
                    state++;
                    System.out.println(Thread.currentThread().getName() + "打印了" + state);
                }
            }
        }
    }

    public static void main(String[] args) {
        依次打印零到一百 依次打印零到一百 = new 依次打印零到一百();
        System.out.println(依次打印零到一百.state);
        new Thread(依次打印零到一百::A).start();
        new Thread(依次打印零到一百::B).start();
        new Thread(依次打印零到一百::C).start();
    }
}