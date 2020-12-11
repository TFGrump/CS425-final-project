

public class Main {

   public static void main(String[] args) {
      setup();
      
      // TODO: Put main menu stuff here
      CommandCreateWorld cmd1 = new CommandCreateWorld();
      TextInputManager.addCommand(cmd1);

      while (true) {
         TextInputManager.prompt();
      }
   }
   
   private static void setup() {
      System.out.println("Starting...");
      
      System.out.println("Complete!");
   }
   
   // TODO: Remove this
   public static void print(Object o) {
      System.out.println(o);
   }
}