import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Monster extends Character {
    protected int rarity;
    protected  int lootEXP;
    static ArrayList<String>low = new ArrayList<>(Arrays.asList("lesser Ghoul", "Hamster", "Rabbit", "Crow", "Slime", "Goblin"));
    static ArrayList<String>mid = new ArrayList<>( Arrays.asList("Big Hamster", "rabid Rabbit", "Zombie", "Eagle", "metal Slime", "Hobgoblin"));
    static ArrayList<String>rare = new ArrayList<>(Arrays.asList("King Hamster", "Raging assassination Rabbit", "Vampire", "Griffin", "all consuming BLOB", "Ork Boss"));

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

    public   void giveEXP(Character player){
        player.currentExp +=lootEXP;
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
