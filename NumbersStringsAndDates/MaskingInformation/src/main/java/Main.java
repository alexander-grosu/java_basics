public class Main {
    public static void main(String[] args) {
        String PLACEHOLDER = "***";
        String VisaCard = "Visa <4008 1234 5678> 8912";
        System.out.println(searchAndReplaceDiamonds(VisaCard, PLACEHOLDER));
    }
    public static String searchAndReplaceDiamonds(String text, String holder) {
        String result = text;
        int indexOpen = result.indexOf('<');
        int indexClose = result.indexOf('>');
        while (indexOpen > 0 && indexClose > 0) {
            result = result.substring(0, indexOpen) + holder + result.substring(indexClose + 1);
            indexOpen = result.indexOf('<');
            indexClose = result.indexOf('>');
        }
        return result;
    }
}