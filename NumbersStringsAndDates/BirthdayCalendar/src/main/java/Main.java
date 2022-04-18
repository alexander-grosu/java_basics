import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static int age = 1;

    public static void main(String[] args) {

        int day = 24;
        int month = 0; // January
        int year = 1990;
        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        Calendar bDay = new GregorianCalendar(year, month, day);
        Calendar today = GregorianCalendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy EEE", Locale.ENGLISH);

        StringBuilder stringBuilder = new StringBuilder();
        while (bDay.getTime().before(today.getTime())) {
            stringBuilder.append("age: " + age).append(",  birth day: ").append(df.format(bDay.getTime())).append("\r\n");
            bDay.add(Calendar.YEAR, 1);
            age++;
        }
        return stringBuilder.toString();
    }
}


