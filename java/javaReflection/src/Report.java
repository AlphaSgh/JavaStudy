import java.lang.annotation.*;

/**
 * @Target
 * 最常用的元注解是@Target。使用@Target可以定义Annotation能够被应用于源码的哪些位置：
 *
 * 类或接口：ElementType.TYPE；
 * 字段：ElementType.FIELD；
 * 方法：ElementType.METHOD；
 * 构造方法：ElementType.CONSTRUCTOR；
 * 方法参数：ElementType.PARAMETER。
 * 例如，定义注解@Report可用在方法上，我们必须添加一个@Target(ElementType.METHOD)：
 */
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default  "";
}
/**
 * @Retention
 * 另一个重要的元注解@Retention定义了Annotation的生命周期：
 *
 * 仅编译期：RetentionPolicy.SOURCE；
 * 仅class文件：RetentionPolicy.CLASS；
 * 运行期：RetentionPolicy.RUNTIME。
 * 如果@Retention不存在，则该Annotation默认为CLASS。因为通常我们自定义的Annotation都是RUNTIME，
 * 所以，务必要加上@Retention(RetentionPolicy.RUNTIME)这个元注解：
 */
@Retention(RetentionPolicy.CLASS)
@interface Report1 {

}
/**
 * @Repeatable
 * 使用@Repeatable这个元注解可以定义Annotation是否可重复。这个注解应用不是特别广泛。
 */
@Repeatable(Reports3.class)
@Target(ElementType.TYPE)
public @interface Report2 {
    int type() default 0;
    String level() default "info";
    String value() default "";
}

@Target(ElementType.TYPE)
public @interface Reports3 {
    Report2[] value();
}