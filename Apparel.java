public class Apparel extends GameItem {

	// Private
   private int strengthMod;
   private int perceptionMod;
   private int enduranceMod;
   private int charismaMod;
   private int intelligenceMod;
   private int agilityMod;
   private int luckMod;
	
	// Constructor
   public Apparel(String name, int value, double weight, int strengthMod, int perceptionMod, int enduranceMod, int charismaMod, int intelligenceMod, int luckMod, int agilityMod) {
      super(name, value, weight);
      this.strengthMod = strengthMod;
      this.perceptionMod = perceptionMod;
      this.enduranceMod = enduranceMod;
      this.charismaMod = charismaMod;
      this.intelligenceMod = intelligenceMod;
      this.agilityMod = agilityMod;
      this.luckMod = luckMod;
   }
   
   // Get respective stat modifiers
   public int getStrMod() { 
      return strengthMod; 
   }
   public int getPerMod() { 
      return perceptionMod; 
   }
   public int getEndMod() { 
      return enduranceMod; 
   }
   public int getChrMod() { 
      return charismaMod; 
   }
   public int getIntMod() { 
      return intelligenceMod; 
   }
   public int getAgiMod() { 
      return agilityMod; 
   }
   public int getLucMod() { 
      return luckMod; 
   }
   
   public String getBriefDetails() {
      return name + " - "
         + "[Val: " + value + "] [Wgt: " + weight + "] "
         + (strengthMod != 0 ? "[Str: " + strengthMod + "] " : "")
         + (perceptionMod != 0 ? "[Per: " + perceptionMod + "] " : "")
         + (enduranceMod != 0 ? "[End: " + enduranceMod + "] " : "")
         + (charismaMod != 0 ? "[Chr: " + charismaMod + "] " : "")
         + (intelligenceMod != 0 ? "[Int: " + intelligenceMod + "]" : "")
         + (agilityMod != 0 ? "[Agi: " + agilityMod + "]" : "")
         + (luckMod != 0 ? "[Luc: " + luckMod + "]" : "");
   }
   
   public String getDetails() {
      return name + "\n"
         + "[Value: " + value + " Weight: " + weight + "\n"
         + (strengthMod != 0 ? "[Strength: " + strengthMod + "]\n" : "")
         + (perceptionMod != 0 ? "[Perception: " + perceptionMod + "]\n" : "")
         + (enduranceMod != 0 ? "[Endurance: " + enduranceMod + "]\n" : "")
         + (charismaMod != 0 ? "[Charisma: " + charismaMod + "]\n" : "")
         + (intelligenceMod != 0 ? "[Intelligence: " + intelligenceMod + "]\n" : "")
         + (agilityMod != 0 ? "[Agility: " + agilityMod + "]\n" : "")
         + (luckMod != 0 ? "[Luck: " + luckMod + "]\n" : "");
   }
   
   @Override
   public String toString() {
      return getBriefDetails();
   }
}
