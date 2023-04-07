import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testReflection {
    public static void testRef() throws Exception {
        /*
        Class cls1 = String.class;
        String s = "hello";
        Class cls2 = s.getClass();
        boolean sameClass = cls1 == cls2;
        System.out.println(sameClass);

        Integer n = 22;
        boolean b1 = n instanceof Integer;
        boolean b2 = n instanceof Number;
        boolean b3 = n.getClass() == Integer.class;
*/
        //boolean b4 = n.getClass() == Number.class;//不可比较的类型: java.lang.Class<capture#1, 共 ? extends java.lang.Integer>和java.lang.Class<java.lang.Number>
        //用instanceof不但匹配指定类型，还匹配指定类型的子类。而用==判断class实例可以精确地判断数据类型，但不能作子类型比较。
        //用instanceof判断数据类型,只有在需要精确判断一个类型是不是某个class的时候，我们才使用==判断class实例,
        //反射的目的是为了获得某个实例的信息, 当我们拿到某个Object实例时，我们可以通过反射获取该Object的class信息
        //System.out.println(b1 + " " + b2 + " " + b3);

        //printClassInfo(String.class);
        //如果获取到了一个Class实例，我们就可以通过该Class实例来创建对应类型的实例：
        //Class cls = String.class;
        //String str = (String) cls.newInstance();
        //相当于new String()。通过Class.newInstance()可以创建类实例，
        // 它的局限是：只能调用public的无参数构造方法。带参数的构造方法，或者非public的构造方法都无法通过Class.newInstance()被调用。

        //JVM为每个加载的class及interface创建了对应的Class实例来保存class及interface的所有信息；
        //
        //获取一个class对应的Class实例后，就可以获取该class的所有信息；
        //
        //通过Class实例获取class信息的方法称为反射（Reflection）；
        //
        //JVM总是动态加载class，可以在运行期根据条件来控制加载class。

/*
        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
*/
        /**
         * 一个Method对象包含一个方法的所有信息：
         *
         * getName()：返回方法名称，例如："getScore"；
         * getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
         * getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
         * getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。
         */
        //String s = "Hello world";
        //String r = s.substring(6); // "world"
/*
        String s = "Hello world";
        Method method = String.class.getMethod("substring", int.class);
        String r = (String) method.invoke(s, 6);
        System.out.println(r);
        method = String.class.getMethod("substring", int.class, int.class);
        r = (String) method.invoke(s, 1, 3);
        System.out.println(r);
*/
        /**
         * 对于非public方法，我们虽然可以通过Class.getDeclaredMethod()获取该方法实例，
         * 但直接对其调用将得到一个IllegalAccessException。
         * 为了调用非public方法，我们通过Method.setAccessible(true)允许其调用：
         */
/*
        Person person = new Person();
        Method method = person.getClass().getDeclaredMethod("setName", String.class);
        method.setAccessible(true);
        method.invoke(person, "NULL");
        System.out.println(person.getName());
*/
        Method method = Person.class.getMethod("hello");
        method.invoke(new Student());//student hello
        method.invoke(new Person());//person hello
        //使用反射调用方法时，仍然遵循多态原则：即总是调用实际类型的覆写方法（如果存在）。上述的反射代码：
        Person person = new Student();
        person.hello();
//调用构造方法
        Person p = new Person();
        //Class.newInstance()的局限是，它只能调用该类的public无参数构造方法。如果构造方法带有参数，或者不是public，就无法直接通过Class.newInstance()来调用。
        Person p1 = Person.class.newInstance();
        //Java的反射API提供了Constructor对象，它包含一个构造方法的所有信息，可以创建一个实例。
        // Constructor对象和Method非常类似，不同之处仅在于它是一个构造方法，并且，调用结果总是返回实例：
        //注意Constructor总是当前类定义的构造方法，和父类无关，因此不存在多态的问题。
        Constructor cons1 = Integer.class.getConstructor(int.class); //获取构造方法Integer(int):
        Integer n1 = (Integer) cons1.newInstance(123); //调用构造方法

        Constructor cons2 = Integer.class.getConstructor(String.class);
        Integer n2 = (Integer) cons2.newInstance("345");
        System.out.println(n1 + " " + n2);

//动态代理&&获取继承关系？？？
    }
    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
class Student extends Person {
    public int getScore(String type) {
        return 99;
    }
    private int getGrade(int year) {
        return 1;
    }
    public void hello() {
        System.out.println("student hello");
    }
}

class Person {
    private String name;
    public String getName() {
        return this.name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public void hello() {
        System.out.println("person hello!");
    }
}
