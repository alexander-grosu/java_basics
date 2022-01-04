import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path folder1 = Paths.get("pom.xml");
        Path folder2 = Paths.get("D:\\Java_Home_Work\\java_basics\\05_ArraysAndCollections");
        Path folder3 = Paths.get("src/main/java");
        Path folder4 = Paths.get("src");
        Path folder5 = Paths.get("D:/Java HomeWorkNew/java_basics/11_FilesAndNetwork/files/map.json");
        Path folder6 = Paths.get("D:/Java HomeWorkNew/java_basics/11_FilesAndNetwork/files/movementList.csv");

        System.out.println("Folder '" + folder1.getFileName() + "' size: " + FileUtils
                .calculateFolderSize(folder1.toAbsolutePath().toString()) / 1024 + " kb");

        // System.out.println("Folder " + folder2.getFileName()+"' size: " + FileUtils
        //         .calculateFolderSize(folder2.toAbsolutePath().toString()) / 1024 + " kb");
        // System.out.println("Folder " + folder2.getFileName()+"' size: " + FileUtils
        //         .calculateFolderSize(folder2.toAbsolutePath().toString()) + " byte");

        System.out.println("Folder '" + folder3.getFileName() + "' size: " + FileUtils
                .calculateFolderSize(folder3.toAbsolutePath().toString()) / 1024 + " kb");

        System.out.println("Folder '" + folder4.getFileName() + "' size: " + FileUtils
                .calculateFolderSize(folder4.toAbsolutePath().toString()) / 1024 + " kb");
        System.out.println("Folder '" + folder5.getFileName() + "' size: " + FileUtils
                .calculateFolderSize(folder5.toAbsolutePath().toString()) / 1024 + " kb");
        System.out.println("Folder '" + folder6.getFileName() + "' size: " + FileUtils
                .calculateFolderSize(folder6.toAbsolutePath().toString()) / 1024 + " kb");

    }
}
