package com.sgh.demo02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ListTest {
    public static void main(String[] args) {
        test04();
//        test03();
//        test02();
//        test01();
    }

    private static void test04() {
        var fixedList = Arrays.asList("java", "php", "ccc", "mysql");
        System.out.println(fixedList.getClass());//Arrays$ArrayList
        fixedList.forEach(s -> System.out.println(s));
//        fixedList.add("spring");//UnsupportedOperationException异常
    }

    private static void test03() {
        String[] books = {"php", "java", "ccc"};
        var bookList = new ArrayList<>();
        for (int i = 0; i < books.length; i++) {
            bookList.add(books[i]);
        }
        var lit = bookList.listIterator();
        //从前向后遍历
        while (lit.hasNext()) {
            System.out.println(lit.next());
            System.out.println("++++++++++++++++++++");
        }
        System.out.println("========反向迭代=============");
        while (lit.hasPrevious()) {
            System.out.println(lit.previous());
            System.out.println("++++++++++++++++++++");
        }
    }

    private static void test02() {
        var books = new ArrayList<>();
        books.add("java");
        books.add("php");
        books.add("mysql");
        books.add("spring");
        books.sort((o1, o2) -> ((String) o1).length() - ((String) o2).length());
        System.out.println(books);//[php, java, mysql, spring]
        books.replaceAll(o -> ((String) o).length());
        System.out.println(books);//[3, 4, 5, 6]
    }

    private static void test01() {
        var books = new ArrayList<>();
        books.add("java");
        books.add("php");
        books.add("ccc");
        System.out.println(books);
        books.add(1, "c++");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        books.remove(2);
        System.out.println(books);
        System.out.println(books.indexOf(new String("java")));//List判断两个对象是否相等通过equals方法判断
        books.set(1, "java,java");
        System.out.println(books.subList(1, 3));
    }
}
