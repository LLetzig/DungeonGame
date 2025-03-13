import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBM db = new DBM();
        db.createTables();

        Character player = new Warrior("Templatio");
        GameLogic gl = new GameLogic();
        player = gl.menu();
        gl.c

    }
}