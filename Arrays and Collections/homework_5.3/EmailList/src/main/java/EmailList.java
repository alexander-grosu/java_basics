import java.util.*;
import java.util.regex.Pattern;

public class EmailList {

    TreeSet<String> emailList = new TreeSet<>();

    public void add(String e_mail) {
        String regexEmail = "^([A-Za-z]+||[A-Za-z]+\\-[A-Za-z]+||[A-Za-z]+\\.[A-Za-z]+)\\@[A-Za-z]+\\.[A-Za-z]+$";
        if (Pattern.compile(regexEmail).matcher(e_mail).matches()) {
            if (emailList.contains(e_mail.toLowerCase())) {
                System.out.println("такой адрес уже есть в списке");
            } else {
                emailList.add(e_mail.toLowerCase());
                System.out.println("добавлен новый адрес " + e_mail.toLowerCase());
            }
        } else {
            System.out.println("адрес введен некорректно");
        }
    }

    public void delete(String e_mail) {
        if (emailList.isEmpty()) {
            System.out.println("список пуст! чтобы продлжить введите HELP");
        } else if (emailList.contains(e_mail)) {
            emailList.remove(e_mail);
            System.out.println("адрес электронной почты '" + e_mail + "' успешно удален");
        } else {
            System.out.println("указанный адрес электронной почты отсутствует в списке");
        }
    }

    public void printList() {
        if (emailList.isEmpty()) {
            System.out.println("список пуст! чтобы продолжить введите HELP");
        } else {
            emailList.forEach(emails -> System.out.println(emails));
        }
    }

    public List<String> getSortedEmails() {
        List<String> mainList = new ArrayList<String>();
        mainList.addAll(emailList);

        return mainList;
    }
}