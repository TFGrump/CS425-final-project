
public class Weapon extends GameItem {

	// Private
   private double damage;
   private double accuracy;
   private int firerate;
   private int maxMag;
   private int mag;
   private int range;
	
	// Constructor
   public Weapon(String name, int value, double weight, double damage, double accuracy, int firerate, int mag, int range) {
      super(name, value, weight);
      this.damage = damage;
      this.accuracy = accuracy;
      this.firerate = firerate;
      this.maxMag = mag;
      this.mag = mag;
      this.range = range;
   }
   
   public Weapon(String rawData) {
      super(rawData); // Super constructor handles name, value, and weight
      
      // Read Stats
      String[] stats = rawData.split(" ");
      damage = Integer.parseInt(GameItemManager.removeLabel(stats[3])); // Damage
      accuracy = Double.parseDouble(GameItemManager.removeLabel(stats[4])); // Accuracy
      firerate = Integer.parseInt(GameItemManager.removeLabel(stats[5])); // Firerate
      maxMag = Integer.parseInt(GameItemManager.removeLabel(stats[6])); // Mag
      mag = maxMag;
      range = Integer.parseInt(GameItemManager.removeLabel(stats[7])); // Range
   }
	
	// Getters
   public double getDamage() { return damage; }
   public double getAccuracy() { return accuracy; }
   public int getFirerate() { return firerate; }
   public int getMag() { return mag; }
   public int getRange() { return range; }
   
   public int shootBullets() {
      mag = Math.max(mag-firerate, 0);
      return (mag < firerate ? mag : firerate);
   }
   public void reload() { mag = maxMag; }
   
   public String getBriefDetails() {
      return name + " - "
         + "[Val: " + value + "] [Wgt: " + weight + "] "
         + "[Dam: " + damage + "] "
         + "[Acc: " + accuracy + "] "
         + "[Fir: " + firerate + "] "
         + "[Mag: " + mag + "] "
         + "[Range: " + range + "]";
   }
   
   public String getDetails() {
      return name + "\n"
         + "[Val: " + value + "] [Wgt: " + weight + "]\n"
         + "[Dam: " + damage + "]\n"
         + "[Acc: " + accuracy + "]\n"
         + "[Fir: " + firerate + "]\n"
         + "[Mag: " + mag + "]\n"
         + "[Range: " + range + "]";
   }
   
   
   @Override
   public String toString() {
      return getBriefDetails();
   }
}
