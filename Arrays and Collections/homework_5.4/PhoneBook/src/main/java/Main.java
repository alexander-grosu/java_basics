import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static String name;
    public static String number;
    public static String command;
    public static String regexName = "^(([А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,15}\\s[А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14}\\-[А-Я]{1}[а-я]{1,14}))$";
    public static final String regexNumber = "^[0-9]+$";
    public static final String getPhoneByName = "^GET\\s+(([А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,15}\\s[А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14}\\-[А-Я]{1}[а-я]{1,14}))$";
    public static final String getPhoneByNumber = "^GET\\s+[0-9]{11}$";
    public static final String listRegEx = "^LIST$";
    public static final String helpRegEx = "^HELP$";
    public static final String exitRegEx = "^EXIT$";

    public static void main(String[] args) {
        PhoneBook contacts = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите номер, имя или команду:");
        command = scanner.nextLine();

        while (true) {
            if (Pattern.compile(regexName).matcher(command).matches()) {
                name = command;
                if (contacts.mapPhone.containsValue(name)) {
                    System.out.println("абонент с именим '" + name + "' уже есть в контактах");
                    System.out.println("введите новый номер для абонента '" + name + "'");
                } else {
                    System.out.println("такого имени в телефонной книге нет");
                    System.out.println("введите номер для абонента '" + name + "'");
                }
                command = scanner.nextLine();
                if (Pattern.compile(regexNumber).matcher(command).matches()) {
                    number = command;
                    contacts.addContact(number, name);
                }
                System.out.println("введите номер, имя или команду:");
                command = scanner.nextLine();

            } else if (Pattern.compile(regexNumber).matcher(command).matches()) {
                number = command;
                if (contacts.mapPhone.containsKey(number)) {
                    System.out.println("абонент с номером '" + number + "' уже есть в контактах");
                    System.out.println("введите новое имя для контакта '" + contacts.mapPhone.get(number) + " - " + number + "'");
                } else {
                    System.out.println("такого номера в телефонной книге нет");
                    System.out.println("введите имя для номера '" + number + "'");
                }

                command = scanner.nextLine();
                if (Pattern.compile(regexName).matcher(command).matches()) {
                    name = command;
                    contacts.addContact(number, name);
                }
                System.out.println("введите номер, имя или команду:");
                command = scanner.nextLine();

            } else if (Pattern.compile(getPhoneByName).matcher(command).matches()) {
                name = command.replaceAll("^GET\\s+", "");
                contacts.getPhonesByName(name);
                System.out.println("введите номер, имя или команду:");
                command = scanner.nextLine();

            } else if (Pattern.compile(getPhoneByNumber).matcher(command).matches()) {
                number = command.replaceAll("^GET\\s+", "");
                contacts.getNameByPhone(number);
                System.out.println("введите номер, имя или команду:");
                command = scanner.nextLine();

            } else if (Pattern.compile(listRegEx).matcher(command).matches()) {
                contacts.getAllContacts();
                command = scanner.nextLine();

            } else if (Pattern.compile(helpRegEx).matcher(command).matches()) {
                System.out.println(" GET(space) + (name)  -> выводит контакт по имени" +
                        "\n GET(space) + (number)  -> выводит контакт по номеру" +
                        "\n LIST  -> выводит список контактов" +
                        "\n (number)/ответ + (name)  -> добавляет контакт" +
                        "\n (name)/ответ + (number)  -> добавляет контакт" +
                        "\n EXIT  -> завершение работы");
                command = scanner.nextLine();

            } else if (Pattern.compile(exitRegEx).matcher(command).matches()) {
                System.out.println("работа программы завершена");
                break;

            } else {
                System.out.println("неверный формат ввода");
                command = scanner.nextLine();
            }
        }
    }
}