import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scnnr = new Scanner(System.in);
        System.out.println("введите команду или введите HELP:");
        String command = scnnr.nextLine();

        String searchBinary = "^SEARCH\\sBINARY\\s[А-Я]{1}[0-9]{3}[А-Я]{2}[0-9]{3}$";
        String searchLinear = "^SEARCH\\sLINEAR\\s[А-Я]{1}[0-9]{3}[А-Я]{2}[0-9]{3}$";
        String searchTreeSet = "^SEARCH\\sTREESET\\s[А-Я]{1}[0-9]{3}[А-Я]{2}[0-9]{3}$";
        String searchHashSet = "^SEARCH\\sHASHSET\\s[А-Я]{1}[0-9]{3}[А-Я]{2}[0-9]{3}$";
        String regexExit = "^EXIT$";
        String regexHelp = "^HELP$";
        String listRegEx = "^LIST$";

        while (true) {

            if (Pattern.compile(listRegEx).matcher(command).matches()) {
                CoolNumbers.listNumbers();
                command = scnnr.nextLine();

            } else if (Pattern.compile(regexHelp).matcher(command).matches()) {
                System.out.println(" SEARCH BINARY XNNNYZNNN -> бинарный поиск" +
                        "\n SEARCH LINEAR XNNNYZNNN -> линейный поиск" +
                        "\n SEARCH TREESET XNNNYZNNN -> поиск в ТрееСете" +
                        "\n SEARCH HASHSET XNNNYZNNN -> поиск в ХашСете" +
                        "\n LIST -> выводит ссписок номеров" +
                        "\n EXIT -> завершает работу программы" +
                        "\n HELP -> выводит список команд");

                command = scnnr.nextLine();

            } else if (Pattern.compile(searchBinary).matcher(command).matches()) {
                String number = command.replaceAll("SEARCH\\sBINARY\\s", "");
                ArrayList<String> arrList1 = new ArrayList<>();
                arrList1.addAll(CoolNumbers.generateCoolNumbers());
                CoolNumbers.binarySearchInList(arrList1, number);

                command = scnnr.nextLine();

            } else if (Pattern.compile(searchLinear).matcher(command).matches()) {
                String number = command.replaceAll("SEARCH\\sLINEAR\\s", "");
                ArrayList<String> arrList2 = new ArrayList<>();
                arrList2.addAll(CoolNumbers.generateCoolNumbers());
                CoolNumbers.bruteForceSearchInList(arrList2, number);

                command = scnnr.nextLine();

            } else if (Pattern.compile(searchHashSet).matcher(command).matches()) {
                String number = command.replaceAll("SEARCH\\sHASHSET\\s", "");
                HashSet<String> setHash = new HashSet<>();
                setHash.addAll(CoolNumbers.generateCoolNumbers());
                CoolNumbers.searchInHashSet(setHash, number);

                command = scnnr.nextLine();

            } else if (Pattern.compile(searchTreeSet).matcher(command).matches()) {
                String number = command.replaceAll("SEARCH\\sTREESET\\s", "");
                TreeSet<String> setTree = new TreeSet<>();
                setTree.addAll(CoolNumbers.generateCoolNumbers());
                CoolNumbers.searchInTreeSet(setTree, number);

                command = scnnr.nextLine();

            } else if (Pattern.compile(regexExit).matcher(command).matches()) {
                System.out.println("работа программы завершена");
                break;

            } else {
                System.out.println("команда введена некорректно");
                command = scnnr.nextLine();
            }

        }
    }
}