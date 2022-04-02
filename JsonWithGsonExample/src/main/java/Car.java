import java.util.ArrayList;
import java.util.List;

public class Car {
    private static List<Car> cars = new ArrayList<>(); // !private static
    private long id = 0;
    private String make;
    private String model;
    private Color color;

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public Car() {
    }

    public List<Car> addCars(int count, String make, String model, Color color) {
        for (int i = 0; i < count; i++) {
            Car car = new Car(make, model, color);
            car.setId(id += 1);
            cars.add(car);
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
