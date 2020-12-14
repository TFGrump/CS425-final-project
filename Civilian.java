public class Civilian extends Person {


   public Civilian(String firstName, String lastName, int age, boolean gender) {
      super(firstName, lastName, age, gender);
   }
   
   public String getType() {
      return "civilian";
   }
}