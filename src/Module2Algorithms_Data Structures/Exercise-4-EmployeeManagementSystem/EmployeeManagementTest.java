public class EmployeeManagementTest {

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        system.addEmployee(new Employee(201, "Karthik", "Backend Developer", 68000.0));
        System.out.println();
        system.addEmployee(new Employee(202, "Lakshmi", "UI Designer", 52000.0));
        System.out.println();
        system.addEmployee(new Employee(203, "Ravi", "DevOps Engineer", 72000.0));
        System.out.println();
        system.addEmployee(new Employee(204, "Sneha", "Business Analyst", 85000.0));
        System.out.println();

        System.out.println("========= EMPLOYEE LIST =========");
        System.out.println();
        system.displayEmployees();
        System.out.println();
        System.out.println("=================================");
        System.out.println();

        System.out.println("Searching Employee : 202");
        System.out.println();
        Employee foundEmployee = system.searchEmployee(202);
        if (foundEmployee != null) {
            System.out.println("Employee Found");
            System.out.println();
            System.out.println(foundEmployee);
        } else {
            System.out.println("Employee Not Found.");
        }
        System.out.println();

        system.deleteEmployee(203);
        System.out.println();

        System.out.println("========= UPDATED LIST =========");
        System.out.println();
        system.displayEmployees();
        System.out.println();
        System.out.println("=================================");
        System.out.println();

        System.out.println("Searching Employee : 999");
        System.out.println();
        Employee notFoundEmployee = system.searchEmployee(999);
        if (notFoundEmployee != null) {
            System.out.println("Employee Found");
            System.out.println();
            System.out.println(notFoundEmployee);
        } else {
            System.out.println("Employee Not Found.");
        }
    }
}
