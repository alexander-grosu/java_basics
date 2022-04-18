import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(^\\+?([7,8]{1})?(\\s?\\(?\\d{3}\\)?\\s|\\s\\d{3}\\s|\\(\\d{3}\\)|\\d{3}|\\-?\\d{3}\\-)(\\d{7}|\\d{3}\\-\\d{2}\\-\\d{2})$)";
        Matcher m = Pattern.compile(regex).matcher(input);
        if (m.matches() && input.replaceAll("\\D", "").length() == 11) {
            System.out.println(input.replaceAll("^[8]{1}", "7").replaceAll("\\D", ""));
        } else if (m.matches() && input.replaceAll("\\D", "").length() == 10) {
            System.out.println("7" + input.replaceAll("\\D", ""));
        } else {
            System.out.println("Неверный формат номера");
        }
    }
}



