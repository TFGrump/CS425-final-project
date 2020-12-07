public abstract class GameItem {

   String name;

   private int strengthMod;
   private int perceptionMod;
   private int enduranceMod;
   private int charismaMod;
   private int intelligenceMod;
   private int agilityMod;
   private int luckMod;
   
   // Get respective stat modifiers
   public int getStrMod() { return strengthMod; }
   public int getPerMod() { return perceptionMod; }
   public int getEndMod() { return enduranceMod; }
   public int getChrMod() { return charismaMod; }
   public int getIntMod() { return intelligenceMod; }
   public int getAgiMod() { return agilityMod; }
   public int getLucMod() { return luckMod; }
}