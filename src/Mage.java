public class Mage extends Character {
    protected int mana;
    protected int intelligence;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public Mage(String name) {
        super(name);
        maxHealth = 100;
        currentHealth= 100;
        lvl = 1;
        baseAttack = 10;
        initiative = 1;
        mana = 10;
        intelligence = 25;

        }

    public Mage(String name, double maxHealth, double currentHealth, double baseAttack, int lvl, double initiative, double dmg, int maxExp, int currentExp, int mana, int intelligence) {
        super(name, maxHealth, currentHealth, baseAttack, lvl, initiative, dmg, maxExp, currentExp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    @Override
    public void dmgCalc() {
        if (mana > 10){
            dmg = baseAttack + intelligence;
            lifeDrain();
        }
        dmg = baseAttack + intelligence;
    }

    @Override
    public String defCalc(double dmg) {
        double diff = currentHealth;
        currentHealth -= dmg;
        return Double.toString(diff - currentHealth);
    }

    @Override
    public void onLvlUp() {
        maxHealth +=5;
        mana += 5;
        intelligence += 10;
        initiative+=0.1;
        maxExp+=10;
        currentExp=0;


    }
    public void lifeDrain(){
        if (currentHealth<maxHealth) {
            mana -= 10;
            maxHealth += 0.5 * dmg;
            System.out.println( this.name + " drains life forcefully ");
        }
    }
}

