public class CivilianLocation extends Building {

   public CivilianLocation(String name) {
      super(name);
   }

   public int getFaction() {
      return 0;
   }
   public String getFactionString() {
      return "Civilian";
   }

}