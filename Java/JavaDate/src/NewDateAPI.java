import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class NewDateAPI {
    public static void test01() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);

        LocalDateTime dateTime1 = LocalDateTime.now();
        LocalDate date1 = dateTime1.toLocalDate();
        LocalTime time1 = dateTime1.toLocalTime();
        System.out.println(dateTime1);
        System.out.println(date1);
        System.out.println(time1);

        LocalDate date2 = LocalDate.of(2022, 12, 24);
        LocalTime time2 = LocalTime.of(20, 31, 27);
        LocalDateTime dateTime2 = LocalDateTime.of(2022, 12, 24, 20, 31, 27);
        LocalDateTime dateTime3 = LocalDateTime.of(date2, time2);
        System.out.println(dateTime2 + " " + dateTime3);

        LocalDate date3 = LocalDate.parse("2022-12-24");
        LocalTime time3 = LocalTime.parse("20:31:21");
        LocalDateTime dateTime4 = LocalDateTime.parse("2022-12-24T20:31:21");

        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 用自定义格式解析:
        LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dt2);
    }
    public static void test02() {
        LocalDateTime dateTime = LocalDateTime.of(2022, 12, 25, 21, 21, 21);
        System.out.println(dateTime);
        LocalDateTime dateTime1 = dateTime.plusDays(5).minusHours(5);
        System.out.println(dateTime1);
        LocalDateTime dateTime2 = dateTime.minusDays(5);
        System.out.println(dateTime2);

        LocalDateTime dateTime3 = dateTime.withDayOfMonth(31).withYear(2023);
        System.out.println(dateTime3);
        System.out.println("=============");
        //本月第一天0：00
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);
        //最后一天
        LocalDate lastDate = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDate);
        //下月第一天
        LocalDate nextFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextFirstDay);
        //本月第一个周一
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);
        //xx月第一个周x
        LocalDate firstWeekdayOfMonth = LocalDate.of(2022, 1, 25).with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
        System.out.println(firstWeekdayOfMonth);//2022年1月地一个周日

        //比较时间前后
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.of(2022, 12, 25, 21, 21, 21);
        System.out.println(now.isBefore(target));
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 12, 25)));
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2023, 1, 1)));

        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2022, 1, 4, 19, 25, 31);
        Duration d = Duration.between(start, end);
        System.out.println(d);

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2022, 1, 9));
        System.out.println(p);
        //创建时间间隔
        Duration d1 = Duration.ofHours(10);
        Duration d2 = Duration.parse("P10DT2H3M");
    }
    public static void test03() {
        ZonedDateTime zdt1 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zdt1);
        System.out.println(zdt2);

        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt3 = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zdt4 = ldt.atZone(ZoneId.of("America/New_York"));
        System.out.println(zdt3);
        System.out.println(zdt4);

        //时区转换
        //获取中国时区时间
        ZonedDateTime from = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        //转换为纽约时间
        ZonedDateTime to = from.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(from);
        System.out.println(to);

    }
    public static void test04() {
        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
        int hours = 13;
        int minutes = 20;
        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
        // test:
        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        }
    }
    public static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
        ZonedDateTime start = bj.atZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime end = start.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime end1 = end.plusHours(h).plusMinutes(m);
        return end1.toLocalDateTime();
    }
    public static void test05() {
        ZonedDateTime zdt = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss ZZZZ");
        System.out.println(formatter.format(zdt));

        var zhFormatter = DateTimeFormatter.ofPattern("yyyy MM dd EE HH:mm:ss", Locale.CHINA);
        System.out.println(zhFormatter.format(zdt));

        var usFormatter = DateTimeFormatter.ofPattern("E, MMM/dd/yyyy HH:mm:ss", Locale.US);
        System.out.println(usFormatter.format(zdt));
    }
    public static void test06() {
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond());//秒
        System.out.println(now.toEpochMilli());//毫秒

        Instant ins = Instant.ofEpochMilli(1672816696490L);
        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
        System.out.println(zdt);
    }
}
