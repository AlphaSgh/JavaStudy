import java.io.*;

/**
 * InputStream并不是一个接口，而是一个抽象类，它是所有输入流的超类。这个抽象类定义的一个最重要的方法就是int read()，签名如下：
 */
public class TestInputStream {
    public static void test01() throws IOException {
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("src/input.txt");
//            int n;
//            while ((n = inputStream.read()) != -1) {
//                System.out.println(n);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try (InputStream inputStream1 = new FileInputStream("src/input.txt")) {
            int n;
            while ((n = inputStream1.read()) != -1) {
                System.out.println(n);
            }
        }
        //缓冲:InputStream提供了两个重载方法来支持读取多个字节：
        //int read(byte[] b)：读取若干字节并填充到byte[]数组，返回读取的字节数
        //int read(byte[] b, int off, int len)：指定byte[]数组的偏移量和最大填充数
        try (InputStream inputStream = new FileInputStream("src/input.txt")) {
            byte[] bytes = new byte[1024];
            int n;
            while ((n = inputStream.read(bytes)) != -1) {
                System.out.println("read " + n + " bytes");
            }
        }
        //阻塞：在调用InputStream的read()方法读取数据时，我们说read()方法是阻塞（Blocking）的。它的意思是，对于下面的代码：
        //int n;
        //n = input.read(); // 必须等待read()方法返回才能执行下一行代码
        //int m = n;

        //ByteArrayInputStream可以在内存中模拟一个InputStream
        byte[] date = { 72, 101, 108, 108, 111, 33 };
        try (InputStream inputStream = new ByteArrayInputStream(date)) {
            int n;
            while ((n = inputStream.read()) != -1) {
                System.out.println(n);
            }
        }

        //我们想从文件中读取所有字节，并转换成char然后拼成一个字符串，可以这么写：
        String str = null;
        try (InputStream inputStream = new FileInputStream("src/input.txt")) {
            str = readAsString(inputStream);
        }
        System.out.println(str);
    }
    public static String readAsString(InputStream inputStream) throws IOException {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = inputStream.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }
}
