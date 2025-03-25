import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

public class GameLogic {
    // für datenbank
    DBM db = new DBM();
    //gui :)
    String splash = """
            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
            █                                                                               █
            █   ██████╗ ██╗   ██╗███╗   ██╗ ██████╗ ███████╗ ██████╗ ███╗   ██╗             █
            █   ██╔══██╗██║   ██║████╗  ██║██╔════╝ ██╔════╝██╔═══██╗████╗  ██║             █
            █   ██║  ██║██║   ██║██╔██╗ ██║██║  ███╗█████╗  ██║   ██║██╔██╗ ██║             █
            █   ██║  ██║██║   ██║██║╚██╗██║██║   ██║██╔══╝  ██║   ██║██║╚██╗██║             █
            █   ██████╔╝╚██████╔╝██║ ╚████║╚██████╔╝███████╗╚██████╔╝██║ ╚████║             █
            █   ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═══╝             █
            █                                                                               █
            █   ██████╗ ███████╗██╗     ██╗   ██╗███████╗██████╗                            █
            █   ██╔══██╗██╔════╝██║     ██║   ██║██╔════╝██╔══██╗                           █
            █   ██║  ██║█████╗  ██║     ██║   ██║█████╗  ██████╔╝                           █
            █   ██║  ██║██╔══╝  ██║     ╚██╗ ██╔╝██╔══╝  ██╔══██╗                           █
            █   ██████╔╝███████╗███████╗ ╚████╔╝ ███████╗██║  ██║                           █
            █   ╚═════╝ ╚══════╝╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝                           █
            █                                                                               █
            █                                                                               █
            █                          Choose an option:                                    █
            █                          [1]new game                                          █
            █                          [2]continue                                          █
            █                          [3]Exit                                              █
            █                                                                               █
            ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
            """;
    String stage = """                  
                                        Choose dungeon depth
            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
            █                                                                               █
            █                           Stage[1] : easy encounters                          █
            █                                                                               █
            █                           Stage[2] : easy to medium encounters                █
            █                                                                               █
            █                           Stage[3] : medium encounters                        █
            █                                                                               █
            █                           Stage[4] : hard encounters                          █
            █                                                                               █
            █                           Stage[5] : don't                                    █
            █                                                                               █
            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
            """;
    static String theCharGang = """
                                        Choose your Fighter
            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
            █                                                                               █
            █            Mage                    Rogue                  Warrior             █
            █                                                                               █
            █         -reads books             -knife nerd           -smooth brained        █
            █           all day                                                             █
            █         + life drain              +knife nerd           + too dumb            █
            █                                                          to feel pain         █
            █                                                                               █
            █             [1]                      [2]                      [3]             █
            █                                                                               █
            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
            """;

    /**
     * es ist ein menü ...
     *
     * @return neuer oder datenbank char
     */
    public Character menu() {
        Character player = new Warrior("menu man");
        int value = 0;
        System.out.println(splash);
        Scanner sc = new Scanner(System.in);
        while (value < 1 || value > 3) {
            value = sc.nextInt();
        }
        sc.nextLine();

        while (true) {
            if (value == 1) {
                String name = GameLogic.chooseName();
                player = GameLogic.chooseChar(name);
                System.out.println(player);
                break;
            } else if (value == 2) {

                DBM.showAllSaves();
                int[] choice = DBM.computeChoice();
                 player = DBM.getSaveByChoice(choice);
                break;
            } else if (value == 3) {
                System.out.println("bye");
                break;
            } else {
                System.out.println("1,2 oder 3");

            }

        }
        return player;
    }

    /**
     * @return gewählter name
     */
    public static String chooseName() {
        String auswahl = "";
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter name:");
        if (scn.hasNextLine()) {
            auswahl = scn.nextLine();
        }
        return auswahl;
    }

    /**
     * @param name kommt von chooseName()
     * @return gewähltes klassenobjekt für (player)
     */
    public static Character chooseChar(String name) {
        Scanner sc = new Scanner(System.in);
        int cl;
        System.out.println(theCharGang);
        Character p = new Warrior("ULF");
        System.out.println("Choose your class");
        do {
            cl = sc.nextInt();
            switch (cl) {
                case 1 -> p = new Mage(name);
                case 2 -> p = new Rogue(name);
                case 3 -> p = new Warrior(name);
                default -> System.out.println("Wrong");
            }
        } while (cl < 1 || cl > 3);
        return p;
    }

    /**
     * lässt dungeon lvl wählen
     *
     * @return dungeon lvl -> geht nach createStage()
     */
    public int setStage() {
        Scanner sc = new Scanner(System.in);
        int stageLvl = 0;
        while (stageLvl < 1 || stageLvl > 5) {
            System.out.println(stage);
            stageLvl = sc.nextInt();
        }
        return stageLvl;
    }

    /**
     * kreiert eine Liste von gegnern angepasst an das dungeon lvl (parameter von setStage() wird übergeben
     */

