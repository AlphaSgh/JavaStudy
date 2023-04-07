## 注解说明
- 在xml中引入约束，并通过<<context:annotation-config/>>开启注解约束
- @Autowired：自动装配通过类型，名字，如果名字不唯一则需要通过@Qualifier(value = "xxx")指定
- @Nullable：字段标记了这个注解表明字段可以为空
- @Resource：自动装配通过名字，类型

## 使用注解开发
- 在spring4之后，使用注解开发必须保证aop的包导入了
- 使用注解需要导入context约束，开启注解约束
-----------------
- @Component，组件，放在类上，说明这个类被Spring管理了，就是bean
- bean
- 属性如何注入
```java
  @Component
  public class User {
    @Value("ssgh") //等价于<property name="name" value="ssgh"/>
    public String name;
    }
 ```
- 衍生的注解
  - @Component的衍生注解，在web开发中会按照mvc三层架构分层
  - dao @Repository
  - service @Service
  - controller @Controller
  - 这四个注解的功能是一样的，都代表将某个类注册到Spring中，装配Bean
- 自动装配
  - @Component
  - @Value
- 作用域
  - @Scope(value = "singleton")放在类上单例模式注解
  - @Scope(value = "prototype")原型注解
- xml与注解
  - xml注解更加万能，适用于任何场景，维护相对简单
  - 注解不是自己的类是用不了，维护相对复杂
  - xml与注解最佳实践，注解只完成属性的注入

---
## 使用java的方式配置Spring
- 完全使用Java的方式配置Spring，完全不使用xml
- JavaConfig是Spring的一个子项目，在Spring4之后，它成为一个核心功能

## 代理模式
- 为什么学习代理模式？因为这是SpringAOP的底层
- 代理模式的分类
  - 静态代理
  - 动态代理
## 静态代理
- 角色分析: 
  - 抽象角色：一般会使用接口或者抽象类解决
  - 真实角色：被代理的角色
  - 代理角色：代理真实角色，代理真实角色后一般会做一些附属操作
  - 客户：访问代理对象的人
- 代码步骤
  - 1.接口
```java
//租房
public interface Rent {
    public void rent();
}

```
  - 2.真实角色
```java
//房东
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
```
  - 3.代理角色
```java
public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
        seeHouse();
        fare();
    }
    public void seeHouse() {
        System.out.println("看房");
    }
    public void fare() {
        System.out.println("收中介费");
    }
}

```
  - 4.客户端访问代理角色
```java
public class Client {
    public static void main(String[] args) {
        //房东租房子
        Host host = new Host();
        //代理，中介帮房东租房子，代理角色一般会添加附属操作
        Proxy proxy = new Proxy(host);
        //找代理进行租房
        proxy.rent();
    }
}
```
## 代理模式的好处
- 可以使真实角色的操作更加纯粹！不用去关注一些公共的业务
- 公共业务交给代理角色，实现业务的分工
- 公共业务发生扩展的时候，方便集中管理
- 缺点：一个真实角色就会产生一个代理角色，代码量翻倍开发效率变低

## 动态代理
- 动态代理和静态代理角色一样
- 动态代理类使动态生成的，不是我们直接写好的
- 动态代理分为两大类：基于接口的动态代理，基于类的动态代理
  - 基于接口的动态代理---jdk动态代理
  - 基于类的动态代理---cglib
  - java字节码实现---Javasist
- 需要了解两个类 InvocationHandler Proxy
  - Proxy生成动态代理实例
  - InvocationHandler调用处理程序，处理结果
- 动态代理的好处
  - 一个动态代理代理的使一类业务，代理多个类，只要实现了一个接口即可
## 使用Spring实现AOP
- 方式一：使用Spring的API接口（主要是SpringAPI接口实现）
- 方式二：自定义切面类实现AOP（主要是切面定义）
- 方式三：使用注解实现