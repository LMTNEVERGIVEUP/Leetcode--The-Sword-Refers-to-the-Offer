package org.example.剑指offer.红黑树;

/**
 * <p>Title: LCR030n时间复杂度插入删除和随机获取元素 </p >
 * <p>Description: LCR030n时间复杂度插入删除和随机获取元素 </p >
 * Package: org.example.剑指offer.链表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/11 17:13
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR030常数复杂度插入删除和随机获取元素 {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.remove(2));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
        System.out.println(set.remove(1));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
    }

}

class RandomizedSet {

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {

    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {

    }
}
