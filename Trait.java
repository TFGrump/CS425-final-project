public class Trait {
   
   private String name;
   
   // Modifications this trait applies to stats
   private int strengthMod;
   private int perceptionMod;
   private int enduranceMod;
   private int charismaMod;
   private int intelligenceMod;
   private int agilityMod;
   private int luckMod;
   
   public Trait(String name, int s, int p, int e, int c, int i, int a, int l) {
      this.name = name;
      this.strengthMod = s;
      this.perceptionMod = p;
      this.enduranceMod = e;
      this.charismaMod = c;
      this.intelligenceMod = i;
      this.agilityMod = a;
      this.luckMod = l;
   }
   
   public Trait(String rawData) {
      String[] data = rawData.split(" ");
      this.name = data[0];
      this.strengthMod = Integer.parseInt(data[1]);
      this.perceptionMod = Integer.parseInt(data[2]);
      this.enduranceMod = Integer.parseInt(data[3]);
      this.charismaMod = Integer.parseInt(data[4]);
      this.intelligenceMod = Integer.parseInt(data[5]);
      this.agilityMod = Integer.parseInt(data[6]);
      this.luckMod = Integer.parseInt(data[7]);
   }
   
   // Get respective stat modifiers
   public int getStrMod() { return strengthMod; }
   public int getPerMod() { return perceptionMod; }
   public int getEndMod() { return enduranceMod; }
   public int getChrMod() { return charismaMod; }
   public int getIntMod() { return intelligenceMod; }
   public int getAgiMod() { return agilityMod; }
   public int getLucMod() { return luckMod; }
   
}