package com.sgh.demo02;

import java.util.ArrayList;
import java.util.List;

public class GenericClass {
    public static void main(String[] args) {

//        List<String> stringList = new ArrayList<>();
//        stringList.add("php");
//        stringList.add("java");
//        stringList.add("ccc");
//        List<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        test03(stringList);
//        test03(integers);
//        test02();
//        test01();
    }

    private static void test03(List<?> objects) {
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
        }
    }

    private static void test02() {
        List<String> listStr = new ArrayList<>();
        List<Integer> listInt = new ArrayList<>();
        System.out.println(listStr.getClass() == listInt.getClass());//true
    }

    private static void test01() {
        Apple<String> apple1 = new Apple<>("苹果");
        System.out.println(apple1.getInfo());
        Apple<Integer> apple2 = new Apple<>(12);
        System.out.println(apple2.getInfo());
    }
}
class Apple<T> {
    private T info;
    public Apple() {}
    public Apple(T info) {
        this.info = info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public T getInfo() {
        return this.info;
    }
}
