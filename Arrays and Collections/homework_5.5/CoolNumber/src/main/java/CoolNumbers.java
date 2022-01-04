import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        long start = System.currentTimeMillis();
        String[] alphabet = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        Arrays.sort(alphabet);
        List<String> listCoolNumbers = new ArrayList<>();

        for (String x : alphabet) {
            for (int i = 111; i <= 999; i += 111) {
                String number = String.valueOf(i);
                for (String y : alphabet) {
                    for (String z : alphabet) {
                        for (int r = 1; r < 200; r++) {
                            String region;
                            String reg = String.valueOf(r);
                            boolean case1 = reg.matches("^[0-9]{1}$");
                            boolean case2 = reg.matches("^[0-9]{2}$");
                            if (case1) {
                                region = "00" + reg;
                            } else if (case2) {
                                region = "0" + reg;
                            } else {
                                region = reg;
                            }
                            String num = x + number + y + z + region;
                            listCoolNumbers.add(num);
                        }
                    }
                }
            }
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("generate numbers time: " + time + " millis");
        return listCoolNumbers;
    }

    public static void listNumbers() {
        List<String> listCoolNumbers = new ArrayList<>(generateCoolNumbers());
        for (String elements : listCoolNumbers) {
            System.out.println(elements);
        }
        System.out.println("list size = " + listCoolNumbers.size());
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long start = System.nanoTime();
        for (String element : list) {
            if (element.equals(number)) {
                System.out.println(number + " true");
                long time = System.nanoTime() - start;
                System.out.println("linear search time: " + time + " nanoseconds");
                return true;
            }
        }
        System.out.println(number + " false");
        long time = System.nanoTime() - start;
        System.out.println("linear search time: " + time + " nanoseconds");
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long start = System.nanoTime();
        int index = Collections.binarySearch(sortedList, number);
        if (index >= 0) {
            System.out.println(number + " true");
            long time = System.nanoTime() - start;
            System.out.println("binary search time: " + time + " nanoseconds");
            return true;
        }
        System.out.println(number + " false");
        long time = System.nanoTime() - start;
        System.out.println("binary search time: " + time + " nanoseconds");
        return false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long start = System.nanoTime();
        if (hashSet.contains(number)) {
            System.out.println(number + " true");
            long time = System.nanoTime() - start;
            System.out.println("in hashSet search time: " + time + " nanoseconds");
            return true;
        }
        System.out.println(number + " false");
        long time = System.nanoTime() - start;
        System.out.println("in hashSet search time: " + time + " nanoseconds");
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long start = System.nanoTime();
        if (treeSet.contains(number)) {
            System.out.println(number + " true");
            long time = System.nanoTime() - start;
            System.out.println("in treeSet search time: " + time + " nanoseconds");
            return true;
        }
        System.out.println(number + " false");
        long time = System.nanoTime() - start;
        System.out.println("in treeSet search time: " + time + " nanoseconds");
        return false;
    }
}