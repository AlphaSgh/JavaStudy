import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * IO流是一种流式的数据输入/输出模型：
 * 二进制数据以byte为最小单位在InputStream/OutputStream中单向流动；
 * 字符数据以char为最小单位在Reader/Writer中单向流动。
 * Java标准库的java.io包提供了同步IO功能：
 * 字节流接口：InputStream/OutputStream；
 * 字符流接口：Reader/Writer。
 */
public class TestIO {
    public static void test01() {
        File file1 = new File("E:\\GITHUB\\JavaStudy\\java\\JavaIO\\src");
        System.out.println("file1 绝对路径：" + file1.getAbsolutePath());
        File file2 = new File("E:\\GITHUB\\JavaStudy\\java\\JavaIO\\src\\Main.java");
        System.out.println("file2 绝对路径：" + file2.getAbsolutePath());
        File file3 = new File(file1, "input.txt");
        System.out.println("file3 :" + file3.getAbsolutePath());

        System.out.println("file3 is " + file3);
        System.out.println("file3是否存在 : " + file3.exists());//文件是否存在
        System.out.println("file3 is directory : " + file3.isDirectory());
        System.out.println("file3 is file : " + file3.isFile());
        System.out.println("file3 length : " + file3.length());
        long time = file3.lastModified();
        Date date = new Date(time);
        System.out.println("file3 lastModified time is : " + date);
        file3.setLastModified(0);
        File file4 = new File("E:\\GITHUB\\JavaStudy\\java\\JavaIO\\src\\input.txt");
        file3.renameTo(file4);
        System.out.println("file3 rename file4");
        System.out.println("注意： 需要在E:\\GITHUB\\JavaStudy\\java\\JavaIO\\src确实存在一个lol.lol,\r\n才可以看到对应的文件长度、修改时间等信息");
    }
    public static void test02() {
        File file1 = new File("C:\\WINDOWS");
        File[] files = file1.listFiles();
        Map<String, Long> map = new HashMap<String, Long>();
        for (File f :
                files) {
            map.put(f.getAbsolutePath(), f.length());
        }
        Comparator<Map.Entry<String, Long>> valCom = new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return (int) (o1.getValue() - o2.getValue());
            }
        };
        List<Map.Entry<String, Long>> list = new ArrayList<Map.Entry<String, Long>>(map.entrySet());
        Collections.sort(list, valCom);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " : " + list.get(i).getValue());
        }
    }
    public static void test03() throws IOException {
        /**
         * 用File对象获取到一个文件时，还可以进一步判断文件的权限和大小：
         * boolean canRead()：是否可读；
         * boolean canWrite()：是否可写；
         * boolean canExecute()：是否可执行；
         * long length()：文件字节大小。
         * 可以通过createNewFile()创建一个新文件，用delete()删除该文件：
         * File对象提供了createTempFile()来创建一个临时文件，以及deleteOnExit()在JVM退出时自动删除该文件。
         */
/*
        File f = new File("..");
        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        System.out.println(f.canExecute());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
*/
        File f = new File("C:\\Windows");
        File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        File[] fs2 = f.listFiles(new FilenameFilter() { // 仅列出.exe文件
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe"); // 返回true表示接受该文件
            }
        });
        printFiles(fs2);
    }
    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
    /**
     * boolean mkdir()：创建当前File对象表示的目录；
     * boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
     * boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。
     */
    public static void test04() {
        Path p1 = Paths.get(".", "project", "study"); // 构造一个Path对象
        System.out.println(p1);
        Path p2 = p1.toAbsolutePath(); // 转换为绝对路径
        System.out.println(p2);
        Path p3 = p2.normalize(); // 转换为规范路径
        System.out.println(p3);
        File f = p3.toFile(); // 转换为File对象
        System.out.println(f);
        for (Path p : Paths.get("..").toAbsolutePath()) { // 可以直接遍历Path
            System.out.println("  " + p);
        }
    }
}
