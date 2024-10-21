package org.lmt.剑指offer.哈希表;

import java.util.HashMap;

/**
 * <p>Title: LCR031LRU缓存 </p >
 * <p>Description: LCR031LRU缓存 </p >
 * Package: org.example.剑指offer.哈希表
 * Copyright: Copyright(c) LMT
 * Date: 2024/10/11 18:34
 *
 * @author LiMengTing
 * @version 1.0.0
 */
public class LCR031LRU缓存 {
    public static void main(String[] args) {
/*        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4*/
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }
}


class LRUCache {
    doubleListNode node;
    HashMap<Integer, doubleListNode> map;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        doubleListNode temp = map.get(key);
        int value = temp.value;
        moveNodeToTail(temp);
        return value;
    }

    public void put(int key, int value) {
        if (map.isEmpty()) {
            doubleListNode n = new doubleListNode(key, value, null, null);
            n.prev = n;
            n.next = n;
            map.put(key, n);
            node = n;
            return;
        }
        if (map.size() == capacity) {
            if (map.containsKey(key)) {
                doubleListNode temp = map.get(key);
                temp.value = value;
                moveNodeToTail(temp);
            } else {
                doubleListNode newNode = new doubleListNode(key, value, node.prev, node);
                insertTailNode(newNode);
                map.remove(node.key);
                map.put(key, newNode);
                deleteHeadNode();
            }
        } else {
            if (map.containsKey(key)) {
                doubleListNode temp = map.get(key);
                temp.value = value;
                moveNodeToTail(temp);
            } else {
                doubleListNode newNode = new doubleListNode(key, value, node.prev, node);
                insertTailNode(newNode);
                map.put(key, newNode);
            }
        }


    }

    public void deleteHeadNode() {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = node.next;
    }

    public void insertTailNode(doubleListNode listNode) {
        node.prev.next = listNode;
        node.prev = listNode;
    }

    public void moveNodeToTail(doubleListNode listNode) {
        if (listNode == node)
            node = node.next;
        listNode.prev.next = listNode.next;
        listNode.next.prev = listNode.prev;
        insertTailNode(listNode);
        listNode.prev = node.prev;
        listNode.next = node;
    }
}

class doubleListNode {
    int key;
    int value;
    doubleListNode prev;
    doubleListNode next;

    public doubleListNode(int key, int val, doubleListNode prev, doubleListNode next) {
        this.value = val;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}