import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String regEx = "(^([А-Я]{1}[а-я]{1,}|[А-Я]{1}[а-я]{1,}\\-[А-Я]{1}[а-я]{1,})\\s+[А-Я]{1}[а-я]{1,}\\s+[А-Я]{1}[а-я]{1,}$)";
            Matcher m = Pattern.compile(regEx).matcher(input);
            if (m.matches()) {
                String[] words = input.split("\\s+");
                System.out.println("Фамилия: " + words[0]);
                System.out.println("Имя: " + words[1]);
                System.out.println("Отчество: " + words[2]);

            } else {
                System.out.println("Введенная строка не является ФИО");
            }

        }
    }
}
