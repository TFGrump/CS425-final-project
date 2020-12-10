public class Gangster extends Person {
   
   String nickname = null;
   
   public Gangster(String firstName, String lastName, int age, boolean gender, boolean dead) {
      super(firstName, lastName, age, gender, dead);
   }
   
   public Gangster(String firstName, String nickname, String lastName, int age, boolean gender, boolean dead) {
      super(firstName, lastName, age, gender, dead);
      this.nickname = nickname;
   }
   
   public String getName() { 
      if (nickname != null) return firstName + "\"" + nickname + "\"" + lastName;
      else return firstName + " " + lastName;
   }
   
   public String getType() {
      return "gangster";
   }
}