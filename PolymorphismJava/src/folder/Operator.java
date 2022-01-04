package folder;

public class Operator implements Employee {
    private static final double salary = 25_000;
    private static final String status = "Operator";

    @Override
    public double getMonthSalary() {
        return salary;
    }
    @Override
    public String getStatus() {
        return status;
    }
}
