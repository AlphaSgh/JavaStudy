import java.sql.Struct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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