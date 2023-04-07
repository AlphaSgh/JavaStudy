import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.ssgh.pojo.User;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //再配置文件加载的时候，容器中管理的对象就已经完成了初始化
        User user = (User) context.getBean("user");
        user.show();
    }
}
