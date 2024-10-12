package org.example.剑指offer.栈;

import java.util.Stack;

/**
 * <p>Title: LCR038柱状图中最大矩形 </p >
 * <p>Description: LCR038柱状图中最大矩形 </p >
 * Package: org.example.剑指offer.栈
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 11:16
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR039柱状图中最大矩形 {
    public static void main(String[] args) {
        LCR039柱状图中最大矩形 a = new LCR039柱状图中最大矩形();
        System.out.println(a.largestRectangleArea(new int[]{1}));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] p = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            p[i + 1] = heights[i];
        }
        int max = 0;
        for (int i = 0; i < p.length; i++) {
            if (stack.isEmpty()||p[i] >= p[stack.peek()])
                stack.push(i);
            else {
                while (p[i] < p[stack.peek()] && stack.peek() != 0) {
                    stack.pop();
                    max = Math.max(max, ((i - stack.peek()) * p[stack.peek()]));
                }
                stack.push(i);
            }
        }
        //todo
        return max;
    }
}
