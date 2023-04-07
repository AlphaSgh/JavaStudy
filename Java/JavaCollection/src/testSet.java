import java.util.*;

/**
 * 如果我们只需要存储不重复的key，并不需要存储映射的value，那么就可以使用Set
 * Set用于存储不重复的元素集合，它主要提供以下几个方法：
 * 将元素添加进Set<E>：boolean add(E e)
 * 将元素从Set<E>删除：boolean remove(Object e)
 * 判断是否包含元素：boolean contains(Object e)
 * Set实际上相当于只存储key、不存储value的Map。我们经常用Set用于去除重复元素。
 * 最常用的Set实现类是HashSet，实际上，HashSet仅仅是对HashMap的一个简单封装
 * HashSet是无序的，因为它实现了Set接口，并没有实现SortedSet接口；
 * TreeSet是有序的，因为它实现了SortedSet接口。
 */
public class testSet {
    public static void test01() {
        Set<String> set = new HashSet<>();//hashset 无序
        System.out.println(set.add("abc"));
        System.out.println(set.add("xyz"));
        System.out.println(set.add("xyz"));
        System.out.println(set.contains("xyz"));
        System.out.println(set.contains("Xyz"));
        System.out.println(set.remove("hello"));
        System.out.println(set.size());
        for (String s :
                set) {
            System.out.println(s);
        }
        //使用TreeSet和使用TreeMap的要求一样，添加的元素必须正确实现Comparable接口，如果没有实现Comparable接口，那么创建TreeSet时必须传入一个Comparator对象。
        Set<String> set1 = new TreeSet<>();
        set1.add("apple");
        set1.add("banner");
        set1.add("pear");
        set1.add("orange");
        for (String s :
                set1) {
            System.out.println(s);
        }
    }
    public static void test02() {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }
    static List<Message> process(List<Message> received) {
        //TODO:
        Set<Message> messages = new TreeSet<>(new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                if (o1.sequence == o2.sequence) {
                    return 0;
                }
                return o1.sequence > o2.sequence ? 1 : -1;
            }
        });
        messages.addAll(received);
        return new ArrayList<Message>(messages);
    }
}
class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}
