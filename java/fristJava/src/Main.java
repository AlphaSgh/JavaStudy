public class Main {
    public static void main(String[] args) {
        Income[] incomes = new Income[] {
                new Income(3000),
                new Salary(5000),
                new StateCouncilSpecialAllowance(1000)
        };
        Income1[] income1s = new Income1[] {
                new otherIncome(3000),
                new Salary1(5000),
                new StateSalary(1000),
        };
        double total = totalTax(incomes);
        double total1 = totalTax(income1s);
        System.out.println(total);
        System.out.println(total1);
/*
        Persion p = new Persion();
        Student s = new Student();
        //Student继承自Person，因此，它拥有Person的全部功能。Person类型的变量，
        // 如果指向Student类型的实例，对它进行操作，是没有问题的！
        //这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）。
        Persion p_s = new Student();
        //向上转型实际上是把一个子类型安全地变为更加抽象的父类型：
        p = s; // upcasting, ok
        Object o1 = p; // upcasting, ok
        Object o2 = s; // upcasting, ok

        //向下转型
        Persion p1 = new Student(); // upcasting, ok
        Persion p2 = new Persion();
        Student s1 = (Student) p1; // ok
        //Student s2 = (Student) p2; // runtime error! ClassCastException!
*/
        //为了避免向下转型出错，Java提供了instanceof操作符，可以先判断一个实例究竟是不是某种类型：
        //instanceof实际上判断一个变量所指向的实例是否是指定类型，或者这个类型的子类。
        // 如果一个引用变量为null，那么对任何instanceof的判断都为false。
/*
        Persion P = new Persion();
        System.out.println(P instanceof Persion); //true
        System.out.println(P instanceof Student); //false
        Student S = new Student();
        System.out.println(S instanceof Student); //true
        System.out.println(S instanceof Persion); //false
        Student n = null;
        System.out.println(n instanceof Student); //false

        //利用instanceof，在向下转型前可以先判断
        Persion P1 = new Student();
        if (P1 instanceof Student) {
            Student S1 = (Student) P1;
        }
*/
//        从Java 14开始，判断instanceof后，可以直接转型为指定变量，避免再次强制转型。例如，对于以下代码：
        //if (P1 instanceof String s1) { S1...}


/*
        String s = "Test string";
        int n1 = s.indexOf('t');
        int n2 = s.indexOf("st");
        int n3 = s.indexOf("st", 4);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
*/

/*
        Hello hello = new Hello();
        hello.Hello();
        hello.Hello("sgh");
        hello.Hello("sgh", 19);
*/
/*
        Persion ming = new Persion();
//        ming.setAge(11);
        ming.setName("ming", "hong");
//        System.out.println("ming age==" + ming.getAge());
        System.out.println("ming name==" + ming.getName());
*/
/*
        City bj = new City();
        bj.name = "BeiJing";
        bj.latitude = 39.903;
        bj.longitude = 116.401;

        System.out.println(bj.name);
        System.out.println(bj.latitude);
        System.out.println(bj.longitude);
*/


/*
        for (String arg :
                args) {
            if ("-version".equals(arg)) {
                System.out.println("v1.0");
                break;
            }
        }
*/
/*
        char aChar = 'a';
        char enterChar = '\r';
        char ch = '\u9999';
        System.out.println(ch);
        char zhong = 'zhong';
        int zongValue = zhong;
        System.out.println(zongValue);
        char c = 97;
        System.out.println(c);
        System.out.println("Hello world!");
*/
/*
        float af = 3.1415f;
        System.out.println(af);
        double a = 0.0;
        double c = Double.NEGATIVE_INFINITY;
        float d = Float.NEGATIVE_INFINITY;
        System.out.println(c == d); //true
        System.out.println(a / a); //NaN
        System.out.println(a / a == Float.NaN); //false
        System.out.println(6.0 / 0.0 == 55.0 / 0.0); //true
        System.out.println(-8 / a); //-Infinity
        System.out.println(0 / 0); // exception
*/
//        ForTest forTest = new ForTest();
//        forTest.forTest();
//        forTest.testArrayToString();
//        forTest.testBubble();
//        forTest.testDesc();
//        forTest.testAverage();
    }
    public static double totalTax(Income[] incomes) {
        double total = 0;
        for (Income income: incomes) {
            total += income.getTax();
        }
        return total;
    }
    public static double totalTax(Income1[] incomes1) {
        double total = 0;
        for (Income1 income1: incomes1) {
            total += income1.getTax();
        }
        return total;
    }
}