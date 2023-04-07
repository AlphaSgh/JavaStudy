package org.example.test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OptionalDemo {
    public static void main(String[] args) {

        testMap();
        //testFilter();
        //使用Option可以避免空指针异常
//        Author author = getAuthor();
//
//        Optional<Author> authorOptional = getAuthorOptional();
//        Author author1 = authorOptional.orElseGet(() -> new Author(2L, "蒙多2", 33, "一个菜刀祖安人", null));//如果获取的Option为空则返回默认设定的值
//        System.out.println(author1);
//
//        try {
//            Author author2 = authorOptional.orElseThrow(() -> new RuntimeException("数据为空"));
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }

        //创建Optional对象
//        Optional<Author> authorOptional = Optional.ofNullable(author);
//        authorOptional.ifPresent(author1 -> System.out.println(author1.getName()));
//
//        Optional<Author> authorOptional1 = getAuthorOptional();
//        authorOptional1.ifPresent(author1 -> System.out.println(author1.getName()));

//        Author author1 = null;
//        Optional<Author> optional = Optional.of(author1);//空指针异常，of方法必须不为空才可以使用
//        if (author != null) {
//            System.out.println(author.getAge());//空指针异常
//        }
    }

    private static void testMap() {
        Optional<Author> authorOptional = getAuthorOptional();
        Optional<List<Book>> books = authorOptional.map(author -> author.getBooks());
        books.ifPresent(books1 -> System.out.println(books1));
    }

    private static void testFilter() {
        Optional<Author> author = getAuthorOptional();
        Optional<Author> authorOptional = author.filter(author1 -> author1.getAge() > 14);
        authorOptional.ifPresent(author12 -> System.out.println(author12.getName()));
    }

    public static Optional<Author> getAuthorOptional() {
        Author author = new Author(1L, "蒙多", 33, "一个菜刀祖安人", null);
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "一把刀划分了爱恨"));
        author.setBooks(books1);
        return Optional.ofNullable(author);
    }
    public static Author getAuthor() {
        Author author = new Author(1L, "蒙多", 33, "一个菜刀祖安人", null);
        return author;
    }
}
