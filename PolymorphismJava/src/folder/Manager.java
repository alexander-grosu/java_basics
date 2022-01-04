package folder;

public class Manager  implements Employee {
    private static final double salary = 70_000.0;
    private static final double Max = 140_000.0;
    private static final double Min = 115_000.0;
    private double income;
    private static final String status = "Manager";

    public Manager(){
        this.income = Math.random() * (Max - Min) + Min;
    }
    @Override
    public double getMonthSalary() {
        Company.setIncome(Company.getIncome() + income);
        return salary + income * 0.05;
    }
    @Override
    public String getStatus() {
        return status;
    }
}
