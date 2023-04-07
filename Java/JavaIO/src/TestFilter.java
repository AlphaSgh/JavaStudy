import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * Java的IO标准库提供的InputStream根据来源可以包括：
 * FileInputStream：从文件读取数据，是最终数据源；
 * ServletInputStream：从HTTP请求读取数据，是最终数据源；
 * Socket.getInputStream()：从TCP连接读取数据，是最终数据源
 *
 * 如果我们要给FileInputStream添加缓冲功能，则可以从FileInputStream派生一个类：
 * BufferedFileInputStream extends FileInputStream
 * 如果要给FileInputStream添加计算签名的功能，类似的，也可以从FileInputStream派生一个类：
 * DigestFileInputStream extends FileInputStream
 * 如果要给FileInputStream添加加密/解密功能，还是可以从FileInputStream派生一个类：
 * CipherFileInputStream extends FileInputStream
 */
public class TestFilter {
    public static void test01() throws IOException {
//        InputStream file = new FileInputStream("src/input.gz");
//        InputStream buffer = new BufferedInputStream(file);
//        InputStream gzip = new GZIPInputStream(buffer);
        //无论我们包装多少次，得到的对象始终是InputStream，我们直接用InputStream来引用它，就可以正常读取：
        //上述这种通过一个“基础”组件再叠加各种“附加”功能组件的模式，称之为Filter模式（或者装饰器模式：Decorator）。

        byte[] data = "hello world".getBytes("UTF-8");
        try (CountStream input = new CountStream(new ByteArrayInputStream(data))) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println(n);
            }
            System.out.println("Total read " + input.getBytesRead() + " bytes");
        }
    }
}
//编写自己的FilterInputStream
//Java的IO标准库使用Filter模式为InputStream和OutputStream增加功能：
//可以把一个InputStream和任意个FilterInputStream组合；
//可以把一个OutputStream和任意个FilterOutputStream组合。
class CountStream extends FilterInputStream {
    private int count = 0;

    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected CountStream(InputStream in) {
        super(in);
    }
    public int getBytesRead() {
        return this.count;
    }
    public int read() throws IOException {
        int n = in.read();
        if (n != -1) {
            this.count ++;
        }
        return n;
    }
    public int read(byte[] b, int off, int len) throws IOException {
        int n = in.read(b, off, len);
        if (n != -1) {
            this.count += n;
        }
        return n;
    }
}