import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * HashMap是一种以空间换时间的映射表，它的实现原理决定了内部的Key是无序的，
 * 即遍历HashMap的Key时，其顺序是不可预测的（但每个Key都会遍历一次且仅遍历一次）。
 * 还有一种Map，它在内部会对Key进行排序，这种Map就是SortedMap。注意到SortedMap是接口，它的实现类是TreeMap。
 */
public class testTreeMap {
    public static void test01() {
        //使用TreeMap时，放入的Key必须实现Comparable接口。
        // String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。作为Value的对象则没有任何要求。
        //如果作为Key的class没有实现Comparable接口，那么，必须在创建TreeMap时同时指定一个自定义排序算法：
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key :
                map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
        Map<Person1, Integer> map1 = new TreeMap<>(new Comparator<Person1>() {
            @Override
            public int compare(Person1 o1, Person1 o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        map1.put(new Person1("alice"), 1);
        map1.put(new Person1("tom"), 2);
        map1.put(new Person1("bob"), 4);
        for (Person1 key :
                map1.keySet()) {
            System.out.println(key + " = " + map1.get(key));
        }

        Map<Student1, Integer> map2 = new TreeMap<>();
        map2.put(new Student1("ss", 30), 30);
        map2.put(new Student1("gg", 60), 60);
        map2.put(new Student1("hh", 50), 50);
        for (Student1 key :
                map2.keySet()) {
            System.out.println(key);
        }
        System.out.println(map2.get(new Student1("gg", 60)));//null
    }
}
class Person1 {
    public String name;
    public Person1(String name) {
        this.name = name;
    }
    public String toString() {
        return "{Person: " + name + "}";
    }
}
class Student1 implements Comparable{
    public String name;
    public int score;
    Student1(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student1) {
            Student1 student1 = (Student1) o;
            if (this.score == student1.score)
                return 0;
            return this.score > student1.score ? 1 : -1;
        }
        return 0;
    }
}