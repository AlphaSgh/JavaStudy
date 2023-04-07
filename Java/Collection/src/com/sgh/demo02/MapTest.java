package com.sgh.demo02;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
    public static void main(String[] args) {
        //Map常用方法 clear() containsKey() containsValue() entrySet()返回Map中包含的key-value对所组成的Set集合
        //Map常用方法 get() isEmpty() keySet()返回Map中所有key组成的Set集合 put() putAll() remove() size()
        // values()返回Map中所有value组成的collection
        //Map包含一个内部类Entry，Entry包含getKey() getValue() setValue()方法
        //testMap();
        testTreeMap();
    }

    private static void testTreeMap() {
        var treeMap = new TreeMap<>();
        treeMap.put(new R(5), "java");
        treeMap.put(new R(-3), "php");
        treeMap.put(new R(10), "ccc");
        System.out.println(treeMap);
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.higherKey(new R(2)));
        System.out.println(treeMap.lowerKey(new R(2)));
        System.out.println(treeMap.subMap(new R(1), new R(9)));
    }

    private static void testMap() {
        Map map = new HashMap<>();
        map.put("java", 100);
        map.put("phpp", 10);
        map.put("ccaa", 190);
        map.put("cccc", 190);
        System.out.println(map.put("java", 111));//100
        System.out.println(map);//{java=100, phpp=10, ccaa=190, cccc=190}
        System.out.println(map.containsKey("java"));//true
        System.out.println(map.containsValue(99));//false
        for (var key : map.keySet()) {
            System.out.println(key + " --> " + map.get(key));
        }
    }
}
class R implements Comparable {
    public int count;
    public R(int count) {
        this.count = count;
    }
    public String toString() {
        return "R{count:" + count + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == R.class) {
            R r = (R) obj;
            return r.count == this.count;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        R r = (R) o;
        return count > r.count ? 1 : count < r.count ? -1 : 0;
    }
}
