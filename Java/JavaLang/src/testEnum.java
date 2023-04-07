public class testEnum {
    public static void testEnum() {
        String enumName = WeekDay.SUN.name();
        int n = WeekDay.SUN.ordinal();
        WeekDay day = WeekDay.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("today is " + day + " work at home!");
        } else {
            System.out.println("today is " + day + " work at office!");
        }
        day = WeekDay.FRI;
        switch (day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("today is " + day + " work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("today is " + day + " work at home!");
                break;
            default:
                System.out.println("error");
        }
    }
}
enum WeekDay {
    SUN(0, "日"), MON(1, "一"), TUE(2, "二"), WED(3, "三"), THU(4, "四"), FRI(5, "五"), SAT(6, "六");
    public final int dayValue;
    public final String chinese;
    private WeekDay(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return "星期" + this.chinese;
    }
}
