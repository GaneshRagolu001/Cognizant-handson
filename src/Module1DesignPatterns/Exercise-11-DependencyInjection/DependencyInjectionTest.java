public class DependencyInjectionTest {

    public static void main(String[] args) {


        EmployeeRepository repository = new EmployeeRepositoryImpl();

        EmployeeService service = new EmployeeService(repository);

        int targetId = 101;
        String employeeName = service.getEmployeeName(targetId);

        if (employeeName != null) {
            System.out.println("Employee Found:");
            System.out.println("ID: " + targetId);
            System.out.println("Name: " + employeeName);
        } else {
            System.out.println("Employee with ID " + targetId + " not found.");
        }

        System.out.println();
        System.out.println("--- Testing with a non-existent employee ID ---");
        int testId = 999;
        String testEmployee = service.getEmployeeName(testId);
        if (testEmployee != null) {
            System.out.println("Employee Found:");
            System.out.println("ID: " + testId);
            System.out.println("Name: " + testEmployee);
        } else {
            System.out.println("Employee with ID " + testId + " not found in the repository.");
        }


    }
}
