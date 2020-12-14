public class CopLocation extends Building {

   public CopLocation(String name) {
      super(name);
   }

   public int getFaction() {
      return 1;
   }
   public String getFactionString() {
      return "Police";
   }
}