package org.lmt.剑指offer.二分查找;

/**
 * <p>Title: LCR072 </p >
 * <p>Description: LCR072 </p >
 * Package: org.example.剑指offer.二分查找
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/15 10:25
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR072x的平方根 {
    public static void main(String[] args) {
        LCR072x的平方根 A = new LCR072x的平方根();
        System.out.println(A.mySqrt(1));
    }

    /*二分查找*/
    public int mySqrt(int x) {
        /*如果x为0返回0*/
        if (x == 0) {
            return 0;
        } else {
            long low = 1;
            long high = x;
            while (low <= high) {
                long mid = (low + high) / 2;
                /*中间数的平方大于x，代表要往左找*/
                if (mid * mid > x)
                    high = mid - 1;
                /*中间数的平方小于x，代表要往右找*/
                if (mid * mid < x)
                    low = mid + 1;
                /*中间数的平方等于x，代表找到了*/
                if (mid * mid == x)
                    return (int) mid;
            }
            /*代表x的平方根不是整数，返回high*/
            return (int) high;
        }
    }
    /*时间复杂度o(logn)，空间复杂度o(1)*/
}
