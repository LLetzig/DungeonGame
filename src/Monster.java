import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Monster extends Character {
    protected int rarity;
    static ArrayList<String>low = new ArrayList<>(Arrays.asList("lesser Ghoul", "Hamster", "Rabbit", "Crow", "Slime", "Goblin"));
    static ArrayList<String>mid = new ArrayList<>( Arrays.asList("Big Hamster", "rabid Rabbit", "Zombie", "Eagle", "metal Slime", "Hobgoblin"));
    static ArrayList<String>rare = new ArrayList<>(Arrays.asList("King Hamster", "Raging assassination Rabbit", "Vampire", "Griffin", "all consuming BLOB", "Ork Boss"));

    public Monster(String name, int rarity, int lvl) {
        this.rarity = rarity;
        name = nameMyMonster(rarity);
        currentHealth = 50 + (5*rarity);
        maxHealth=50 + (5*rarity);
        baseAttack = 10 + (2*rarity);
        initiative = 0.8 + (0.1*rarity);

        for (int i = 1; i <= lvl; i++) {
            onLvlUp();
        }

    }

    @Override
    public void dmgCalc() {
            dmg  = baseAttack;
    }

    @Override
    public void defCalc(double dmg) {

    }

    @Override
    public void onLvlUp() {
    maxHealth += 3 + (5*rarity);
    currentHealth = maxHealth;
    baseAttack += 3 + (5*rarity);
    initiative += (0.05 * rarity);
    }
    public static String nameMyMonster(int rarity) {
        switch(rarity){
            case 1: {
                Collections.shuffle(low);
                return low.get(3);
            }
            case 2: {
                Collections.shuffle(mid);
                return mid.get(3);
            }
            case 3: {
                Collections.shuffle(rare);
                return rare.get(3);
            }
            default: return "Randalf der fehler";
        }
    }
}
