package org.ssgh.pojo;

public class UserT {
    private String name;
    public UserT() {
        System.out.println("UserT被创建");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
