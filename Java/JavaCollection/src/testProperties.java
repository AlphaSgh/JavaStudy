import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class testProperties {
    public static void test01() throws IOException {
        String file = "src/setting.properties";
        Properties properties = new Properties();
        properties.load(new java.io.FileInputStream(file));
        String filePath = properties.getProperty("last_open_file");
        String interval = properties.getProperty("auto_save_interval", "120");
        System.out.println(filePath);
        System.out.println(interval);
        properties.setProperty("url", "www.google.com");
        properties.store(new FileOutputStream(file),"注释");
    }
}
