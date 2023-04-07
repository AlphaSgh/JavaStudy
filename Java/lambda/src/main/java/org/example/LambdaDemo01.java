package org.example;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class LambdaDemo01 {
    public static void main(String[] args) {
/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程run方法执行");
            }
        }).start();
        //接口且只有一个抽象方法，简化为lambda表达式，只关注方法参数列表和方法体
        new Thread(() -> System.out.println("新线程run方法被执行")).start();
*/
//        int i = calculateNum(new IntBinaryOperator() {
//            @Override
//            public int applyAsInt(int left, int right) {
//                return left + right;
//            }
//        });
//        System.out.println(i);
//
//        int b = calculateNum((int left, int right) -> {
//            return left + right;
//        });
//        System.out.println(b);
//        int c = calculateNum((left, right) -> left + right);//先写匿名内部类，alt+enter可以转换为lambda表达式

//        printNum(new IntPredicate() {
//            @Override
//            public boolean test(int value) {
//                return value % 2 == 0;
//            }
//        });

//        printNum(value -> value % 2 == 0);

//        printNum((int value) -> {return value % 2 == 0;});
//        int i = typeConver(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.valueOf(s);
//            }
//        });
//        System.out.println(i);
//        int ii = typeConver(s -> Integer.valueOf(s));
//        System.out.println(ii);
//
//        String str = typeConver(new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s + "sgh";
//            }
//        });
//        String strr = typeConver(s -> s + "sgh");
//        System.out.println(strr);

        foreachArr(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
        foreachArr(value -> System.out.println(value));
    }
    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
    public static void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }
    public static<R> R typeConver(Function<String, R> function) {
        String str = "1235";
        R result = function.apply(str);
        return result;
    }
    public static void foreachArr(IntConsumer consumer) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }
}
