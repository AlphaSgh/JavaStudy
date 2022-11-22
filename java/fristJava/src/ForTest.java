import java.util.Arrays;

public class ForTest {
    public void forTest() {
        int[] ns = {1, 2, 3, 4, 5};
        for (int i = ns.length - 1; i >= 0; i--) {
            System.out.println(ns[i]);
        }
    }
    public void testArrayToString() {
        int[] ns = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(ns));
    }
    public void testBubble() {
        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 3};
        System.out.println("排序前：" + Arrays.toString(ns));
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] > ns[j+1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = tmp;
                }
            }
        }
        System.out.println("排序后：" + Arrays.toString(ns));
    }
    public void testDesc() {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println(Arrays.toString(ns));
        // TODO:
/*
TODO:1
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] < ns[j+1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = tmp;
                }
            }
        }
*/
/*
TODO:2
        for (int i = 0; i <= ns.length - 1; i++) {
            ns[i] *= -1;
        }
        Arrays.sort(ns);
        for (int i = 0; i <= ns.length - 1; i++) {
            ns[i] *= -1;
        }
*/
        // 排序后:
        System.out.println(Arrays.toString(ns));
        if (Arrays.toString(ns).equals("[96, 89, 73, 65, 50, 36, 28, 18, 12, 8]")) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }
    public void testAverage() {
        // 用二维数组表示的学生成绩:
        int[][] scores = {
                { 82, 90, 91 },
                { 68, 72, 64 },
                { 95, 91, 89 },
                { 67, 52, 60 },
                { 79, 81, 85 },
        };
        // TODO:
        double average = 0;
        int k = 0;

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                average += scores[i][j];
                k++;
            }
        }
        average = average / k;
        System.out.println(average);
        if (Math.abs(average - 77.733333) < 0.000001) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }
}
