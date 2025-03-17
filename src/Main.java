import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        boolean conti = true;
        DBM db = new DBM();
        db.createTables();

        Character player = new Warrior("Templato");
        GameLogic gl = new GameLogic();
//        Monster m = new Monster(2,4);
//        System.out.println(m);
//         m.dmgCalc();
//        System.out.println(m.dmg);
//        m.dmgCalc();
//        System.out.println(m.dmg);
//        m.dmgCalc();
//        System.out.println(m.dmg);
//        System.out.println(player.defCalc(m.dmg));
//        System.out.println(player.defCalc(m.dmg));
//        System.out.println(player.defCalc(m.dmg));
//        System.out.println(player.defCalc(m.dmg));
//        System.out.println(player.defCalc(m.dmg));
//        System.out.println(player.defCalc(m.dmg));


//
        player = gl.menu();
////
//            ArrayList<Character> stage = gl.createStage(gl.setStage());
//            gl.fightStage(stage, player);
//        boolean test = gl.nextStage();
//        System.out.println(test);







    }
}