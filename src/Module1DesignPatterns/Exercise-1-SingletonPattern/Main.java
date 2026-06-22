package Module1DesignPatterns.Exercise1SingletonPattern;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        conn1.executeQuery("SELECT * FROM users");
        DatabaseConnection conn2 = DatabaseConnection.getInstance();
        conn2.executeQuery("SELECT * FROM products");

        if (conn1 == conn2) {
            System.out.println("Success: Both references point to the same DatabaseConnection instance.");
        } else {
            System.out.println("Failure: Different DatabaseConnection instances were created.");
        }
    }
}
