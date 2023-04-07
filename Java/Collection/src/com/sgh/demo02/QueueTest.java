package com.sgh.demo02;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueTest {
    public static void main(String[] args) {
        //Queue方法 add() element() offer() peek() poll() remove()
        //Deque方法 addFirst() addLast() descendingIterator() 返回双端队列的迭代器，以逆向顺序迭代元素
        //Deque方法 getFirst() getLast() offerFirst() offerLast() peekFirst() peekLast()
        //Deque方法 pollFirst() pollLast() pop() push()
        testArrayDeque();
//        testDeque();
//        testPriorityQueue();
    }

    private static void testArrayDeque() {
        var stack = new ArrayDeque<>();
        stack.push("php");
        stack.push("java");
        stack.push("ccc");
        System.out.println(stack);//[ccc, java, php]
        System.out.println(stack.peek());//ccc
        System.out.println(stack);//[ccc, java, php]
        System.out.println(stack.pop());//ccc
        System.out.println(stack);//[java, php]

        ArrayDeque arrayDeque = new ArrayDeque<>();
        arrayDeque.offer("java");
        arrayDeque.offer("php");
        arrayDeque.offer("ccc");
        System.out.println(arrayDeque);//[java, php, ccc]
        System.out.println(arrayDeque.peek());//java
        System.out.println(arrayDeque);//[java, php, ccc]
        System.out.println(arrayDeque.poll());//java
        System.out.println(arrayDeque);//[php, ccc]
    }

    private static void testDeque() {

    }

    private static void testPriorityQueue() {
        PriorityQueue pq = new PriorityQueue<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o2) - ((Integer) o1);
            }
        });
        pq.offer(6);
        pq.offer(-3);
        pq.offer(30);
        pq.offer(20);
        System.out.println(pq);//[-3, 1, 3, 6]
        System.out.println(pq.poll());//-3
    }
}
