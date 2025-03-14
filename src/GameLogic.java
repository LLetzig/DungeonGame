import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public  class GameLogic {
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
            █                           Stage[1] : easy to medium encounters                █
            █                                                                               █
            █                           Stage[1] : medium encounters                        █
            █                                                                               █
            █                           Stage[1] : hard encounters                          █
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
            █         + lifedrain              +knife nerd           + too dumb             █
            █                                                          to feel pain         █
            █                                                                               █
            █             [1]                      [2]                      [3]             █
            █                                                                               █
            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
            """;

    /**
     * es ist ein menü...
     * @return neuer oder datenbank char
     */
    public Character menu() {
        Character player = new Warrior("menuman");
        int value = 0;
        System.out.println(splash);
        Scanner sc = new Scanner(System.in);
        while(value < 1 || value >3){
            value = sc.nextInt();
        }
        sc.close();
        while(true){
            if (value == 1){String name =GameLogic.chooseName();
                player = GameLogic.chooseChar(name);
            }else if (value==2) {player = db.getMage(1);
            }else if (value==3) {System.out.println("bye");
            }else{ System.out.println("1,2 oder 3");
            break;}

        }
        return player;
    }

    /**
     *
     * @return gewählter name
     */
    public static String chooseName() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter name:");
        return scn.nextLine();
    }

    /**
     *
     * @param name kommt von chooseName()
     * @return gewähltes klassenobjekt für (player)
     */
    public static Character chooseChar(String name) {
        Scanner sc = new Scanner(System.in);
        int cl = 0;
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
     * @return dungeon lvl -> geht nach createStage()
     */
    public int setStage(){
        Scanner sc = new Scanner(System.in);
        int stageLvl=0;
        while (stageLvl<1 && stageLvl>5){
            System.out.println(stage);
            stageLvl =sc.nextInt();
        }
        return stageLvl;
    }

    /**
     * kreiert eine Liste von gegnern angepasst an das dungeon lvl (parameter von setStage() wird übergeben
      */

    public ArrayList<Character> createStage(int lvl){
        int rarity=0;
        switch(lvl){
            case 1 -> rarity = 1;
            case 2 -> rarity = (Math.random() * 2) < 1 ? 1 : 2;
            case 3 -> rarity =2;
            case 4 -> rarity = (Math.random() * 3) < 2 ? 2 : 3;
            case 5 -> rarity =3;
        }
        return new ArrayList<>(Arrays.asList(new Monster(Monster.nameMyMonster(rarity),rarity,lvl),
                new Monster(Monster.nameMyMonster(rarity),rarity,lvl),
                new Monster(Monster.nameMyMonster(rarity),rarity,lvl)));
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
    public void fightStage(ArrayList<Character> stage, Character player){

        for(Character m: stage){
            String mdmg;
            String pdmg;
            m.dmgCalc();
            player.dmgCalc();
            System.out.println(m.name + m.lvl + " blockiert den weg und begibt sich in Angriffsstellung" );
            if (player.getInitiative()<m.getInitiative()) {
                System.out.println(m.name + " ist flinker und greift zuerst an");
                while (m.currentHealth<=0 || player.currentHealth<=0){
                    mdmg = player.defCalc(m.getDmg());
                    System.out.println( m.name + " fügt dir " + mdmg + " Schaden zu.");
                    pdmg = m.defCalc(player.getDmg());
                    System.out.println( "Du greifst an und fügst " + pdmg + " Schaden zu.");}
            }else {
                System.out.println("Du bist schneller als " + m.name);
                while (m.currentHealth <= 0 || player.currentHealth <= 0) {
                    pdmg = m.defCalc(player.getDmg());
                    System.out.println("Du greifst an und fügst " + pdmg + " Schaden zu.");
                    mdmg = player.defCalc(m.getDmg());
                    System.out.println(m.name + " fügt dir " + mdmg + " Schaden zu.");
                }
            }
            if(m.currentHealth<=0){
                System.out.println("Du warst gegen " +m.name +" siegreich und setzt deinen weg durch den Dungeon fort");
                if (player.currentExp>=player.maxExp){
                    player.onLvlUp();
                }
            }else{
                System.out.println(m.name +" hat dich besiegt. GAME OVER ");
                break;
            }

            }
        saveChar(player);
        }
        public boolean nextStage(){
        Scanner cont = new Scanner(System.in);
        String answ =cont.nextLine();
            System.out.println("Do you want to continue? Y/N");
            if (answ.equalsIgnoreCase("y")) {return true;}
            else {return false}
        }
    }













