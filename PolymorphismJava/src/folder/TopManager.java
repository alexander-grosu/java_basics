package folder;

public class TopManager implements Employee {
    private static final String status= "Top Manager";

    @Override
    public double getMonthSalary() {
        double salary = 150_000;
        if(Company.getIncome() >= 100_000_000){
             return salary * 1.5;
        }
        return salary;
    }
    @Override
    public String getStatus() {
        return status;
    }
}
