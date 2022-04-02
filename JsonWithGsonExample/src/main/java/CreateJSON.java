import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateJSON {

    public static @NotNull String createJson(List list, String path) throws IOException {

        FileWriter writer = new FileWriter(path);
        // GsonBuilder
        Gson gsonBuilder = new Gson().newBuilder().setPrettyPrinting().create();
        String jsonArray = gsonBuilder.toJson(list);
        String jsonObject = "{\n" + "\"cars\":" + jsonArray + "\n}";
        writer.write(jsonObject);
        writer.flush();

        return jsonObject;
    }
}
