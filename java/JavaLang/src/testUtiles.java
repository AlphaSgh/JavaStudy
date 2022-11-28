import java.security.SecureRandom;
import java.util.HexFormat;
import java.util.Random;

public class testUtiles {
    public static void testUtiles() {
        Math.abs(-100);
        Math.abs(-4.5);
        Math.max(122, 111);
        Math.min(12, 122);
        Math.pow(2, 10); // 2^10
        Math.sqrt(2); //根号x
        Math.exp(2); // e^x
        Math.log(2); //以e为底的对数
        Math.log10(2); // 以10为底的对数
        Math.sin(3.14);
        Math.cos(3.14);
        Math.tan(3.14);
        Math.asin(1);
        Math.acos(1);
        double pi = Math.PI;
        double e = Math.E;
        Math.sin(Math.PI / 6);
        Math.random();// 0 - 1之间的随机数
        double min = 10;
        double max = 50;
        double x = Math.random();
        double y = x * (max - min) + min;
        long n = (long) y;
        System.out.println(y);
        System.out.println(n);

        byte[] data = "hello".getBytes();
        HexFormat hf = HexFormat.of();
        String hexData = hf.formatHex(data);
        System.out.println(hexData);
        hf = HexFormat.ofDelimiter(" ").withPrefix("Ox").withUpperCase();
        hexData = hf.formatHex("hello".getBytes());
        System.out.println(hexData);

        byte[] bytes = HexFormat.of().parseHex("48656c6c6f");
        System.out.println(new String(bytes));

        //伪随机数Random
        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println(random.nextLong());
        System.out.println(random.nextInt(10));
        System.out.println(random.nextDouble());

        random = new Random(12345);
        for (int i = 0; i < 5; i++) {
            System.out.println("r.nextInt = " + random.nextInt(100));
        }
        //安全随机数SecureRandom
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextInt(100));
    }
}
