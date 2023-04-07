package org.ssgh.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component  等价于<property name="name" value="ssgh"/>
@Component
@Scope(value = "singleton")
public class User {
    @Value("ssgh") //等价于<property name="name" value="ssgh"/>
    public String name;
}
