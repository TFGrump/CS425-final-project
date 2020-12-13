public class Player extends Person {

   int x, y;
   Building location;
   boolean isInCombat;

   public Player(String firstName, String lastName, int age, boolean gender) {
      super(firstName, lastName, age, gender);
      x = 0;
      y = 0;
      location = null;
      isInCombat = false;
   }

   public String getType() {
      return "player";
   }

}