import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Monster extends Character {
    protected int rarity;
    protected  int lootEXP;
    static ArrayList<String>low = new ArrayList<>(Arrays.asList( "Hamster", "Rabbit","lesser Ghoul", "Crow", "Slime", "Goblin"));
    static ArrayList<String>mid = new ArrayList<>(Arrays.asList("Big Hamster", "rabid Rabbit", "Zombie", "Eagle", "metal Slime", "Hobgoblin"));
    static ArrayList<String>rare = new ArrayList<>(Arrays.asList("King Hamster", "Raging assassination Rabbit", "Vampire", "Griffin", "all consuming BLOB", "Ork Boss"));

    static ArrayList<String>entrance =new ArrayList<>(Arrays.asList(" is searching for a source food to stuff its cheeks with. You seem to be a appropriate source.", " hops onto the scene.", " is yearning for your blood.", " lands in front of you and screeches.", " is oozing snot and leaves a trail of mucus while moving to you.", " is schemin to KILL YA!!"));



    public Monster( int rarity, int lvl) {
        this.rarity = rarity;
        name = nameMyMonster(rarity);
        currentHealth = 50 + (5*rarity);
        maxHealth=50 + (5*rarity);
        baseAttack = 10 + (2*rarity);
        initiative = 0.8 + (0.1*rarity);
        lootEXP = 5 *rarity;
        this.lvl=lvl;

        for (int i = 1; i <= lvl; i++) {
            onLvlUp();
        }

    }

    @Override
    public void dmgCalc() {
            dmg  = baseAttack;
    }

    @Override
    public String defCalc(double dmg) {

            currentHealth -= dmg;

            return Double.toString(dmg);
    }

    @Override
    public void onLvlUp() {
    maxHealth += 3 + (5*rarity);
    currentHealth = maxHealth;
    baseAttack += 3 + (5*rarity);
    initiative +=  .05 * rarity ;
    }

    /**
     * namen"generator"
     * @param rarity bestimmt arraylist aus der name gewählt wird
     * @return Monstername
     */
    public static String nameMyMonster(int rarity) {
        // alle Arraylisten gleich lang. trotzdem redundant, weil shuffle schon random sortiert.
        int rand = new Random().nextInt(low.size());
        return switch (rarity) {
            case 1 -> {
                Collections.shuffle(low);
                yield low.get(rand);
            }
            case 2 -> {
                Collections.shuffle(mid);
                yield mid.get(rand);
            }
            case 3 -> {
                Collections.shuffle(rare);
                yield rare.get(rand);
            }
            default -> "Randalf der Fehler";
        };
    }

    /**
     * passender satz zum Erscheinen des monster
     * @param name monster name
     * @return  passender satz
     */
    public static String getEntrance (String name) {
        return switch (name) {

            case "Hamster", "Big Hamster", "King Hamster" -> entrance.getFirst();
            case "Rabbit", "rabid Rabbit", "Raging assassination Rabbit" -> entrance.get(1);
            case "lesser Ghoul","Zombie","Vampire"-> entrance.get(2);
            case "Crow", "Eagle", "Griffin" -> entrance.get(3);
            case "Slime", "metal Slime", "all consuming BLOB" -> entrance.get(4);
            case "Goblin", "Hobgoblin", "Ork Boss" -> entrance.get(5);
            default -> "is attacking you.";
        };
    }


    /**
     * Übergabe der xp des Monsters and den Spieler
     * @param player
     */
    public   void giveEXP(Character player){
        player.currentExp += lootEXP;
    }
    @Override
    public String toString() {
        return "Monster{" +
                "rarity=" + rarity +
                ", name='" + name + '\'' +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", baseAttack=" + baseAttack +
                ", lvl=" + lvl +
                ", initiative=" + initiative +
                ", dmg=" + dmg +
                ", maxExp=" + maxExp +
                ", currentExp=" + currentExp +
                "} " + super.toString();
    }
}
