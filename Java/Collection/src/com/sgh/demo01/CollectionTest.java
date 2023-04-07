package com.sgh.demo01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionTest {
    public static void main(String[] args) {
        List c = new ArrayList();
        c.add("java");
        c.add(Integer.valueOf(6));
        System.out.println("c中元素个数：" + c.size());
        c.remove(Integer.valueOf(6));
        System.out.println("c中元素个数：" + c.size());
        System.out.println("c中是否包含 Java 字符串：" + c.contains("java"));
        c.add("php");
        System.out.println("c中的元素：" + c);

        Set books = new HashSet();
        books.add("java");
        books.add("php");
        books.add("c++");
        System.out.println("c集合是否完全包含books集合" + c.containsAll(books));
        c.remove(books);//c集合减去books集合里面的元素
        System.out.println("c集合里面的元素" + c);
        c.clear();//删除c集合里面的所有元素
        System.out.println("c集合里面的元素" + c);
        books.retainAll(c);//将books集合变成books集合和c集合的交集
        System.out.println("books集合里面的元素" + books);
    }
}
