import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
@Slf4j
public class Main {
    public static void main(String[] args)  {
        Car car = new Car();
        car.addCars(5, "BMW", "540D", Color.BLACK);
        car.addCars(5, "Mercedes-Benz", "E500", Color.SILVER);
        car.addCars(5, "Audi", "A8", Color.WHITE);
        car.addCars(5, "Porsche", "911", Color.BLUE);
        car.addCars(5, "Aston Martin", "DBX", Color.GREEN);

        String path = "src/main/resources/jsonGson.json";
        List<Car> carsList = car.getCars();
        try {
            CreateJSON.createJson(carsList, path);
            log.info("Json file is created successful");
        } catch (IOException e) {
            log.error("I/O operation is failed or interrupted");
            e.printStackTrace();
        }
    }
}
