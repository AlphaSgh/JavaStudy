import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Sstring {
    public static void testString() throws Exception {
/*
        String s = "hello";
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s == s2);
        System.out.println(s.equals(s2));
        System.out.println(s.equals(s1));
        System.out.println(s == s1);
        System.out.println(s);
        String s3 = s.toUpperCase();
        System.out.println(s);
*/
        // 比较字符串是否相等用equals方法
        // 两个字符串比较，必须总是使用equals()方法。
        // 要忽略大小写比较，使用equalsIgnoreCase()方法。
        /**
         * Strings方法；
         * "Hello".contains("ll"); // true,contains()方法的参数是CharSequence而不是String，因为CharSequence是String实现的一个接口。
         * "Hello".indexOf("l"); // 2
         * "Hello".lastIndexOf("l"); // 3
         * "Hello".startsWith("He"); // true
         * "Hello".endsWith("lo"); // true
         * "Hello".substring(2); // "llo"
         * "Hello".substring(2, 4); "ll"
         * "  \tHello\r\n ".trim(); // "Hello",使用trim()方法可以移除字符串首尾空白字符。空白字符包括空格，\t，\r，\n：
         * trim()并没有改变字符串的内容，而是返回了一个新字符串。
         * 另一个strip()方法也可以移除字符串首尾空白字符。它和trim()不同的是，类似中文的空格字符\u3000也会被移除：
         * "\u3000Hello\u3000".strip(); // "Hello"
         * " Hello ".stripLeading(); // "Hello "
         * " Hello ".stripTrailing(); // " Hello"
         * String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：
         * "".isEmpty(); // true，因为字符串长度为0
         * "  ".isEmpty(); // false，因为字符串长度不为0
         * "  \n".isBlank(); // true，因为只包含空白字符
         * " Hello ".isBlank(); // false，因为包含非空白字符
         * 要在字符串中替换子串，有两种方法。一种是根据字符或字符串替换：
         * 1、String s = "hello";
         * s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
         * s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
         * 2、String s = "A,,B;C ,D";
         * s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
         * 要分割字符串，使用split()方法，并且传入的也是正则表达式：
         * String s = "A,B,C,D";
         * String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}
         * 拼接字符串使用静态方法join()，它用指定的字符串连接字符串数组：
         * String[] arr = {"A", "B", "C"};
         * String s = String.join("***", arr); // "A***B***C"
         */
/*
        String s = "Hi %s, your score is %d!";
//        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false
//       //Integer有个getInteger(String)方法，它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer：
        Integer.getInteger("java.version"); // 版本号，11
        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s1 = new String(cs); // char[] -> String  如果修改了char[]数组，String并不会改变：
        //这是因为通过new String(char[])创建新的String实例时，它并不会直接引用传入的char[]数组，而是会复制一份，
        // 所以，修改外部的char[]数组不会影响String实例内部的char[]数组，因为这是两个不同的数组。
        //从String的不变性设计可以看出，如果传入的对象有可能改变，我们需要复制而不是直接引用。
        System.out.println(s1);
        cs[1] = 'X';
        System.out.println(s1);
*/
        //从String的不变性设计可以看出，如果传入的对象有可能改变，我们需要复制而不是直接引用。
        int[] scores = new int[] {1, 2, 3, 4, 5};
        score score = new score(scores);
        score.printScores();
        scores[0] = 11;
        score.printScores();

        byte[] b1 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
        byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
        byte[] b3= "Hello".getBytes("GBK"); // 按GBK编码转换
        byte[] b4 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
        System.out.println(Arrays.toString(b1));
        System.out.println(Arrays.toString(b2));
        System.out.println(Arrays.toString(b3));
        System.out.println(Arrays.toString(b4));
        byte[] b = b1;
        String s1 = new String(b, "GBK"); // 按GBK转换
        System.out.println(s1);
        String s2 = new String(b, StandardCharsets.UTF_8); // 按UTF-8转换

        /**
         * 早期JDK版本的String总是以char[]存储，它的定义如下：
         * 而较新的JDK版本的String则以byte[]存储：
         * 如果String仅包含ASCII字符，则每个byte存储一个字符，
         * 否则，每两个byte存储一个字符，这样做的目的是为了节省内存，
         * 因为大量的长度较短的String通常仅包含ASCII字符：
         */


    }
}
class score {
    private int[] scores;
/*
    public score(int[] scores) {
        this.scores = scores;
    }
*/
    public score(int[] scores) {
        //从String的不变性设计可以看出，如果传入的对象有可能改变，我们需要复制而不是直接引用。
        int[] temp = Arrays.copyOf(scores, scores.length);
        this.scores = temp;
    }
    public void printScores() {
        System.out.println(Arrays.toString((this.scores)));
    }
}