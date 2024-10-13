package org.example.剑指offer.排序;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Title: LCR059数据流中的第k大个元素 </p >
 * <p>Description: LCR059数据流中的第k大个元素 </p >
 * Package: org.example.剑指offer.堆
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/13 19:52
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR059数据流中的第k大个元素 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

}

class KthLargest {

    List<Integer> list;
    int k;

    public KthLargest(int k, int[] nums) {
        /*数据流是动态的，所以建立动态数组*/
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        this.k = k;
    }

    public int add(int val) {
        /*增加该值*/
        list.add(val);
        /*从小到大快排*/
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        /*取第k个元素*/
        return list.get(k - 1);
    }
}
