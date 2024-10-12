package org.example.剑指offer.栈;

import java.util.Stack;

/**
 * <p>Title: LCR037行星碰撞 </p >
 * <p>Description: LCR037行星碰撞 </p >
 * Package: org.example.剑指offer.栈
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 09:55
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR037行星碰撞 {
    public static void main(String[] args) {
        LCR037行星碰撞 a = new LCR037行星碰撞();
        int[] p = a.asteroidCollision(new int[]{5, 10, -5});
        for (int i : p) {
            System.out.print(i + " ");
        }
    }

    /*使用栈存储每个行星的质量*/
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            /*代表需要这个行星存活*/
            boolean flag = true;
            /*栈不为空且栈顶元素和数组元素异号*/
            while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0) {
                /*栈顶元素的绝对值小于数组元素的绝对值，弹出栈顶元素，代表栈顶元素被摧毁*/
                if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
                    stack.pop();
                    /*栈顶元素绝对值等于数组元素，弹出栈顶元素同时跳出循环，代表数组元素和栈顶元素同时死亡*/
                } else if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                    stack.pop();
                    flag = false;
                    break;
                    /*栈顶元素的绝对值小于数组元素，数组元素死亡，跳出循环*/
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag)
                stack.push(asteroids[i]);
        }
        /*建立存活行星数组*/
        int[] result = new int[stack.size()];
        while (!stack.isEmpty()) {
            result[stack.size() - 1] = stack.pop();
        }
        return result;
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
