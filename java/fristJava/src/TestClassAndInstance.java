public class TestClassAndInstance {

}
class City {
    String name;
    double latitude;
    double longitude;
}
class Persion {
    private int age;
    private String name;

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