public abstract class GameItem {

   protected String name;
   protected int value;
   protected double weight;
   
   public GameItem(String name, int value, double weight) {
      this.name = name;
      this.value = value;
      this.weight = weight;
   }
   
   public String getName() { return name; }
   public int getValue() { return value; }
   public double getWeight() { return weight; }
}