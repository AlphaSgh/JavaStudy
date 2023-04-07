import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TestDate {
    public static void test01() {
//        int n = 123400;
//        System.out.println(n);//123400
//        System.out.println(Integer.toHexString(n));//1e208
//        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));//$123,400.00
        //Epoch Time是计算从1970年1月1日零点（格林威治时区／GMT+00:00）到现在所经历的秒数
        //在计算机中，只需要存储一个整数1574208900表示某一时刻
        //Epoch Time又称为时间戳==>Java程序中，时间戳通常是用long表示的毫秒数
        Date date = new Date();
        //getYear()返回的年份必须加上1900，
        // getMonth()返回的月份是0~11分别表示1~12月，所以要加1，
        // 而getDate()返回的日期范围是1~31，又不能加1
        System.out.println(date.getYear() + 1900);//必须加上1900
        System.out.println(date.getMonth() + 1);//0-11，必须加上1
        System.out.println(date.getDate());//1-31，不能加1
        System.out.println(date.toString());
        System.out.println(date.toGMTString());
        System.out.println(date.toLocaleString());

        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));//2022-12-22 21:08:19

        sdf = new SimpleDateFormat("E MMM dd, yyyy");
        System.out.println(sdf.format(date));//周四 12月 22, 2022
    }
    public static void test02() {
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DAY_OF_MONTH);
        int w = c.get(Calendar.DAY_OF_WEEK);
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);

        //Calendar只有一种方式获取，即Calendar.getInstance()，而且一获取到就是当前时间。
        //如果我们想给它设置成特定的一个日期和时间，就必须先清除所有字段：
        Calendar c1 = Calendar.getInstance();
        c1.clear();// 清除所有:
        c1.set(Calendar.YEAR, 2019);// 设置2019年:
        c1.set(Calendar.MONTH, 8);// 设置9月:注意8表示9月:
        c1.set(Calendar.DATE, 2);// 设置2日:
        c1.set(Calendar.HOUR_OF_DAY, 21);// 设置时间:
        c1.set(Calendar.MINUTE, 22);
        c1.set(Calendar.SECOND, 23);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c1.getTime()));// 2019-09-02 21:22:23

        //利用Calendar.getTime()可以将一个Calendar对象转换成Date对象，然后就可以用SimpleDateFormat进行格式化了。
        Date date = c1.getTime();
    }
    public static void test03() {
        //利用Calendar进行时区转换的步骤是：
        //清除所有字段；
        //设定指定时区；
        //设定日期和时间；
        //创建SimpleDateFormat并设定目标时区；
        //格式化获取的Date对象（注意Date对象无时区信息，时区信息存储在SimpleDateFormat中）。
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(2022, 11, 22, 21, 15, 0);
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("American/New_York"));
        System.out.println(sdf.format(c.getTime()));

        //加减时间
        c.add(Calendar.MONTH, 5);//加5个月
        c.add(Calendar.DAY_OF_MONTH, 5);//加5天
        System.out.println(sdf.format(c.getTime()));
    }
}
