package com.sgh.demo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Foo<T> {
    void test(T t);
}
public class ListErr {
    public static void main(String[] args) {
        test02();
//        test01();
    }

    private static void test02() {
        Foo<String> foo = new Foo<String>() {
            @Override
            public void test(String s) {
                System.out.println("test t = " + s);
            }
        };
        foo.test("sss");
        Foo<?> foo1 = new Foo<Object>() {
            @Override
            public void test(Object o) {
                System.out.println("test t = " + o);
            }
        };
        Foo<? extends Number> foo2 = new Foo<Number>() {
            @Override
            public void test(Number number) {
                System.out.println("test t = " + number);
            }
        };
    }

    private static void test01() {
        /*
        List strList = new ArrayList();//创建一个List，希望只保存String对象
        strList.add("java");
        strList.add("php");
        strList.add(4);//把Integer对象放入到List中
        strList.forEach(str -> System.out.println(((String) str).length()));//试图将Integer对象转化为String对象，发生异常
*/
/*
        List<String> stringList = new ArrayList<String>();
        stringList.add("java");
        stringList.add("php");
        //stringList.add(5);//编译期间将发生错误
        for (String str :
                stringList) {
            System.out.println(str.length());
        }
*/
        //java自动推断ArrayList<>的里面应该是String
        List<String> stringList = new ArrayList<>();
        stringList.add("php");
        //java自动推断HashMap的<>中为String, List<String>
        Map<String, List<String>> schoolsInfo = new HashMap<>();
        List<String> schools = new ArrayList<>();
        schools.add("qqq");
        schools.add("www");
        schoolsInfo.put("sgh", schools);
        //遍历map时key：String，value：List<String>
        schoolsInfo.forEach((key, value) -> System.out.println(key + "-->" + value));
    }
}
