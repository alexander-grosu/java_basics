import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String source;
        String destination;
        while (true) {
            System.out.println("write name of source folder/file"); // D:/folder1.txt or D:/folder2.txt (example)
            source = scanner.nextLine();
            if (Paths.get(source).toFile().isDirectory()
                    || Paths.get(source).toFile().isFile()) {
                System.out.println("write name of destination folder");
                destination = scanner.nextLine();
                if (Paths.get(destination).toFile().isFile()
                        || Paths.get(destination).toFile().isDirectory()) {
                    FileUtils.copyFolder(source, destination);
                }
            } else if (Pattern.compile("EXIT").matcher(destination).matches()) {
                System.out.println("program is finished");
                break;
            } else if (Pattern.compile("EXIT").matcher(source).matches()) {
                System.out.println("program is finished");
                break;
            } else {
                System.out.println("path of directory/file is incorrect");
            }
        }
    }
}
