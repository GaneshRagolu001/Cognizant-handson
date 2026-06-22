public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public String findEmployeeById(int id) {
        if (id == 101) {
            return "Alice Smith";
        } else if (id == 102) {
            return "Bob Jones";
        } else if (id == 103) {
            return "Charlie Brown";
        }
        return null;
    }
}
