import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ClassCastException {

        Map<String, String> valuesStations = new LinkedHashMap<>();
        Map<String, String> valuesLines = new LinkedHashMap<>();
        Map<String, String[]> lineStation = new LinkedHashMap<>();
        Path destinationJSONObject = Paths
                .get("D:/JSON/JSONObject.json");

        //parse HTML
        String fileHTML =
                parseFile("D:/JSON/metro.html");
        try {
            Document document = Jsoup.parse(fileHTML);
            //select lines
            Elements lines = document.getElementsByClass("js-metro-line");
            //select stations
            Elements stationsAndNumLine = document.getElementsByClass("name");

            //add subway lines from html to LinkedHashMap
            for (Element elementLine : lines) {
                String[] keyValLineArray = String.valueOf(elementLine).split("\\s", 7);
                String keyValLine = keyValLineArray[4].concat(" ").concat(keyValLineArray[6])
                        .replaceAll("</span>", "")
                        .replaceAll("\"", "")
                        .replaceAll("ln-", "")
                        .trim();
                String[] keyValColumns = keyValLine.split("\\s", 2);
                String numLine = keyValColumns[0];
                String nameLine = keyValColumns[1];
                valuesLines.put(numLine, nameLine);
            }

            //add subway stations from html to LinkedHashMap
            for (Element element : stationsAndNumLine) {
                Elements elementsStationLine = element.getElementsByTag("a");
                for (Element element1 : elementsStationLine) {
                    String[] keyValArray = String.valueOf(element1).split("\\s", 6);
                    String keyVal = keyValArray[4].concat(" ").concat(keyValArray[5])
                            .replaceAll("data-id=", "")
                            .replaceAll("\"\\s\"\\d+\"", "")
                            .replaceAll(">", " ")
                            .replaceAll("ln-", "")
                            .replaceAll("</a", "")
                            .trim();
                    String[] putKeyVal = keyVal.split("\\s", 2);
                    String kNumLine = putKeyVal[0];
                    String nameStation = putKeyVal[1];

                    String putGroup = "";
                    if (valuesStations.get(kNumLine) != null) {
                        putGroup = valuesStations.get(kNumLine).concat(",").concat(nameStation);
                        valuesStations.put(kNumLine, putGroup);
                    } else {
                        valuesStations.put(kNumLine, nameStation);
                    }
                }
            }

            //add lines and stations to Map
            Set<String> keys = valuesLines.keySet();
            for (String key : keys) {
                String newKey = valuesLines.get(key);
                String[] newValue = valuesStations.get(key).split(",");
                lineStation.put(newKey, newValue);
            }

            //OutPut
            for (Map.Entry<String, String[]> entry : lineStation.entrySet()) {
                //stations count on the line
                int size = entry.getValue().length;
                String v = Arrays.toString(entry.getValue())
                        .replaceAll("\\]", "")
                        .replaceAll("\\[", "");
                System.out.println("\n" + entry.getKey() + " \nstation count: " + size + "\nstations:  " + v);
            }

            //convert LinkedHashMap to JSONObject and write to file
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("Moscow subway",lineStation);
            String jsonObjectMetro = jsonObject.toString(jsonObject.length());
            Files.writeString(destinationJSONObject,jsonObjectMetro);


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



