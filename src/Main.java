import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        boolean conti = true;
        DBM db = new DBM();
        db.createTables();

        Character player = new Warrior("Templatio");
        GameLogic gl = new GameLogic();
        while (true){
            player = gl.menu();
        while (!conti) {
            ArrayList<Character> stage = gl.createStage(gl.setStage());
            gl.fightStage(stage, player);
            conti = gl.nextStage();
        }
    }




    }
}