public class GangLocation extends Building {
   
   public GangLocation(String name) {
      super(name);
   }
   
   public int getFaction() {
      return -1;
   }
   public String getFactionString() {
      return "Gang";
   }
}