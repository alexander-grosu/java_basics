import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int boxesInContainer = 27;
        int containersInTruck = 10;
        int container = 1;
        int truck = 1;
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        if (Integer.parseInt(boxes) > 0) {
            System.out.println("Truck: " + truck);
            System.out.println("\t\tContainer: " + container);
            for (int i = 1; i <= Integer.parseInt(boxes); i++) {
                System.out.println("\t\t\t\tBox: " + i);
                if (i % (boxesInContainer * containersInTruck) == 0) {
                    truck += 1;
                    System.out.println("truck: " + truck);
                }
                if (i % boxesInContainer == 0) {
                    container++;
                    System.out.println("\t\t" + "container: " + container);
                }
            }
            System.out.println("truck count: " + truck + ", " + "container count: " + container + ", " + "box count: " + Integer.parseInt(boxes));
        } else {
            System.out.println("no boxes");
        }
    }
}