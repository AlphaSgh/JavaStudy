import java.io.*;

/**
 * 和InputStream类似，OutputStream也提供了close()方法关闭输出流，以便释放系统资源。
 * 要特别注意：OutputStream还提供了一个flush()方法，它的目的是将缓冲区的内容真正输出到目的地。
 */
public class TestOutputStream {
    public static void test01() throws IOException {
/*
        OutputStream output = new FileOutputStream("src/output.txt");
        output.write(72); // H
        output.write(101); // e
        output.write(108); // l
        output.write(108); // l
        output.write(111); // o
        output.close();
        //每次写入一个字节非常麻烦，更常见的方法是一次性写入若干字节。这时，可以用OutputStream提供的重载方法void write(byte[])来实现：
        output.write("\nhello01".getBytes("UTF-8"));
        output.close();
*/
        try (OutputStream outputStream = new FileOutputStream("src/output.txt")) {
            outputStream.write("\nhello02".getBytes("UTF-8"));
        }
    }
    public static void fileCopy() throws IOException{
        try (InputStream input = new FileInputStream("src/input.txt");
             OutputStream output = new FileOutputStream("src/output.txt")) {
//            int n;
//            while ((n = input.read()) != -1) {
//                output.write(n);
//            }
            input.transferTo(output);//从输入流复制到输出流
        }
    }
}
