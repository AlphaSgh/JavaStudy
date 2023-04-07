package org.example.test01;

import lombok.val;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();

        testAnd();
        testAnd01(value -> value % 2 == 0, value -> value > 4);

        //stream流注意：
        // 1.惰性求值，必须要存在终结操作
        // 2.流是一次性的，使用完之后将关闭流，不能两次使用同一个流，
        // 3.流不会影响原集合数据

        //test23();
        //test22();
        //test21();
        //test20();
        //test19();
        //test18();
        //test17();
        //test16();
        //test15();
        //test14();
        //test13();
        //test12();
        //test11();
        //test10();
        //test09();
        //test08();
        //test07();
        //test06();
        //test05();
        //test04();
        //stream流常用操作1、创建流；2、中间操作；3、终结操作
        //test01(authors);
        //创建流
        //单列集合：集合对象.stream()
        //Stream<Author> authorStream = authors.stream();
        //数组转换成stream流，Arrays.Stream() or Stream.of()
        //test02();
        //map集合转换成stream流，先将map集合转换为单列集合如EntrySet，在创建stream流
        //test03();

    }

    private static void testAnd01(IntPredicate predicate1, IntPredicate predicate2) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate1.and(predicate2).test(i)) {
                System.out.println(i);
            }
        }
    }

    private static void testAnd() {
        //打印作家中年龄大于17并且姓名长度大于1的作家
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(author -> author.getAge() > 17 && author.getName().length() > 1)
//                .filter(new Predicate<Author>() {
//                    @Override
//                    public boolean test(Author author) {
//                        return author.getAge() > 17;
//                    }
//                }.and(new Predicate<Author>() {
//                    @Override
//                    public boolean test(Author author) {
//                        return author.getName().length() > 1;
//                    }
//                }))
                .forEach(author -> System.out.println(author.getName() + "-->" + author.getAge()));
    }

    private static void test23() {
        List<Author> authors = getAuthors();
        Optional<Integer> min = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer result, Integer element) {
                        return result > element ? element : result;
                    }
                });
        min.ifPresent(integer -> System.out.println(integer));
    }

    private static void test22() {
        //使用reduce求作家年龄最大值和最小值
        List<Author> authors = getAuthors();
        Integer max = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);
        System.out.println("max = " + max);
        Integer min = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer result, Integer element) {
                        return result > element ? element : result;
                    }
                });
        System.out.println("min = " + min);
    }

    private static void test21() {
        //reduce对流中的数据按照指定的方式计算一个结果
        //对所有作者年龄的和
        List<Author> authors = getAuthors();
        Integer sum = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer result, Integer element) {
                        return result + element;
                    }
                });
        System.out.println(sum);
    }

    private static void test20() {
        //获取年龄最小的
        List<Author> authors = getAuthors();
        Optional<Author> first = authors.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst();

        first.ifPresent(author -> System.out.println(author.getAge()));
    }

    private static void test19() {
        //获取任意一个年龄大于20的作家
        List<Author> authors = getAuthors();
        Optional<Author> optionalAuthor = authors.stream()
                .filter(author -> author.getAge() > 90)
                .findAny();
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test18() {
        //判断作家年龄是否都小于100
        List<Author> authors = getAuthors();
        boolean flag = authors.stream()
                .noneMatch(author -> author.getAge() >= 100);
        System.out.println(flag);
    }

    private static void test17() {
        //判断是否所有的作者都是陈年人
        List<Author> authors = getAuthors();
        boolean is18 = authors.stream()
                .allMatch(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() > 18;
                    }
                });
        System.out.println(is18);
    }

    private static void test16() {
        //判断是否存在年龄超过29的作家
        List<Author> authors = getAuthors();
        boolean flag = authors.stream()
                .anyMatch(author -> author.getAge() > 58);
        System.out.println(flag);
    }

    private static void test15() {
        //把所有作者名字存放在List集合
        List<Author> authors = getAuthors();
        List<String> nameList = authors.stream()
                .map(author -> author.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(nameList);
        //把所有书名放入Set集合中
        Set<String> bookName = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getName())
                .collect(Collectors.toSet());
        System.out.println(bookName);
        //获取一个map集合，key：作者名 value：List<Book>
        Map<String, List<Book>> map = authors.stream()
                .distinct()//map中的key不可以重复
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(map);
    }

    private static void test14() {
        //分别获取作家所出书籍的最高分和最低分
        List<Author> authors = getAuthors();
        //Stream<Author> --> Stream<Book> --> Stream<Integer> --> 求值
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((score1, score2) -> score1 - score2);
        System.out.println("max = " + max.get());

        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min((score1, score2) -> score1 - score2);
        System.out.println("min = " + min.get());

    }

    private static void test13() {
        //统计作家所出书籍数目
        List<Author> authors = getAuthors();
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();//统计
        System.out.println(count);
    }

    private static void test12() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));//终结操作遍历
    }

    private static void test11() {
        //打印现有数据的分类，要求对分类进行去重，并且将多个分类进行拆分分割
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())//将一个元素转换为多个元素
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(category -> System.out.println(category));
    }

    private static void test10() {
        //map只能把一个对象转换成另一个对象作为流中的元素，flatmap可以把一个对象转换成多个对象作为流中的元素
        //打印所有书籍的名字，并进行去重
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .flatMap((Function<Author, Stream<Book>>) author -> author.getBooks().stream())
//                .flatMap(new Function<Author, Stream<Book>>() {
//                    @Override
//                    public Stream<Book> apply(Author author) {
//                        return author.getBooks().stream();
//                    }
//                })
                .forEach(book -> System.out.println(book.getName()));

    }

    private static void test09() {
        //对流中元素按照年龄排序，去重，除了年龄最大的作家、
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .skip(1)//跳过n个元素
                .forEach(author -> System.out.println(author.getName()));

    }

    private static void test08() {
        //对流中元素按照年龄排序，去重，并打印年龄最大的两个作家姓名
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .limit(2)//截取，限制
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test07() {
        List<Author> authors = getAuthors();
        //对年龄进行降序排序，不可重复
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
//                .sorted(new Comparator<Author>() { //有参sorted方法需要实现Comparator方法
//                    @Override
//                    public int compare(Author o1, Author o2) {
//                        return o2.getAge() - o1.getAge();
//                    }
//                })
                //.sorted()//排序,注意如果调用空参的sorted方法，需要流中的元素实现了Comparable接口
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void test06() {
        //distinct去重操作，依赖Object的equals方法判断重复，所以自定义对象需要重写equals方法
        //打印所有作家姓名，并去重
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct() //去重操作
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test05() {
        //打印所有作家姓名
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();
//        stream
//                .map(author -> author.getName())
//                .forEach(s -> System.out.println(s));
        stream
                .map(author -> author.getAge())//将流中的对象进行转换，Author转换为Integer
                .map(age -> age + 10)
                .forEach(age -> System.out.println(age));
    }

    private static void test04() {
        //打印姓名长度大于1的作家姓名
        List<Author> authors = getAuthors();
        Stream<Author> authorStream = authors.stream();
        authorStream
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test03() {
        Map<String, Integer> map = new HashMap<>();
        map.put("sss", 19);
        map.put("ggg", 20);
        map.put("hhh", 21);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Stream<Map.Entry<String, Integer>> entryStream = entrySet.stream();
        entryStream
                .filter(entry -> entry.getValue() > 19)
                .forEach(entry -> System.out.println(entry.getKey() + "--->" + entry.getValue()));
    }

    private static void test02() {
        Integer[] arr = {1, 2, 3, 4, 5, 5};
//        Stream<Integer> integerStream = Arrays.stream(arr);
        Stream<Integer> integerStream = Stream.of(arr);
        integerStream
                .distinct()
                .filter(integer -> integer > 2)//过滤操作
                .forEach(integer -> System.out.println(integer));
    }

    private static void test01(List<Author> authors) {
        authors
                .stream() //把集合转换成流，返回stream对象
                .distinct() //去重
                .filter(author -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static List<Author> getAuthors() {
        //数据初始化
        Author author1 = new Author(1L, "蒙多", 33, "一个菜刀祖安人", null);
        Author author2 = new Author(2L, "亚索", 19, "一意孤行", null);
        Author author3 = new Author(3L, "易", 20, "八只眼睛", null);
        Author author4 = new Author(3L, "易", 20, "八只眼睛", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "一把刀划分了爱恨"));
        books1.add(new Book(2L, "从零和博弈的角度探讨人际关系", "个人成长,爱情", 99, "侧重对情感关系的分析与技巧运用"));

        books2.add(new Book(3L, "知道自己所有焦虑和恐慌是源于什么", "哲学", 85, "不了解过去就永远处于孩提状态"));
        books2.add(new Book(3L, "知道自己所有焦虑和恐慌是源于什么", "哲学", 85, "不了解过去就永远处于孩提状态"));
        books2.add(new Book(4L, "在爱与被爱的过程中", "个人专辑,爱情", 99, "我们都曾经历过痛苦、恐惧"));

        books3.add(new Book(5L, "你的剑就是我的肩", "爱情", 56, "它不止是历史，更是博物学著作"));
        books3.add(new Book(6L, "风遇见", "个人成长", 100, "阅读这本书也许就能找到一个解答疑虑的指向标"));
        books3.add(new Book(6L, "风遇见", "个人成长", 100, "阅读这本书也许就能找到一个解答疑虑的指向标"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
        return authorList;
    }
}
