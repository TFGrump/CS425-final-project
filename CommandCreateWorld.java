public class CommandCreateWorld extends Command {

      private long seed;
      private long width;
      private long height;

    // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      String[] tokens = input.split(" ");
      if (tokens[0].equalsIgnoreCase("new") || tokens[0].equalsIgnoreCase("create")) {
         if (tokens[1].equalsIgnoreCase("world")) {
            
            
         }
         return true;
      }
      return false;
   }
    // Code to be called when this command is executed
   public void execute() {
      System.out.println("We quit the game!");
      System.exit(0);
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      System.out.println("New world -- Creates a new random world");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {
      System.out.println("==========================");
      System.out.println("|       New World        |");
      System.out.println("==========================");
      System.out.println("|                        |");
      System.out.println("|                        |");
      System.out.println("|                        |");
      System.out.println("|                        |");
      System.out.println("|                        |");
      System.out.println("==========================");
   }
}