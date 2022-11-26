//公共逻辑适合放在abstract class中，具体逻辑放到各个子类，而接口层次代表抽象程度
//在接口中，可以定义default方法。例如，把Person接口的run()方法改为default方法：
//实现类可以不必覆写default方法。default方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。
// 如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
//default方法和抽象类的普通方法是有所不同的。因为interface没有字段，default方法无法访问字段，
// 而抽象类的普通方法可以访问实例字段。

//因为interface是一个纯抽象类，所以它不能定义实例字段。
// 但是，interface是可以有静态字段的，并且静态字段必须为final类型：
public interface Person {
    default void run() {
        System.out.println(getName() + "run");
    }
    String getName();
}
class Stu implements Person {
    String name;
    public Stu(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }
}
class Tea implements Person {
    String name;
    public Tea(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }
}