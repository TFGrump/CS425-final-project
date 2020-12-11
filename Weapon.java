
public class Weapon extends GameItem {

	// Private
   private double damage;
   private double accuracy;
   private double firerate;
   private int mag;
   private int range;
	
	// Constructor
   public Weapon(String name, int value, double weight, double damage, double accuracy, double firerate, int mag, int range) {
      super(name, value, weight);
      this.damage = damage;
      this.accuracy = accuracy;
      this.firerate = firerate;
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
      mag = Integer.parseInt(GameItemManager.removeLabel(stats[6])); // Mag
      range = Integer.parseInt(GameItemManager.removeLabel(stats[7])); // Range
   }
	
	// Getters
   public double getDamage() { return damage; }
   public double getAccuracy() { return accuracy; }
   public double getFirerate() { return firerate; }
   public int getMag() { return mag; }
   public int getRange() { return range; }
   
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
