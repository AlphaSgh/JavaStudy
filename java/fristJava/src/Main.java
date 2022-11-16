public class Main {
    public static void main(String[] args) {
/*
        char aChar = 'a';
        char enterChar = '\r';
        char ch = '\u9999';
        System.out.println(ch);
        char zhong = '疯';
        int zongValue = zhong;
        System.out.println(zongValue);
        char c = 97;
        System.out.println(c);
        System.out.println("Hello world!");
*/
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

    }
}