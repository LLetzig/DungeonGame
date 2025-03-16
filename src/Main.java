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

            int a = gl.setStage();
        System.out.println(a);
        System.out.println(player);
            ArrayList<Character> stage = gl.createStage(a);
            stage.forEach(System.out::println);
            gl.fightStage(stage, player);
            conti = gl.nextStage();






    }
}