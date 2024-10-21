package org.lmt.剑指offer.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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

/*hashmap+动态数组*/
class RandomizedSet {
    /*hashmap<值，值在动态数组中的位置>*/
    public HashMap<Integer, Integer> hashMap;
    public ArrayList<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        hashMap = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (hashMap.containsKey(val))
            return false;
        hashMap.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!hashMap.containsKey(val))
            return false;
        /*将最数组最后一个元素替换到当前要删除的这个元素的位置，然后删除数组的最后一个元素，这样在删除数组中的某个元素时就不需要移动其他元素的位置*/
        hashMap.put(list.get(list.size() - 1), hashMap.get(val));
        list.set(hashMap.get(val), list.get(list.size() - 1));
        list.remove(list.size() - 1);
        hashMap.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        /*生成0到数组长度的随机数*/
        return list.get(new Random().nextInt(list.size()));
    }
}
