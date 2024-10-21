package org.lmt.剑指offer.栈;

import java.util.Stack;

/**
 * <p>Title: LCR038每日温度 </p >
 * <p>Description: LCR038每日温度 </p >
 * Package: org.example.剑指offer.栈
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 10:39
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR038每日温度 {
    public static void main(String[] args) {
        LCR038每日温度 a = new LCR038每日温度();
        int[] dailyTemperatures = a.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int dailyTemperature : dailyTemperatures) {
            System.out.print(dailyTemperature + " ");
        }
    }

    /*利用单调非递增栈存储元素的下标*/
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            /*如果当前值比栈顶对应温度小，则插入*/
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                /*如果栈不为空且当前值比栈顶对应温度大，则依次栈中小于该值的元素，做差即可求出改天至少要等待到更高温度的天数*/
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        /*栈中还有的元素代表气温在这之后都不会升高*/
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
