import java.io.*;
import java.nio.charset.StandardCharsets;

public class TestReaderWriter {
    public static void test01() throws IOException {
        try (Reader reader = new FileReader("src/output.txt", StandardCharsets.UTF_8)) {
            int n;
            while ((n = reader.read()) != -1) {
                System.out.println((char) n);
            }
        }
        try (Reader reader = new FileReader("src/output.txt", StandardCharsets.UTF_8)) {
            int n;
            char[] chars = new char[1000];
            while ((n = reader.read(chars)) != -1) {
                System.out.println("read " + n + "chars");
                System.out.println(new String(chars));
            }
        }
        try (Reader reader = new CharArrayReader("hello".toCharArray())) {
            //TODO:
        }
        try (Reader reader = new StringReader("hello")) {
            //TODO:

        }
        //Reader和InputStream有什么关系？
        //除了特殊的CharArrayReader和StringReader，普通的Reader实际上是基于InputStream构造的，
        //因为Reader需要从InputStream中读入字节流（byte），然后，根据编码设置，再转换为char就可以实现字符流。
        //如果我们已经有一个InputStream，想把它转换为Reader，是完全可行的。
        //InputStreamReader就是这样一个转换器，它可以把任何InputStream转换为Reader
        try (InputStream in = new FileInputStream("src/input.txt");
             Reader reader = new InputStreamReader(in, "UTF-8")) {
            //TODO:
        }
        try (Reader reader = new InputStreamReader(new FileInputStream("src/input.txt"), "UTF-8")) {
            // TODO:
        }


        try (Writer writer = new FileWriter("src/output.txt")) {
            writer.write('h');
            writer.write("hello".toCharArray());
            writer.write("hello");
        }
        try (CharArrayWriter writer = new CharArrayWriter()) {
            writer.write(65);
            writer.write(66);
            writer.write(67);
            char[] data = writer.toCharArray();
            System.out.println(new String(data));
        }
        try (StringWriter writer = new StringWriter()) {
            writer.write("hello");
        }
        try (OutputStream out = new FileOutputStream("src/output.txt");
             Writer writer = new OutputStreamWriter(out)) {

        }
    }
}
