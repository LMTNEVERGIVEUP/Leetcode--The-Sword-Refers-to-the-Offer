package org.example.剑指offer.栈;

import java.util.Stack;

/**
 * <p>Title: LCR036 </p >
 * <p>Description: LCR036 </p >
 * Package: org.example.剑指offer.栈
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/12 09:24
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR036逆波兰表达式求值 {
    public static void main(String[] args) {
        LCR036逆波兰表达式求值 a = new LCR036逆波兰表达式求值();
        System.out.println(a.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*"
                , "/", "*", "17", "+", "5", "+"}));
    }

    /*使用栈完成后缀表达式*/
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        stack.push(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            String temp = tokens[i];
            /*如果第一个符号不是加减乘除或者字符串长度大于1，则一定是数字直接放入栈*/
            if (temp.length() > 1 || temp.charAt(0) != '+' && temp.charAt(0) != '-' && temp.charAt(0) != '*' && temp.charAt(0) != '/')
                stack.push(temp);
                /*否则则是操作数，弹出两个栈顶元素然后做运算再放回栈中*/
            else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int value = switch (temp.charAt(0)) {
                    case '+' -> a + b;
                    case '-' -> b - a;
                    case '*' -> b * a;
                    case '/' -> b / a;
                    default -> 0;
                };
                stack.push(Integer.valueOf(value).toString());
            }

        }
        return Integer.parseInt(stack.pop());
    }
    /*时间复杂度o(n)，空间复杂度o(n)*/
}