    public ArrayList<Character> createStage(int stageLvl) {
        int rarity = 0;
        int mLvl = 1;
        switch (stageLvl) {
            case 1 -> {
                rarity = 1;
                mLvl = (int) Math.round(Math.random() + 1);
            }
            case 2 -> {
                rarity = (Math.random() * 2) < 1 ? 1 : 2;
                mLvl = (int) Math.round((Math.random() * 2) + 1);
            }
            case 3 -> {
                rarity = 2;
                mLvl = (int) Math.round(Math.random() + 2);
            }
            case 4 -> {
                rarity = (Math.random() * 3) < 2 ? 2 : 3;
                mLvl = (int) Math.round((Math.random() * 2) + 2);
            }
            case 5 -> {
                rarity = 3;
                mLvl = 8;
            }

        }

        return new ArrayList<>(Arrays.asList(new Monster(rarity, mLvl),
                new Monster(rarity, mLvl),
                new Monster(rarity, mLvl)));
    }

    /**
     * bestimmen der richtigen klasse, um Spielstand in db zu schreiben
     */

    public void saveChar(Character player) {
        DBM dbm = new DBM();
        switch (player.getClass().getSimpleName()) {
            case "Mage" -> dbm.insertMage((Mage) player);
            case "Warrior" -> dbm.insertWarrior((Warrior) player);
            case "Rogue" -> dbm.insertRogue((Rogue) player);
        }
    }


    /**
     * @param stage  Arrayliste mit gegnern generiert aus createStage()
     * @param player Spielercharakter
     */
    public void fightStage(ArrayList<Character> stage, Character player) {
        //Spielstand wird am start gespeichert
        saveChar(player);
        boolean hasNext = true;
        int letzterIndex = stage.size() - 1;
        int counter = 0;
        for (Character m : stage) {
            //counter für textausgabe für letzten besiegten gegner und weiterführende logik nach Beenden der Stage
            if (counter == letzterIndex) {
                hasNext = false;
            }
            counter++;
            String mdmg;
            String pdmg;
            // dmg ist eingangs auf 0 oder noch nicht an lvlup angepasst
            m.dmgCalc();
            player.dmgCalc();
            //Todo monsterspezifischer String?
            System.out.println(m.name + " lvl " + m.lvl + " is blocking your Path");
            //TODO in eigene Methode auslagern um code dopplung zu vermeiden

            if (player.getInitiative() < m.getInitiative()) {
                calcIni(m,player);
            } else {
                calcIni(player,m);
            }
            if (m.currentHealth <= 0) {
                //exp für sieg und lvlup check
                ((Monster) m).giveEXP(player);
                System.out.println("you gained xp and  now have: " + player.getCurrentExp() + "/"+ player.maxExp +" exp");
                if (player.currentExp >= player.maxExp) {
                    player.onLvlUp();
                    System.out.println("You leveled up to lvl " + player.getLvl() );
                }
                //ist letzter Gegner?
                if (!hasNext) {
                    player.currentHealth = player.maxHealth;
                    System.out.println("You have slain " + m.name + " . \n All monsters on this stage have been defeated");
                   //Abfrage, ob weitere Stage
                    boolean next = nextStage();
                    if (next) {
                        stage = createStage(setStage());
                        fightStage(stage, player);
                    }else{
                        menu();
                    }
                } else {
                    System.out.println("You have slain " + m.name + " and proceed your journey through the dungeon");
                }
            } else if (player.currentHealth <= 0) {
                System.out.println(m.name + " killed you. GAME OVER ");
                break;
            }
        }
    }

    public boolean nextStage() {

        Scanner cont = new Scanner(System.in);
        System.out.println("Do you want to continue? Y/N");
        String answ = cont.nextLine();

        while (true) {
            if (answ.equalsIgnoreCase("y")) {
                return true;
            } else if (answ.equalsIgnoreCase("n")) {
                return false;
            }

        }

    }
    public void calcIni(Character highIni, Character lowIni){
        String highDmg;
        String lowDmg ;
        highIni.dmgCalc();
        lowIni.dmgCalc();
        System.out.println(highIni.name + " is faster and attacks first.");
        while (highIni.currentHealth > 0 && lowIni.currentHealth > 0) {
            highDmg = lowIni.defCalc(highIni.getDmg());
            System.out.println(highIni.name + " attacks  and deals " + highDmg + " damage.");
            System.out.println(lowIni.name +" HP: " + lowIni.currentHealth +"/" + lowIni.maxHealth);
            if (lowIni.currentHealth > 0) {
                lowDmg = highIni.defCalc(lowIni.getDmg());
                System.out.println(lowIni.name + " attack and deal " + lowDmg + " damage");
                System.out.println(highIni.name + " has " + highIni.currentHealth +"/"+highIni.maxHealth + " HP");
            }

        }
    }
}













