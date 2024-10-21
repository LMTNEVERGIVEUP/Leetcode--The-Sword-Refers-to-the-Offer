package org.example.剑指offer.数组;

/**
 * <p>Title: LCR002二进制求和 </p >
 * <p>Description: LCR002二进制求和 </p >
 * Package: org.example.剑指offer.数组
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/21 11:21
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR002二进制求和 {
    public static void main(String[] args) {
        LCR002二进制求和 a = new LCR002二进制求和();
        System.out.println(a.addBinary("11", "10"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder re = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        /*carry表示进位,result表示每一位的加法结果*/
        int carry = 0;
        int result = 0;
        while (i >= 0 || j >= 0) {
            int digita = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitb = j >= 0 ? b.charAt(j--) - '0' : 0;
            /*计算当前位的加法结果，包含进位*/
            result = digitb + digita + carry;
            /*如果当前位的加法结果大于或等于2，则产生进位*/
            carry = result >= 2 ? 1 : 0;
            /*当前位的结果，如果大于等于2则减去2得到0或1*/
            result = result >= 2 ? result - 2 : result;
            re.append(result);
        }
        if (carry > 0)
            re.append(1);
        return re.reverse().toString();

    }
}
