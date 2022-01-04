import folder.*;
import org.jetbrains.annotations.NotNull;

public class Main {
    public static void main(String[] args) {
        try {
            Company Nike = new Company();
            Company SAMSUNG = new Company();

            // company Nike
            hireOneTopManager(Nike);
            hireOneManager(Nike);
            hireOneOperator(Nike);
            hireMoreTopManagers(Nike,9);
            hireMoreManagers(Nike,9);
            hireMoreOperators(Nike,9);
            System.out.print("\nCompany Nike");
            printTopSalaries(Nike);
            // dismiss 50%
            System.out.print("\nCompany Nike");
            fire50PercentEmployees(Nike);
            // print salaries
            System.out.print("\nCompany Nike");
            printTopSalaries(Nike);

            // company SAMSUNG
            hireMoreTopManagers(SAMSUNG,10);
            hireMoreManagers(SAMSUNG,80);
            hireMoreOperators(SAMSUNG,180);
            //print salaries
            System.out.print("\nCompany Samsung");
            printTopSalaries(SAMSUNG);
            //if managers count < ~ 69 -> Top Manager salary = 150K, else -> Top Manager salary = 225K
            System.out.print("\nCompany Samsung");
            printLowestSalaries(SAMSUNG);
            //fire 50% employee
            System.out.print("\nCompany Samsung");
            fire50PercentEmployees(SAMSUNG);
            //print salaries
            System.out.print("\nCompany Samsung");
            printTopSalaries(SAMSUNG);
            System.out.print("\nCompany Samsung");
            printLowestSalaries(SAMSUNG);
            System.out.println("\nCompany SAMSUNG");
            printAllEmployeesInDescendingSalaryOrder(SAMSUNG);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printLowestSalaries(@NotNull Company company) {
        System.out.println("\nEmployee Lowest Salaries: \n-------------------------");
        try {
            for (Employee e : company.getLowestSalaryStaff(15)) {
                System.out.println(e.getStatus() + " | " + Math.ceil(e.getMonthSalary()));
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    private static void printTopSalaries(@NotNull Company company) {
        System.out.println("\nEmployee Top Salaries: \n----------------------");

        try {
            for (Employee e : company.getTopSalaryStaff(15)) {
                System.out.println(e.getStatus() + " | " + Math.ceil(e.getMonthSalary()));
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    private static void printAllEmployeesInDescendingSalaryOrder(@NotNull Company company){
        System.out.println("All employees in descending salary order: \n-----------------------------------------");
        for (Employee e : company.getDescendingOrderSalary()){
            System.out.println(e.getStatus() + " | " + Math.ceil(e.getMonthSalary()));
        }
    }
    //   *************** fire/hire methods: ***************
    private static void fireOneEmployee(@NotNull Company company) {
        int i = company.getEmployees().size();
        if (i > 0) {
            company.fire(company.getEmployees().get(0));
        } else {
            System.out.println("Employee  not  found");
        }
    }
    private static void fire50PercentEmployees(@NotNull Company company) {
        System.out.print("\ndismiss 50 percent employees:");
        System.out.print("\nEmployee initial count: " + company.getEmployees().size());
        for (int i = 0; i < company.getEmployees().size(); i++) {
            //i++ size-- when i = 50%list.size(initial) -> (final)list.size = i
            company.fire(company.getEmployees().get(0));
        }
        System.out.println("\nEmployee count after dismiss: " + company.getEmployees().size());
    }
    private static void fireAllEmployee(@NotNull Company company) {
        company.fireAll();
    }
    private static void hireMoreTopManagers(Company company, int count){
        for (int i = 0; i< count; i++){
            hireOneTopManager(company);
        }
    }
    private static void hireMoreManagers(Company company, int count){
        for (int i = 0; i< count; i++){
            hireOneManager(company);
        }
    }
    private static void hireMoreOperators(Company company, int count){
        for (int i = 0; i< count; i++){
            hireOneOperator(company);
        }
    }
    private static void hireOneManager(@NotNull Company company) {
        Employee manager = new Manager();
        company.hire(manager);
    }
    private static void hireOneOperator(@NotNull Company company) {
        Employee operator = new Operator();
        company.hire(operator);
    }
    private static void hireOneTopManager(@NotNull Company company) {
        Employee topManager = new TopManager();
        company.hire(topManager);
    }
}
