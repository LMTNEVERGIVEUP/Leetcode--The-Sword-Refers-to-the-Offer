package org.lmt.剑指offer.栈;

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

    /*单调栈（从栈顶到栈底单调递减） 核心在于求以某根柱子为顶的最大面积，可以转化为找到左边第一根小于该柱子的柱子，找到右边第一根小于该柱子的柱子，两根柱子之内就是最大面积的区域*/
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        /*需要在数组的首位加上0加上边界，为的是解决heights位单调数组的问题*/
        int[] p = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            p[i + 1] = heights[i];
        }
        int max = 0;
        for (int i = 0; i < p.length; i++) {
            /*栈为空或者栈顶元素小于等于数组元素，则入栈*/
            if (stack.isEmpty() || p[i] >= p[stack.peek()])
                stack.push(i);
            else {
                /*当遍历到的元素大于栈顶元素，则找到了大于栈顶元素的右方的第一根柱子，同时单调递减栈保证了栈顶的下一个元素为栈顶元素左方小于栈顶元素的第一根柱子。*/
                while (p[i] < p[stack.peek()] && stack.peek() != 0) {
                    int temp = stack.pop();
                    /*求以栈顶元素为顶的最大面积*/
                    max = Math.max(max, ((i - stack.peek() - 1) * p[temp]));
                }
                stack.push(i);
            }
        }
        return max;
    }
}
