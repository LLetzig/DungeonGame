public abstract class Character {

    protected String name;
    protected double maxHealth;
    protected double currentHealth;
    protected double baseAttack;
    protected int lvl;
    protected double initiative;
    protected double dmg;
    protected int maxExp;
    protected int currentExp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public double getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(double baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public double getInitiative() {
        return initiative;
    }

    public void setInitiative(double initiative) {
        this.initiative = initiative;
    }

    public double getDmg() {
        return dmg;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public Character() {
    }

    public Character(String name) {
        this.name = name;
    }

    // für monster
    public Character(String name, double maxHealth, int lvl) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.lvl = lvl;
    }

    public Character(String name, double maxHealth, double currentHealth, double baseAttack, int lvl, double initiative, double dmg, int maxExp, int currentExp) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.baseAttack = baseAttack;
        this.lvl = lvl;
        this.initiative = initiative;
        this.dmg = dmg;
        this.maxExp = maxExp;
        this.currentExp = currentExp;

    }

    abstract public void dmgCalc();
    // muss daß sein?
    abstract public String defCalc(double dmg);

    abstract public void onLvlUp();

}
