package hw1;

/**
 * Created by TonyXiao on 1/18/18.
 */

public class DatabaseManager {
    private static DatabaseManager instance = null;
    private DatabaseManager() {
        System.out.println("Instance Created");
    }
    public static DatabaseManager TheDatabaseManager() {
        if(instance == null)
            instance = new DatabaseManager();
        else
            System.out.println("Previously Created instance returned");

        return instance;
    }
}