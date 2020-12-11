public abstract class GameItem {

   protected String name;
   protected int value;
   protected double weight;
   
   public GameItem(String name, int value, double weight) {
      this.name = name;
      this.value = value;
      this.weight = weight;
   }
   
   public GameItem(String rawData) {
      name = rawData.split("'")[1]; // Name
      String[] stats = rawData.split(" ");
      value = Integer.parseInt(GameItemManager.removeLabel(stats[1])); // Value
   weight = Double.parseDouble(GameItemManager.removeLabel(stats[2])); // Weight
   }
   
   public String getName() { return name; }
   public int getValue() { return value; }
   public double getWeight() { return weight; }
   
   public abstract String getBriefDetails();
   public abstract String getDetails();
}