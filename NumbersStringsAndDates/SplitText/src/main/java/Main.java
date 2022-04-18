public class Main {

    public static void main(String[] args) {
        String text = "The Aston Martin DB11 is a grand tourer[2] produced by British luxury car manufacturer Aston Martin since 2016. It debuted at the Geneva Motor Show in March 2016 as a replacement to the DB9.[3] It is the first model launched in Aston Martin's 'second century' plan and the first car launched since the company's tie-up with Daimler AG.";
        System.out.println(splitTextInToWords(text));
    }

    public static String splitTextInToWords(String text) {
        return text.replaceAll("[^a-zA-Z\\s\\-\\’]", "").replaceAll("\\-", "\n").replaceAll("\\s+", "\n");
    }
}