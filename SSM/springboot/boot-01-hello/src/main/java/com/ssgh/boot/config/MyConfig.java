package com.ssgh.boot.config;

import com.ssgh.boot.bean.Pet;
import com.ssgh.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean("tom")
    public Pet tom() {
        return new  Pet("tom", 12);
    }
    @Bean("ssgh")
    public User user01() {
        return new User("ssgh", 15, tom());
    }
}
