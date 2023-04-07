package org.ssgh.pojo;

public class User {
    private String name;

    //IOC创建对象的方式
    //1.使用无参构造
    //2.使用有参构造
    public User() {
        System.out.println("User的无参构造");
    }
    public User(String name) {
        System.out.println("User的有参构造");
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show() {
        System.out.println("name = " + this.name);
    }
}
