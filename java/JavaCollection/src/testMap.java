import java.sql.Struct;
import java.time.DayOfWeek;
import java.util.*;

public class testMap {
    public static void test01() {
        Student s = new Student("ss", 99);
        Map<String, Student> map = new HashMap<>();
        map.put("ss", s);
        Student target = map.get("ss");
        System.out.println(target == s);
        System.out.println(target.score);
        System.out.println(target.name);
        Student another = map.get("bob");
        System.out.println(another);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 1234);
        map1.put("pear", 4567);
        System.out.println(map1.get("apple"));
        // 始终牢记：Map中不存在重复的key，因为放入相同的key，只会把原有的key-value对应的value给替换掉。
        // 此外，在一个Map中，虽然key不能重复，但value是可以重复的：
        map1.put("apple", 234);
        System.out.println(map1.get("apple"));

        //遍历Map
        //对Map来说，要遍历key可以使用for each循环遍历Map实例的keySet()方法返回的Set集合，它包含不重复的key的集合
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 123);
        map2.put("pear", 456);
        map2.put("banner", 789);
        for (String key :
                map2.keySet()) {
            System.out.println(key + " = " + map2.get(key));
        }
        for (Map.Entry<String, Integer> entry:
        map2.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        //Map和List不同的是，Map存储的是key-value的映射关系，并且，它不保证顺序
        //遍历Map时，不可假设输出的key是有序的！
    }
    public static void test02() {
        List<Student> list = List.of(
                new Student("Bob", 78),
                new Student("Alice", 85),
                new Student("Brush", 66),
                new Student("Newton", 99));
        var holder = new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
    }
    public static void test03() {
        Map<String, Person> map = new HashMap<>();
        map.put("a", new Person("xiao", "ming", 12));
        map.put("b", new Person("xiao", "hong", 19));
        map.put("c", new Person("xiao", "bai", 20));
        map.get("a");//xiaoming
        map.get("X");//null
        //因此，正确使用Map必须保证：
        //
        //作为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
        //
        //作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：
        //如果两个对象相等，则两个对象的hashCode()必须相等；
        //如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
        //编写equals()和hashCode()遵循的原则是：
        //
        //equals()用到的用于比较的每一个字段，都必须在hashCode()中用于计算；equals()中没有使用到的字段，绝不可放在hashCode()中计算。
        //
        //另外注意，对于放入HashMap的value对象，没有任何要求。

    }
    public static void testEnumMap() {
        Map<DayOfWeek, String> map = new EnumMap<DayOfWeek, String>(DayOfWeek.class);
        map.put(DayOfWeek.MONDAY, "星期一");
        map.put(DayOfWeek.TUESDAY, "星期二");
        map.put(DayOfWeek.WEDNESDAY, "星期三");
        map.put(DayOfWeek.THURSDAY, "星期四");
        map.put(DayOfWeek.FRIDAY, "星期五");
        map.put(DayOfWeek.SATURDAY, "星期六");
        map.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));
    }
}
class Students {
    List<Student> list;
    Map<String, Integer> cache;
    public Students(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
    }
    /**
     * 根据name查找score，找到返回score，未找到返回-1
     */
    int getScore(String name) {
        // 先在Map中查找:
        Integer score = this.cache.get(name);
        if (score == null) {
            // TODO:
            score = findInList(name);
        }
        if (score != null) {
            this.cache.put(name, score);
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (var ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}
class Student {
    public int score;
    public String name;
    public Student(String name, int score) {
        this.score = score;
        this.name = name;
    }
}