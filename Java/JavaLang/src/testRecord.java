public class testRecord {
    public static void testRecord() {
        Point point = new Point(2, 4);
        point = Point.of(1, 4);
        System.out.println(point.x());
        System.out.println(point.y());
        System.out.println(point);
    }
}
/*final class Point { //final修饰的不变类
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int x() {
        return this.x;
    }
    public int y() {
        return this.y;
    }
}*/

record Point(int x, int y) {

    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }
    public static Point of() {
        return new Point(0, 0);
    }
    public static Point of(int x, int y) {
        return new Point(x, y);
    }
} //等价于上面的不变类Point
