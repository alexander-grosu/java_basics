import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_COMMAND_ANSWER = "команда или адрес введен некорректо";
    public static String command;
    public static String e_mail;

    public static void main(String[] args) {
        EmailList emailListExemplar = new EmailList(); //EmailList class exemplar
        Scanner scanner = new Scanner(System.in);
        System.out.println("чтобы увидеть список команд введите HELP");
        command = scanner.nextLine();
        /*  регулярка "regexEmail" может вводить 3 формата e-mail
         *  1. abcdef@yandex.ru
         *  2. abcdef-abcdef@yandex.ru
         *  3. abcdef.abcdef@yandex.ru  */
        String regexEmail = "^ADD\\s(\\w+\\@\\w+\\.\\w+||\\w+\\-\\w+\\@\\w+\\.\\w+||\\w+\\.\\w+\\@\\w+\\.\\w+)$";
        String regexList = "^LIST$"; // list output command
        String regexExit = "^EXIT$"; // exit
        String regexHelp = "^HELP$"; // help
        String regexDelete = "^DELETE\\s+([A-Za-z]+||[A-Za-z]+\\-[A-Za-z]+||[A-Za-z]+\\.[A-Za-z]+)\\@[A-Za-z]+\\.[A-Za-z]+$";  //delete

        while (true) {

            if (Pattern.compile(regexEmail).matcher(command).matches()) {
                e_mail = command.replaceAll("^ADD\\s+", "");
                emailListExemplar.add(e_mail);
                command = scanner.nextLine();

            } else if (Pattern.compile(regexList).matcher(command).matches()) {
                emailListExemplar.printList();
                command = scanner.nextLine();

            } else if (Pattern.compile(regexExit).matcher(command).matches()) {
                System.out.println("работа программы завершена");
                break;

            } else if (Pattern.compile(regexHelp).matcher(command).matches()) {
                System.out.println(" ADD + (space) + email ->  добавляет новый e-mail " +
                        "\n LIST ->  выводит список адресов электронной почты" +
                        "\n DELETE + (space) + email ->  удаляет указанный e-mail " +
                        "\n HELP ->  выводит список команд " +
                        "\n EXIT ->  завершает работу программы ");
                command = scanner.nextLine();

            } else if (Pattern.compile(regexDelete).matcher(command).matches()) {
                e_mail = command.replaceAll("^DELETE\\s+", "").toLowerCase();
                emailListExemplar.delete(e_mail);
                command = scanner.nextLine();

            } else {
                System.out.println(WRONG_COMMAND_ANSWER);
                command = scanner.nextLine();
            }
        }
    }
}