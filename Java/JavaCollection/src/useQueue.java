import javax.print.MultiDocPrintService;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 把元素添加到队列末尾；
 * 从队列头部取出元素
 * int size()：获取队列长度；
 * boolean add(E)/boolean offer(E)：添加元素到队尾；
 * E remove()/E poll()：获取队首元素并从队列中删除；
 * E element()/E peek()：获取队首元素但并不从队列中删除。
 * 不要把null添加到队列中，否则poll()方法返回null时，很难确定是取到了null元素还是队列为空。
 * 添加、删除、获取两组函数，add remove element失败时抛出异常， offer poll peek返回false或true
 *
 * Java集合提供了接口Deque来实现一个双端队列，它的功能是：
 * 既可以添加到队尾，也可以添加到队首；
 * 既可以从队首获取，又可以从队尾获取。
 *                       Deque====>>>                              Queue====>>>
 * 添加元素到队尾          addLast(E e) / offerLast(E e)           add(E e) / offer(E e)
 * 取队首元素并删除        E removeFirst() / E pollFirst()          E remove() / E poll()
 * 取队首元素但不删除      E getFirst() / E peekFirst()              E element() / E peek()
 * 添加元素到队首         addFirst(E e) / offerFirst(E e)              无
 * 取队尾元素并删除     	E removeLast() / E pollLast()               无
 * 取队尾元素但不删除    	E getLast() / E peekLast()                  无
 */
public class useQueue {

    public static void test01() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("apple");
        queue.offer("pear");
        queue.offer("banner");
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        //// 这是一个List:
        //List<String> list = new LinkedList<>();
        //// 这是一个Queue:
        //Queue<String> queue = new LinkedList<>();
        Queue<User> userQueue = new PriorityQueue<>(new UserComparator());
        userQueue.offer(new User("Bob", "A10"));
        userQueue.offer(new User("Alice", "A2"));
        userQueue.offer(new User("Alice1", "A3"));
        userQueue.offer(new User("Boss", "V1"));
        System.out.println(userQueue.poll());
        System.out.println(userQueue.poll());
        System.out.println(userQueue.poll());
        System.out.println(userQueue.poll());
    }
}
class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        int num1 = Integer.parseInt(o1.number.substring(1));
        int num2 = Integer.parseInt(o2.number.substring(1));
        if (o1.number.charAt(0) == o2.number.charAt(0)) {
            return num1 < num2 ? -1 : 1;
        }
        if (o1.number.charAt(0) == 'V') {
            return -1;
        } else {
            return 1;
        }
    }
}
class User {
    public final String name;
    public final String number;
    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }
    public String toString() {
        return name + "/" + number;
    }
}