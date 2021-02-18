package com.example.day07.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 算法
 * LRU算法的设计原则是：如果一个数据在最近一段时间没有被访问到，那么在将来它被访问的可能性也很小。也就是说，当限定的空间已存满数据时，应当把最久没有被访问到的数据淘汰。
 *
 * 用linkedHashMap
 */
public class LRUDemo<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    public LRUDemo(int capacity){
        /** accessOrder
         * true  是访问顺序
         * false  是插入顺序
         */
        super(capacity,0.75F,false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUDemo lruDemo = new LRUDemo(3);
        lruDemo.put(1,"a");
        lruDemo.put(2,"b");
        lruDemo.put(3,"c");
        System.out.println(lruDemo.keySet());
        lruDemo.put(4,"d");
        System.out.println(lruDemo.keySet());
        lruDemo.put(3,"c");
        System.out.println(lruDemo.keySet());
        lruDemo.put(3,"c");
        System.out.println(lruDemo.keySet());
        lruDemo.put(3,"c");
        System.out.println(lruDemo.keySet());
        lruDemo.put(5,"x");
        System.out.println(lruDemo.keySet());
    }

    /**true  访问顺序  结果
     * [1, 2, 3]
     * [2, 3, 4]
     * [2, 4, 3]
     * [2, 4, 3]
     * [2, 4, 3]
     * [4, 3, 5]
     */

    /**false  插入顺序
     * [1, 2, 3]
     * [2, 3, 4]
     * [2, 3, 4]
     * [2, 3, 4]
     * [2, 3, 4]
     * [3, 4, 5]
     */
}
