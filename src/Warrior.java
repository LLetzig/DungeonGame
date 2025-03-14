public class Warrior extends Character {
    protected int strength;
    protected int maxArmor;
    protected int currentArmor;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMaxArmor() {
        return maxArmor;
    }

    public void setMaxArmor(int maxArmor) {
        this.maxArmor = maxArmor;
    }

    public int getCurrentArmor() {
        return currentArmor;
    }

    public void setCurrentArmor(int currentArmor) {
        this.currentArmor = currentArmor;
    }
    //für erstellung
    public Warrior(String name) {
        super(name);
        maxHealth = 100;
        currentHealth= 100;
        lvl = 1;
        baseAttack = 10;
        initiative = 1;
        maxArmor =50;
        currentArmor = maxArmor;
        strength = 25;
        maxExp=10;
        currentExp=0;

    }

    public Warrior(int strength, int maxArmor, int currentArmor) {
        this.strength = strength;
        this.maxArmor = maxArmor;
        this.currentArmor = currentArmor;
    }

    public Warrior(String name, int strength, int maxArmor, int currentArmor) {
        super(name);
        this.strength = strength;
        this.maxArmor = maxArmor;
        this.currentArmor = currentArmor;
    }

    public Warrior(String name, double maxHealth, int lvl, int strength, int maxArmor, int currentArmor) {
        super(name, maxHealth, lvl);
        this.strength = strength;
        this.maxArmor = maxArmor;
        this.currentArmor = currentArmor;
    }
    //um aus db zu holen
    public Warrior(String name, double maxHealth, double currentHealth, double baseAttack, int lvl, double initiative, double dmg, int maxExp, int currentExp, int strength, int maxArmor, int currentArmor) {
        super(name, maxHealth, currentHealth, baseAttack, lvl, initiative, dmg, maxExp, currentExp);
        this.strength = strength;
        this.maxArmor = maxArmor;
        this.currentArmor = currentArmor;
    }

    @Override
    public void dmgCalc() {
        dmg = baseAttack +strength;
    }


    public String defCalc(double dmg) {
        double diff = currentHealth;
        currentHealth -= dmg - currentArmor;
        currentArmor -= diff -currentHealth;
        return Double.toString(diff - currentHealth);
    }

    @Override
    public void onLvlUp() {

        maxHealth +=5;
        currentHealth= maxHealth;
        strength += 10;
        maxArmor += 5;
        currentArmor = maxArmor;
        initiative+=0.1;
        maxExp+=10*lvl;
        currentExp=0;
    }

}
