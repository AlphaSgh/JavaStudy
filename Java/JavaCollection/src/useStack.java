import java.util.*;

public class useStack {
    //Stack只有入栈和出栈的操作：
    //把元素压栈：push(E)；
    //把栈顶的元素“弹出”：pop()；
    //取栈顶元素但不弹出：peek()
    //在Java中，我们用Deque可以实现Stack的功能：
    //当我们把Deque作为Stack使用时，注意只调用push()/pop()/peek()方法
    public static void test01() {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }
    static String toHex(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        Deque<String> deque = new LinkedList<>();
        int result = num / 16;
        int rest = num % 16;
        while (rest != 0 || result != 0) {
            String r = switch (rest) {
                case 10 -> "A";
                case 11 -> "B";
                case 12 -> "C";
                case 13 -> "D";
                case 14 -> "E";
                case 15 -> "F";
                default -> String.valueOf(rest);
            };
            rest = result % 16;
            result = result / 16;
            deque.push(r);
        }
        System.out.println();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pop());
        }
        return stringBuilder.toString();
    }
    public static void test02() {
        ReverseList<String> reverseList = new ReverseList<>();
        reverseList.add("apple");
        reverseList.add("orange");
        reverseList.add("pear");
        for (String s :
                reverseList) {
            System.out.println(s);
        }
    }
}
/**
 * 如果我们自己编写了一个集合类，想要使用for each循环，只需满足以下条件：
 *
 * 集合类实现Iterable接口，该接口要求返回一个Iterator对象；
 * 用Iterator对象迭代集合内部数据。
 * 这里的关键在于，集合类通过调用iterator()方法，返回一个Iterator对象，这个对象必须自己知道如何遍历该集合。
 */
class ReverseList<T> implements Iterable<T> {
    private List<T> list = new ArrayList<>();
    public void add(T t) {
        list.add(t);
    }
    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }
    class ReverseIterator implements Iterator<T> {
        int index;
        ReverseIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReverseList.this.list.get(index);
        }
    }
}
/**
 * Collections是JDK提供的工具类，同样位于java.util包中。它提供了一系列静态方法，能更方便地操作各种集合。
 *  注意Collections结尾多了一个s，不是Collection！
 *  addAll()方法可以给一个Collection类型的集合添加若干元素。因为方法签名是Collection，所以我们可以传入List，Set等各种集合类型。
 */
class useCollections {
    public static void test01() {
/*      Collections提供了一系列方法来创建空集合：
        创建空List：List<T> emptyList()
        创建空Map：Map<K, V> emptyMap()
        创建空Set：Set<T> emptySet()
        要注意到返回的空集合是不可变集合，无法向其中添加或删除元素。
*/
        List<String> list1 = List.of();
        List<String> list2 = Collections.emptyList();
        /**
         * Collections提供了一系列方法来创建一个单元素集合：
         * 创建一个元素的List：List<T> singletonList(T o)
         * 创建一个元素的Map：Map<K, V> singletonMap(K key, V value)
         * 创建一个元素的Set：Set<T> singleton(T o)
         * 要注意到返回的单元素集合也是不可变集合，无法向其中添加或删除元素。
         * 也可以用各个集合接口提供的of(T...)方法创建单元素集合
         */
        List<String> list3 = Collections.singletonList("apple");
        List<String> list4 = List.of("apple");
        //Collections可以对List进行排序。因为排序会直接修改List元素的位置，因此必须传入可变List：
        List<String> list5 = new ArrayList<>();
        list5.add("apple");
        list5.add("pear");
        list5.add("orange");
        System.out.println("排序前：" + list5);
        Collections.sort(list5);
        System.out.println("排序后：" + list5);
        //Collections提供了洗牌算法，即传入一个有序的List，可以随机打乱List内部元素的顺序，效果相当于让计算机洗牌：
        List<Integer> list6 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list6.add(i);
        }
        System.out.println("before：" + list6);
        Collections.shuffle(list6);
        System.out.println("after；" + list6);
        /**
         * Collections还提供了一组方法把可变集合封装成不可变集合：
         * 封装成不可变List：List<T> unmodifiableList(List<? extends T> list)
         * 封装成不可变Set：Set<T> unmodifiableSet(Set<? extends T> set)
         * 封装成不可变Map：Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m)
         */
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        mutable.add("orange");
        System.out.println(immutable);
    }
}
