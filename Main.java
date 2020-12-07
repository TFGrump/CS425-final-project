

public class Main {

   static public boolean userWantsToQuit = false;
   private static UserInput userInput;

   public static void main(String[] args) {
      
      setup();
      
      // TODO: Put main menu stuff here
      while (!userWantsToQuit) { // TODO: Change bool to check if world is open, or rather use loop in the world its-self?
         userInput.requestAndHandleInput();
         
      }
      
      saveAndQuit();
   }
   
   private static void setup() {
      UserInput userInput = new UserInput();
   }
   
   public static void print(Object o) {
      System.out.println(o);
   }
   
   public static void saveAndQuit() {
      // TODO: Save shit if applicable
      System.exit(0);
   }
}