import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String salary;
        salary = "John earned $55000, Max earned - $45700, Alex earned - $23000";
        System.out.println("Total sum: " + calculateSalarySum(salary) + " $.");
    }

    public static int calculateSalarySum(String text) {
        int sum = 0;
        Matcher m = Pattern.compile("\\d+").matcher(text);
        while (m.find()) {
            sum += Integer.parseInt(m.group());
        }
        return sum;
    }
}