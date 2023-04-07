package com.sgh.demo01;

import java.util.*;
import java.util.function.Predicate;

public class IteratorTest {
    public static void main(String[] args) {
        test05();
//        test04();
//        test03();//通过foreach遍历集合元素
//        test02();//iterator.forEachRemaining()遍历
//        test01();//iterator.hasNext() iterator.next()遍历

    }

    private static void test05() {
        Set books = new HashSet<>();
        books.add("php");
        books.add("c++");
        books.add("java");
        System.out.println(callAll(books, o -> ((String) o).contains("php")));
        System.out.println(callAll(books, o -> ((String) o).contains("java")));
        System.out.println(callAll(books, o -> ((String) o).length() > 3));
    }
    public static int callAll(Collection books, Predicate predicate) {
        int total = 0;
        for (var book :
                books) {
            //使用Predicate的test()方法判断对象是否满足Predicate指定的条件
            if (predicate.test(book)) {
                total++;
            }
        }
        return total;
    }

    private static void test04() {
        Set books = new HashSet<>();
        books.add("php");
        books.add("c++");
        books.add("java");
        //使用lambda表达式过滤集合
        books.removeIf(book -> ((String) book).length() > 3);
        System.out.println(books);
    }

    private static void test03() {
        List books = new ArrayList<>();
        books.add("php");
        books.add("c++");
        books.add("java");
        Iterator it = books.iterator();
        for (Object obj : books) {
            String book = (String) obj;
            System.out.println(book);
        }
        System.out.println(books);
    }

    private static void test02() {
        List books = new ArrayList<>();
        books.add("php");
        books.add("c++");
        books.add("java");
        Iterator it = books.iterator();
        //使用lambda表达式遍历集合元素
        it.forEachRemaining(str -> System.out.println(str));

    }

    private static void test01() {
        List books = new ArrayList<>();
        books.add("php");
        books.add("c++");
        books.add("java");
        Iterator it = books.iterator();
        //在使用Iterator迭代过程中，不可修改集合元素，否则将引起异常
        while (it.hasNext()) {
            // it.next()方法返回的数据类型是Object类型，需要强制转换
            String book = (String) it.next();
            System.out.println(book);
            if (book.equals("php")) {
                //从集合中移除上一侧next()方法返回的元素
                it.remove();
            }
            // 对book变量进行赋值修改，不会改变集合元素本身
            book = "测试字符串";
        }
        System.out.println(books);
    }
}
