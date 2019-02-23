package com.darkness463.leetcode.hash;

import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 * 注意：
 *
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 *
 * https://leetcode-cn.com/problems/design-hashset/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class DesignHashset {

    class MyHashSet {

        private static final int MAX = 10000;
        LinkedList<Integer>[] items;

        /** Initialize your data structure here. */
        public MyHashSet() {
            items = new LinkedList[MAX];
        }

        public void add(int key) {
            int hash = hash(key);
            LinkedList<Integer> list = items[hash];
            if (list == null) {
                list = new LinkedList<>();
                list.add(key);
                items[hash] = list;
            } else {
                for (Integer i : list) {
                    if (i == key) {
                        return;
                    }
                }
                list.add(key);
            }
        }

        public void remove(int key) {
            int hash = hash(key);
            LinkedList<Integer> list = items[hash];
            if (list == null) {
                return;
            } else {
                list.remove(Integer.valueOf(key));
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int hash = hash(key);
            LinkedList<Integer> list = items[hash];
            if (list == null) {
                return false;
            } else {
                return list.contains(key);
            }
        }

        private int hash(int key) {
            return key % MAX;
        }
    }

}
