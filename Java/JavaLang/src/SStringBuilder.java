import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.StringJoiner;

public class SStringBuilder {
    public static void testSBuilder() throws IntrospectionException {
/*
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            sb.append(',');
            sb.append(i);
        }
        String str = sb.toString();
        System.out.println(str);
*/
/*
        StringBuilder sb = new StringBuilder(1024);
        sb.append("Mr ").append("Bob ").append("!").insert(0, "hello, ");
        System.out.println(sb);
*/
        //链式操作
/*
        Adder adder = new Adder();
        int value = adder.add(10).add(20).inc().value();
        System.out.println(value);
*/
/*
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insertSql = SStringBuilder.buildInsertSql(table, fields);
        System.out.println(insertSql);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insertSql) ? "测试成功" : "测试失败");
*/
        String[] names = {"Alice", "bob", "grace"};
/*
使用StringBuilder拼接字符串数组
        StringBuilder sb = new StringBuilder();
        sb.append("hello ");
        for (String name :
                names) {
            sb.append(name).append(", ");
        }
        //去掉最后的，
        sb.delete(sb.length() - 2, sb.length());
        sb.append("!");
        System.out.println(sb.toString());
*/
/*
       //使用StringJoiner拼接字符串数组
        StringJoiner sj = new StringJoiner(", ", "hello ", "!");//有前缀和后缀
        for (String name :
                names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
*/
        //使用String.join()方法拼接字符串数字，不包含前缀和后缀
        String str = String.join(", ", names);
        System.out.println(str);
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");

        //包装类1、自动装箱，自动拆箱 2、使用equals进行比较 m.equals(n)
        // 3、创建Integer方法 一。Integer n = new Integer(100);// Integer n = Integer.valueOf(100)推荐
        System.out.println(Integer.toString(100)); // "100",表示为10进制
        System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
        System.out.println(Integer.toHexString(100)); // "64",表示为16进制
        System.out.println(Integer.toOctalString(100)); // "144",表示为8进制
        System.out.println(Integer.toBinaryString(100)); // "1100100",表示为2进制

        // boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
        // int可表示的最大/最小值:
        int max = Integer.MAX_VALUE; // 2147483647
        int min = Integer.MIN_VALUE; // -2147483648
        // long类型占用的bit和byte数量:
        int sizeOfLong = Long.SIZE; // 64 (bits)
        int bytesOfLong = Long.BYTES; // 8 (bytes)


        // 所有的整数和浮点数的包装类型都继承自Number，因此，可以非常方便地直接通过包装类型获取各种基本类型：
        // 向上转型为Number:
        Number num = new Integer(999);
        // 获取byte, int, long, float, double:
        byte b = num.byteValue();
        int n = num.intValue();
        long ln = num.longValue();
        float ff = num.floatValue();
        double d = num.doubleValue();

        //把一个负的byte按无符号整型转换为int：
        byte x = -1;
        byte y = 127;
        System.out.println(Byte.toUnsignedInt(x)); // 255
        System.out.println(Byte.toUnsignedInt(y)); // 127

        //要枚举一个JavaBean的所有属性，可以直接使用Java核心库提供的Introspector：
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }

    }

    public static String buildSelectSql(String table, String[] fields) {
        StringJoiner sj = new StringJoiner(", ", "SELECT ", " FROM employee");
        for (String name :
                fields) {
            sj.add(name);
        }
        return sj.toString();
    }
    public static String buildInsertSql(String table, String[] fields) {
        String str1 = "INSERT INTO " + table + " (";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length - 1; i++) {
            sb.append(fields[i]);
            sb.append(", ");
        }
        sb.append(fields[fields.length - 1]);
        String str2 = sb.toString() + ") VALUES (?, ?, ?)";
        return str1 + str2;
    }
}
class Adder {
    private int sum = 0;
    public Adder add(int n) {
        sum += n;
        return this;
    }
    public Adder inc() {
        sum++;
        return this;
    }
    public int value() {
        return this.sum;
    }
}
class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}