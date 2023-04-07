## MyBatis
- 持久层框架
- maven仓库
## 持久层
- 数据持久化
  - 持久化就是将程序中的数据在持久状态和瞬时状态转化的过程
  - 内存：断电即失
  - 数据库持久化，io文件持久化
- Dao层 Service层 Controller层
## 搭建环境
- 搭建数据库
```mysql
CREATE DATABASE `mybatis`;
USE `mybatis`;
CREATE TABLE `user` (
	`id` INT(20) NOT NULL PRIMARY KEY,
	`name` VARCHAR(30) DEFAULT NULL,
	`pwd` VARCHAR(30) DEFAULT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `user` (`id`, `name`, `pwd`) VALUES
(1, 'sss', '123456'),
(2, 'ggg', '111111'),
(3, 'hhh', '222222')
```
- 创建project，导入依赖MySQL驱动，MyBatis，junit
## mysql驱动
```xml
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.30</version>
        </dependency>
```
## MyBatis
```xml
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.6</version>
        </dependency>
```
## 编写MyBatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--核心配置文件-->
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;character=Encoding=UTF-8&amp;serverTimezone=Asia/Shanghai"/>
        <property name="username" value="root"/>
        <property name="password" value="111111"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <!--每一个Mapper.xml都需要进行注册-->
    <mapper resource="com/ssgh/dao/UserMapper.xml"/>
  </mappers>
</configuration>
```
## 编写pojo/user
```java
public class User {
  private int id;
  private String name;
  private String pwd;
}
```
## 编写UserMapper Interface
```java
public interface UserMapper {
    public List<User> getUserList();
}
```
## 编写UserMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.ssgh.dao.UserMapper">
    <select id="getUserList" resultType="com.ssgh.pojo.User">
        select * from mybatis.user
    </select>
</mapper>
```
## 编写MyBatisUtils工具类获取 SqlSessionFactory再获取SqlSession
```java
public class MyBatisUtils {
  private static SqlSessionFactory sqlSessionFactory;
  static {
    try {
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static SqlSession getSqlSession() {
    return sqlSessionFactory.openSession();
  }
}
```
## 编写测试类 获取User
```java
    public void test01() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
```
- namespace中的包名必须要和Dao/mapper接口包名一致
- parameterType 参数类型 resultType 返回结果类型
- MyBatis中增删改需要进行提交事务，查询不需要
## 常见错误
- 标签不可以匹配出错
- resource文件mybatis-config.xml绑定mapper文件时必须使用/的文件路径
- 程序配置文件必须符合规范
- NullPointerException，没有注册到资源


