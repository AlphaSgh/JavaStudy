package com.sgh.demo02;

import java.util.ArrayList;
import java.util.Collections;

public class TestCollections {
    public static void main(String[] args) {
        //Collections工具类排序操作：reverse()反转操作，shuffle()洗牌操作，sort()排序，swap()交换，rotate()整体前后移动
        //Collections查找替换操作：binarySearch() max() min() fill() frequency() indexOfSubList() lastIndexOfSubList() replaceAll()
        test02();
        //test01();
    }

    private static void test02() {
//        binarySearch() max() min() fill() frequency() indexOfSubList() lastIndexOfSubList() replaceAll()
        ArrayList nums = new ArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        System.out.println(Collections.binarySearch(nums, 3));
        System.out.println(Collections.max(nums));
        System.out.println(Collections.min(nums));
        Collections.fill(nums, 1);
        System.out.println(nums);
        System.out.println(Collections.frequency(nums, 1));
        Collections.replaceAll(nums, 1, 2);
        System.out.println(nums);

    }

    private static void test01() {
        ArrayList nums = new ArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        System.out.println(nums);
        Collections.reverse(nums);
        System.out.println(nums);
        Collections.shuffle(nums);
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);
        Collections.rotate(nums, 3);
        System.out.println(nums);
        Collections.swap(nums, 1, 3);
        System.out.println(nums);
    }
}
