import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            int spaceIndexOf = input.indexOf(" ");
            int spaceLastIndexOf = input.lastIndexOf(" ");
            int countSpaces = 0;
            for (int a = 0; a < input.length(); a++) {
                if (input.charAt(a) == ' ') {
                    countSpaces++;
                }
            }
            int countNumbers = 0;
            for (int b = 0; b < input.length(); b++) {
                char ch = input.charAt(b);
                if (!(Character.isLetter(ch) || ch == ' ' || ch == '-')) {
                    countNumbers++;
                }
            }
            if (countNumbers >= 1 || countSpaces != 2) {
                System.out.println("Введенная строка не является ФИО");
            } else {
                String surName = input.substring(0, spaceIndexOf);
                String name = input.substring(spaceIndexOf + 1, spaceLastIndexOf);
                String lastName = input.substring(spaceLastIndexOf + 1);
                System.out.println("Фамилия: " + surName);
                System.out.println("Имя: " + name);
                System.out.println("Отчество: " + lastName);
            }
        }
    }
}