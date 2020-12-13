public class Cop extends Person {
   
   String rank;
   
   public Cop(String rank, String firstName, String lastName, int age, boolean gender) {
      super(firstName, lastName, age, gender);
      this.rank = rank;
   }
   
   public String getName() { 
      return rank + " " + firstName + " " + lastName;
   }
   
   public String getType() {
      return "cop";
   }
}