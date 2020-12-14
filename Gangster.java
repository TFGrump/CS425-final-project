public class Gangster extends Person {
   
   private String nickname = null;
   
   public Gangster(String firstName, String lastName, int age, boolean gender) {
      super(firstName, lastName, age, gender);
   }
   
   public Gangster(String firstName, String nickname, String lastName, int age, boolean gender) {
      super(firstName, lastName, age, gender);
      this.nickname = nickname;
   }
   
   public String getName() { 
      if (nickname != null) return firstName + " \"" + nickname + "\" " + lastName;
      else return firstName + " " + lastName;
   }
   
   public String getType() {
      return "gangster";
   }
}