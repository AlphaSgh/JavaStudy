package org.ssgh.poji;

public class Hello {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
