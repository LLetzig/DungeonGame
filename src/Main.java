import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

// dependencies needed
// ch.qos.logback.classic
//xerial.sqlite.jdbc

public class Main {
    public static void main(String[] args) {
        Character player = null;
        //Datenbank stuff
        DBM db = new DBM();
        db.createDir();
        db.createTables();
        //Spiellogik
        GameLogic gl = new GameLogic();
        player = gl.menu();
        int stageLvl = gl.setStage();
        ArrayList<Character> stageMonster = gl.createStage(stageLvl);
        gl.fightStage(stageMonster,player);






    }
}