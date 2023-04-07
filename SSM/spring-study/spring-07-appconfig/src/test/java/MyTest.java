import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.ssgh.config.SsghConfig;
import org.ssgh.pojo.User;

public class MyTest {
    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SsghConfig.class);
        User user = context.getBean("user", User.class);
        System.out.println(user.toString());
    }
}
