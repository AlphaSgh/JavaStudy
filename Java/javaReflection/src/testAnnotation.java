/**
 * 特殊“注释”——注解（Annotation）。
 * 什么是注解（Annotation）？注解是放在Java源码的类、方法、字段、参数前的一种特殊“注释”：
 * 有一些注解可以修饰其他注解，这些注解就称为元注解（meta annotation）。
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


public class testAnnotation {
    @Check(min = 0, max = 100, value = 55)
    public int n;

}
