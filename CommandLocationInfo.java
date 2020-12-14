public class CommandLocationInfo extends Command {

   Player player;
   
   public CommandLocationInfo(Player player) {
      this.player = player;
   }

   // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      if (player.isInCombat) return false;
      return input.equalsIgnoreCase("loc") || input.equalsIgnoreCase("location");
   }
   
   // Code to be called when this command is executed
   public void execute() {
      if (player.location == null) System.out.println("Not inside a location!");
      else System.out.println(player.location);
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      if (player.isInCombat) return;
      System.out.println("[Loc/Location] -- Print information on current location");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {}
}