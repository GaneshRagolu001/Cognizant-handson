public class EmployeeService {
    private final EmployeeRepository repository;

    // Constructor injection
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public String getEmployeeName(int id) {
        return repository.findEmployeeById(id);
    }
}
