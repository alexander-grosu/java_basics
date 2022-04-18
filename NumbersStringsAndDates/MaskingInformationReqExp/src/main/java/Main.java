public class Main {
    public static void main(String[] args) {
        final String placeholder = "***";
        String passport;
        passport = "passport id <45 08 361>513";
        String pin;
        pin = "pin <6160>";
        String cardVisa;
        cardVisa = "Visa <2345> 4545 <6789> 0909";
        String cardMasterCard;
        cardMasterCard = "Mastercard <1234 5555 1234> 0484";

        System.out.println(searchAndReplaceDiamonds(cardVisa, placeholder));
        System.out.println(searchAndReplaceDiamonds(cardMasterCard, placeholder));
        System.out.println(searchAndReplaceDiamonds(passport, placeholder));
        System.out.println(searchAndReplaceDiamonds(pin, placeholder));
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        return text.replaceAll("<\\d.+?>", placeholder);
    }
}