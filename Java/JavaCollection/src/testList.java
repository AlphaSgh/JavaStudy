import java.util.*;

public class testList {
    public static void testList() {
        /**
         * 我们考察List<E>接口，可以看到几个主要的接口方法：
         *
         * 在末尾添加一个元素：boolean add(E e)
         * 在指定索引添加一个元素：boolean add(int index, E e)
         * 删除指定索引的元素：E remove(int index)
         * 删除某个元素：boolean remove(Object e)
         * 获取指定索引的元素：E get(int index)
         * 获取链表大小（包含元素的个数）：int size()
         */
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("apple");
        System.out.println(list.size());//size = 3

        List<String> list1 = new ArrayList<>();
        list1.add("apple");
        list1.add(null);
        list1.add("pear");
        String second = list1.get(1);
        System.out.println(list1.size());//size = 3
        System.out.println(second);// null

        List<Integer> list2 = List.of(1, 2, 4); //快速创建List：但不接受null值
        List<String> list3 = List.of("apple", "pear", "banner");
        for (int i = 0; i < list3.size(); i++) { //不推荐 要始终坚持使用迭代器Iterator来访问List
            System.out.println(list3.get(i));
        }
        for (Iterator<String> it = list3.iterator(); it.hasNext(); ) { //通过Iterator遍历List永远是最高效的方式
            String s = it.next();
            System.out.println(s);
        }
        for (String s :
                list3) {
            System.out.println(s);
        }

        //list 和 array转换
        //List-->Array
        List<String> list4 = List.of("apple", "bob", "cilm");
        Object[] array = list4.toArray(); //这种方法会丢失类型信息，所以实际应用很少。
        for (Object o :
                array) {
            System.out.println(o);
        }
        //第二种方式是给toArray(T[])传入一个类型相同的Array，List内部自动把元素复制到传入的Array中：
        //这个toArray(T[])方法的泛型参数<T>并不是List接口定义的泛型参数<E>
        List<Integer> list5 = List.of(1, 2, 3, 4);
        Integer[] array1 = list5.toArray(new Integer[4]);
        for (Integer n :
                array1) {
            System.out.println(n);
        }
        Number[] array2 = list5.toArray(new Number[4]);//传入Number类型的数组，返回的仍然是Number类型：
        for (Number n :
                array2) {
            System.out.println(n);
        }
//如果我们传入类型不匹配的数组，例如，String[]类型的数组，由于List的元素是Integer，所以无法放入String数组，这个方法会抛出ArrayStoreException。
//如果传入的数组不够大，那么List内部会创建一个新的刚好够大的数组，填充后返回；如果传入的数组比List元素还要多，那么填充完元素后，剩下的数组元素一律填充null。
        Integer[] array3 = list5.toArray(new Integer[list.size()]);
        Integer[] array4 = list5.toArray(Integer[]::new);
        //Array-->List
        Integer[] array5 = {1, 2, 3, 4};
        List<Integer> list6 = List.of(array5);
        //返回的List不一定就是ArrayList或者LinkedList，因为List只是一个接口，如果我们调用List.of()，它返回的是一个只读List：
        //对只读List调用add()、remove()方法会抛出UnsupportedOperationException。
        //list6.add(5);
    }
    public static void test01() {
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }
    public static int findMissingNumber(int start, int end, List<Integer> list) {
        Collections.sort(list);
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (i != list.get(i - start)) {
                return i;
            }
        }
        return 0;
    }
    public static void test02() {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 洗牌算法shuffle可以随机交换List中的元素位置:
        Collections.shuffle(list);
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }
    public static void testEquals() {
/*
        List<String> list = List.of("A", "B", "C");
        System.out.println(list.contains("C"));//true
        System.out.println(list.contains("Z"));//false
        System.out.println(list.indexOf("C"));//2
        System.out.println(list.indexOf("X"));//-1
        //因为我们传入的是new String("C")，所以一定是不同的实例。结果仍然符合预期，这是为什么呢？
        //因为List内部并不是通过==判断两个元素是否相等，而是使用equals()方法判断两个元素是否相等，例如contains()方法可以实现如下：
        //因此，要正确使用List的contains()、indexOf()这些方法，放入的实例必须正确覆写equals()方法，否则，放进去的实例，查找不到
        System.out.println(list.contains(new String("C")));//true
        System.out.println(list.indexOf(new String("C")));//2
*/
        List<Person> list = List.of(
                new Person("Xiao", "Ming", 18),
                new Person("Xiao", "Hong", 25),
                new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }
}
class Person {
    String firstName;
    String lastName;
    int age;
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return Objects.equals(this.firstName, p.firstName) && Objects.equals(this.lastName, p.lastName) && this.age == p.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}