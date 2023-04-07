package org.ssgh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.ssgh.pojo.User;

//@Configuration代表这是一个配置类，就和我们之前的beans.xml相同
//@Configuration也会被Spring容器托管，注册到Spring容器中，因为他本来也就是一个@Component
@Configuration
@ComponentScan("org.ssgh.pojo")
@Import(SsghConfig2.class)
public class SsghConfig {

    //@Bean相当于我们之前写的xml中的bean标签注册一个bean
    //这个方法的名字相当于bean标签中的id属性
    //这个方法的返回值相当于bean标签中的class属性
    @Bean
    public User user() {
        return new User();
    }
}
