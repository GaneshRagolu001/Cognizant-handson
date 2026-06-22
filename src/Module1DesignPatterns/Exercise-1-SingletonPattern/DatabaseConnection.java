package Module1DesignPatterns.Exercise1SingletonPattern;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        System.out.println("Database Connection Instance Created (Singleton Pattern).");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executing Query: " + query);
    }
}
