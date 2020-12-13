public class Weapon extends GameItem {

    //private
    private int damage;
    private double accuracy;
    private int firerate;
    private int maxMag;
    private int mag;
    private int range;

    //public
    //constructors
    public Weapon(String name, int value, double weight, int damage, double accuracy, int firerate, int mag, int range) {
        super(name, value, weight);
        this.damage = damage;
        this.accuracy = accuracy;
        this.firerate = firerate;
        this.mag = this.maxMag = mag;
        this.range = range;
    }

    public Weapon(String name, int damage, double accuracy, int firerate, int mag, int range) {
        super(name, 0, 0);
        this.damage = damage;
        this.accuracy = accuracy;
        this.firerate = firerate;
        this.mag = mag;
        this.range = range;
    }

    //getters
    public int getDamage() {
        return damage;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public int getFirerate() {
        return firerate;
    }

    public int getMag() {
        return mag;
    }

    public int getRange() {
        return range;
    }

    public void shootBullets(int shotsFired)
    {
        mag -= shotsFired;
    }
    
    public void reload()
    {
        mag = maxMag;
    }
}