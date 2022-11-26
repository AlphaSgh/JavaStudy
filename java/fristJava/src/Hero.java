public class Hero {
//    静态字段属于所有实例“共享”的字段，实际上是属于class的字段；
//    调用静态方法不需要实例，无法访问this，但可以访问静态字段和其他静态方法；
//    静态方法常用于工具类和辅助方法。
    public static int count = 0;
    public static int getCount() {
        return count;
    }

    public String name;
    public int age;
    public static int number;

    public Hero(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
//因为静态方法属于class而不属于实例，因此，静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段。
    public static void setNumber(int value) {
        number = value;
    }
}
