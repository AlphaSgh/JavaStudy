public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
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
        Class cls = String.class;
        String str = (String) cls.newInstance();
        //相当于new String()。通过Class.newInstance()可以创建类实例，
        // 它的局限是：只能调用public的无参数构造方法。带参数的构造方法，或者非public的构造方法都无法通过Class.newInstance()被调用。

        //JVM为每个加载的class及interface创建了对应的Class实例来保存class及interface的所有信息；
        //
        //获取一个class对应的Class实例后，就可以获取该class的所有信息；
        //
        //通过Class实例获取class信息的方法称为反射（Reflection）；
        //
        //JVM总是动态加载class，可以在运行期根据条件来控制加载class。

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