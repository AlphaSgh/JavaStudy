package com.sgh.demo02;

import java.util.*;

class M {
    public int age;
    public M(int age) {
        this.age = age;
    }
    public String toString(){
        return "M {age:" + age + "}";
    }
}

public class HashSetTest{
    public static void main(String[] args) {
        test05();
//        test04();
//        test03();
//        test02();
//        test01();
    }

    private static void test05() {
        Set treeSet = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                M m1 = (M) o1;
                M m2 = (M) o2;
                return m1.age > m2.age ? 1 : m1.age < m2.age ? -1 : 0;
            }
        });
        treeSet.add(new M(1));
        treeSet.add(new M(-1));
        treeSet.add(new M(-5));
        treeSet.add(new M(9));
        treeSet.add(new M(11));
        System.out.println(treeSet);

    }

    private static void test04() {
        var treeSet = new TreeSet<>();
        var z1 = new Z(6);
        treeSet.add(z1);
        System.out.println(treeSet.add(z1));//TreeSet 添加同一个对象（对象的compareTo方法返回值不为零，）true
        System.out.println(treeSet);
        ((Z) (treeSet.first())).age = 9;
        System.out.println(((Z) (treeSet.first())).age);
        System.out.println(((Z) (treeSet.last())).age);
    }

    private static void test03() {
        var nums = new TreeSet<>();
        //向TreeSet中添加四个Integer对象
        nums.add(5);
        nums.add(10);
        nums.add(19);
        nums.add(-2);
        //输出元素，处于排序状态
        System.out.println(nums);
        System.out.println(nums.first());
        System.out.println(nums.last());
        System.out.println(nums.lower(3));
        System.out.println(nums.higher(3));
        System.out.println(nums.headSet(12));
        System.out.println(nums.tailSet(12));
        System.out.println(nums.subSet(1, 8));
    }

    private static void test02() {
        var books = new LinkedHashSet<>();//LinkedHashSet维护添加进集合的元素顺序
        books.add("php");
        books.add("java");
        System.out.println(books);
        books.remove("php");
        books.add("php");
        System.out.println(books);
    }

    private static void test01() {
        var books = new HashSet<>();
        //分别向books中添加两个A，B，C
        books.add(new A());
        books.add(new A());
        books.add(new B());
        books.add(new B());
        books.add(new C());
        books.add(new C());
        System.out.println(books);//B B C A A
    }
}
class A {
    //A类的equals方法总返回true，没有重写hashCode方法

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
class B {
    @Override
    public int hashCode() {
        return 1;
    }
}
class C {
    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
class Z implements Comparable {

    public int age;
    public Z(int age) {
        this.age = age;
    }
    @Override
    public boolean equals(Object obj) {
        return true;
    }
    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
