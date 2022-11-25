public class TestClassAndInstance {

}
class City {
    String name;
    double latitude;
    double longitude;
}
class Persion {
    protected int age;
    protected String name;

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Persion(String name) {
        this(name, 18);
    }
    public Persion() {
        this("sgh");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
    }
    public void setName(String name1, String name2) {
        this.name = name1 + " & " + name2;
    }
}

/**
 * 正常情况下，只要某个class没有final修饰符，那么任何类都可以从该class继承。
 * 从Java 15开始，允许使用sealed修饰class，并通过permits明确写出能够从该class继承的子类名称。
 * public sealed class Shape permits Rect, Circle, Triangle {。。。}
 * public final class Rect extends Shape {...}==>OK
 * public final class Ellipse extends Shape {...}==>error class is not allowed to extend sealed class: Shape
 *
 */
class Student extends Persion {
    private double score;
    public Student() {

    }
    public Student(String name, int age, double score) {
        //子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。
        super(name, age);//super()调用父类构造方法
        this.score = score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public double getScore() {
        return this.score;
    }
    public void Hello(){
//        System.out.println("hello " + name); //为了让子类可以访问父类的字段，我们需要把private改为protected。用protected修饰的字段可以被子类访问：
        System.out.println("hello " + super.name);
    }
}
class PrimaryStudent extends Student {
    protected int grade;
    public PrimaryStudent(String name, int age, double score, int grade) {
        super(name, age, score);
        this.grade = grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
}
class Hello {
    public void Hello() {
        System.out.println("hello!!!");
    }
    public void Hello(String name) {
        System.out.println("hello " + name);
    }
    public void Hello(String name, int age) {
        if (age > 18) {
            System.out.println("hello " + name + age);
        } else {
            System.out.println("hi " + name + age);
        }
    }
}