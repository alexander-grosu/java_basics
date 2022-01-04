import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassCastException {

        String fileHTML = parseFile("data/htmlCode.html");
        try {
            Document document = Jsoup.parse(fileHTML);
            Elements elements = document.select("img[src$=.jpg]");

            for (Element img : elements) {

                String image = img.attr("abs:src");
                String imageName = image.substring(image.lastIndexOf("/") + 1);
                System.out.println("image name: " + imageName);
                System.out.println("image link: " + image);
                System.out.println();

                BufferedImage bufferedImage = null;
                try {

                    URL url = new URL(image);
                    // read the url
                    bufferedImage = ImageIO.read(url);

                    String destinationFolder = "D:/images/" + imageName;

                    //for png
                    ImageIO.write(bufferedImage, "png", new File(destinationFolder));

                    // for jpg
                    ImageIO.write(bufferedImage, "jpg", new File(destinationFolder));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String parseFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));

            lines.forEach(line -> stringBuilder.append(line + "\n"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
