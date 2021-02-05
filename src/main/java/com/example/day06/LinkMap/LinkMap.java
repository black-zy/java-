package com.example.day06.LinkMap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkMap {
    public static void main(String[] args) {
        LRULinkedHashMap<String, Integer> map = new LRULinkedHashMap<>(4);
        map.put("111", 111);
        map.put("222", 222);
        map.put("333", 333);
        map.put("444", 444);
        map.put("555", 555);
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
             Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
    }
}