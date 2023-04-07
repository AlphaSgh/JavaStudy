import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 所有需要网络传输的对象都需要实现序列化接口，通过建议所有的javaBean都实现Serializable接口。
 * 对象的类名、实例变量（包括基本类型，数组，对其他对象的引用）都会被序列化；方法、类变量、transient实例变量都不会被序列化。
 * 如果想让某个变量不被序列化，使用transient修饰。
 * 序列化对象的引用类型成员变量，也必须是可序列化的，否则，会报错。
 * 反序列化时必须有序列化对象的class文件。
 * 当通过文件、网络来读取序列化后的对象时，必须按照实际写入的顺序读取。
 * 单例类序列化，需要重写readResolve()方法；否则会破坏单例原则。
 * 同一对象序列化多次，只有第一次序列化为二进制流，以后都只是保存序列化编号，不会重复序列化。
 * 建议所有可序列化的类加上serialVersionUID 版本号，方便项目升级。
 */
public class TestSerializable {
    public static void test01() throws IOException {
/*
        //序列化步骤：
        //步骤一：创建一个ObjectOutputStream输出流；
        //步骤二：调用ObjectOutputStream对象的writeObject输出可序列化对象。
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Person.txt"))) {
            Person person = new Person("sgh", 24);
            oos.writeObject(person);
        }
*/
        /**
         * 反序列化步骤：
         * 步骤一：创建一个ObjectInputStream输入流；
         * 步骤二：调用ObjectInputStream对象的readObject()得到序列化的对象。
         */
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Person.txt"))) {
            Person baby = (Person) ois.readObject();
            System.out.println(baby.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void test02() throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Teacher.txt"))) {
            Person person = new Person("路飞", 20);
            Teacher t1 = new Teacher("雷利", person);
            Teacher t2 = new Teacher("红发香克斯", person);
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(person);
            oos.writeObject(t2);
        }
    }
    public static void test03() throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Teacher.txt"))) {
            //反序列化的顺序与序列化时的顺序一致。
            //同一对象序列化多次，会将这个对象序列化多次吗？答案是否定的。
            //Java序列化同一对象，并不会将此对象序列化多次得到多个对象。
            //所有保存到磁盘的对象都有一个序列化编码号
            //当程序试图序列化一个对象时，会先检查此对象是否已经序列化过，只有此对象从未（在此虚拟机）被序列化过，才会将此对象序列化为字节序列输出。
            //如果此对象已经序列化过，则直接输出编号即可。
            Teacher t1 = (Teacher) ois.readObject();
            Teacher t2 = (Teacher) ois.readObject();
            Person person = (Person) ois.readObject();
            Teacher t3 = (Teacher) ois.readObject();
            System.out.println(t1 == t2);//false
            System.out.println(t1.getPerson() == person);//true
            System.out.println(t2.getPerson() == person);//true
            System.out.println(t2 == t3);//true
            System.out.println(t1.getPerson() == t2.getPerson());//true
        }
    }
}

/**
 * Serializable接口是一个标记接口，不用实现任何方法。一旦实现了此接口，该类的对象就是可序列化的。
 * 如果一个可序列化的类的成员不是基本类型，也不是String类型，那这个引用类型也必须是可序列化的；否则，会导致此类不能序列化。
 */
class Person implements Serializable {
    String name;
    int age;

    public Person(String name, int age) {
        System.out.println("hello");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
//使用transient修饰的属性，java序列化时，会忽略掉此字段，所以反序列化出的对象，
// 被transient修饰的属性是默认值。对于引用类型，值是null；基本类型，值是0；boolean类型，值是false
class Teacher implements Serializable {
    String name;
    Person person;

    public Teacher(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}