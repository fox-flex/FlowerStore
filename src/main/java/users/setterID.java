package users;

public class setterID {
    private static int id = 0;
    public static int getID() {
        return id++;
    }
}
