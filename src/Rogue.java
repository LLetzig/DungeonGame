public class Rogue extends Character {
    protected int dexterity;
    protected double crit;
    protected double evasion;

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public double getCrit() {
        return crit;
    }

    public void setCrit(double crit) {
        this.crit = crit;
    }

    public double getEvasion() {
        return evasion;
    }

    public void setEvasion(double evasion) {
        this.evasion = evasion;
    }

    public Rogue(String name) {
        super(name);
        dexterity = 25;
        crit = 0.2;
        maxHealth = 75;
        currentHealth = maxHealth;
        initiative = 1.2;
        evasion = (double) dexterity / 100;

    }

    public Rogue(String name, double maxHealth, double currentHealth, double baseAttack, int lvl, double initiative, double dmg, int maxExp, int currentExp, int dexterity, double crit, double evasion) {
        super(name, maxHealth, currentHealth, baseAttack, lvl, initiative, dmg, maxExp, currentExp);
        this.dexterity = dexterity;
        this.crit = crit;
        this.evasion = evasion;
    }

    @Override
    public void dmgCalc() {
        boolean b = crit > Math.random();
        if (b) {
            dmg = (baseAttack + dexterity) * 2.5;
        } else {
            dmg = baseAttack + dexterity;
        }
    }

    @Override
    public void defCalc(double dmg) {
        boolean b = evasion < Math.random();
        if (b) {
            currentHealth -= dmg;

        }
    }

    @Override
    public void onLvlUp() {
        maxHealth += 5;
        dexterity += 10;
        if (crit < 0.75) {
            crit += 0.05;
        }

        initiative += 0.1;
        maxExp += 10;
        currentExp = 0;
    }

    @Override
    public String toString() {
        return "Rogue{" +
                "evasion=" + evasion +
                ", name='" + name + '\'' +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", lvl=" + lvl +
                ", initiative=" + initiative +
                ", dmg=" + dmg +
                ", dexterity=" + dexterity +
                ", crit=" + crit +
                '}';
    }
}
