public class Loops {
    public static void main(String[] args) {
        /* ASCII CODE, loops "for" */
        char ch;

        System.out.println("Latin Alphabet");
        for (ch = 'a'; ch <= 'z'; ch++) {
            int code = ch;
            System.out.print(ch + " - ASCII:" + code + ",  ");
        }
        System.out.println();
        for (ch = 'A'; ch <= 'Z'; ch++) {
            int code = ch;
            System.out.print(ch + " - ASCII:" + code + ",  ");
        }
        System.out.println();
        System.out.println("Russian Alphabet");
        for (ch = 'а'; ch <= 'я'; ch++) {
            int code = ch;
            System.out.print(ch + " - ASCII:" + code + ",  ");
        }
        System.out.println();
        for (ch = 'А'; ch <= 'Я'; ch++) {
            int code = ch;
            System.out.print(ch + " - ASCII:" + code + ",  ");
        }
        System.out.println();
        System.out.println("Greek Alphabet");
        for (ch = 'α'; ch <= 'ω'; ch++) {
            int code = ch;
            System.out.print(ch + " - ASCII:" + code + ",  ");
        }
        System.out.println();
        for (ch = 'Α'; ch <= 'Ω'; ch++) {
            int code = ch;
            System.out.print(ch + " - ASCII:" + code + ",  ");
        }
        System.out.println();
        System.out.println("Arabic numerals");
        for (ch = '0'; ch <= '9'; ch++) {
            int code = ch;
            System.out.print(ch + " - ASCII:" + code + ",  ");
        }
    }
}
