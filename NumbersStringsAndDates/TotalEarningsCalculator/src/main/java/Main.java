public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        int a = text.indexOf('5');
        int b = a + 4;
        String num1 = text.substring(a, b);

        int c = text.indexOf('7');
        int d = c + 4;
        String num2 = text.substring(c, d);

        int e = text.lastIndexOf('3');
        int f = text.lastIndexOf('0') + 1;  // or int f = e + 5;
        String num3 = text.substring(e, f);

        int totalSum = Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3);

        System.out.println(totalSum);
    }
}