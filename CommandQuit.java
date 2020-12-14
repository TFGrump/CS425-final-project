public class CommandQuit extends Command {
   
    // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      return input.equalsIgnoreCase("quit");
   }
    // Code to be called when this command is executed
   public void execute() {
      System.out.println("We quit the game!");
      System.exit(0);
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      System.out.println("Quit -- Quits the game");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {
      System.out.println("==========================");
      System.out.println("So much detail! :D");
      System.out.println("                          ");
      System.out.println("                          ");
      System.out.println("                          ");
      System.out.println("                          ");
      System.out.println("                          ");
      System.out.println("                          ");
      System.out.println("==========================");
   }
}