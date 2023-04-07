package com.ssgh.boot;

import com.ssgh.boot.bean.Pet;
import com.ssgh.boot.bean.User;
import com.ssgh.boot.config.MyConfig;
import com.ssgh.boot.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        User user01 = run.getBean("ssgh", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println(user01);
        System.out.println(tom);
    }
}
