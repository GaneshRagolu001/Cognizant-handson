public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem() {
        this.employees = new Employee[100];
        this.count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count >= employees.length) {
            System.out.println("Array Full. Cannot add employee.");
            return;
        }
        employees[count] = employee;
        count++;
        System.out.println("Employee Added Successfully.");
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void displayEmployees() {
        if (count == 0) {
            System.out.println("No Employees Available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);

            if (i < count - 1) {
                System.out.println();
                System.out.println("--------------------------");
                System.out.println();
            }
        }
    }

    public void deleteEmployee(int employeeId) {
        int deleteIndex = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                deleteIndex = i;
                break;
            }
        }

        if (deleteIndex != -1) {
            for (int j = deleteIndex; j < count - 1; j++) {
                employees[j] = employees[j + 1];
            }
            employees[count - 1] = null;
            count--;
            System.out.println("Employee Deleted Successfully.");
        } else {
            System.out.println("Employee Not Found.");
        }
    }
}
