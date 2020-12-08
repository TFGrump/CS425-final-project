public abstract class GameItem {

   //private
   private String name;
   private float weight;
   private float value;
   
   //protected
   protected GameItem(String name, float weight, float value) {
	   this.name = name;
	   this.value = value;
	   this.weight = weight;
   }

   //public
   public String getName() {
	   return this.name;
   }
	
   public float getWeight() {
	   return this.weight;
   }

   public float getValue() {
	   return this.value;
   }

   
}