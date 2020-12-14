public class CommandMap extends Command {

   World world;
   Player player;
   
   public CommandMap(World world, Player player) {
      this.world = world;
      this.player = player;
   }

   // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      if (player.isInCombat) return false;
      return input.equalsIgnoreCase("map");
   }
   
   // Code to be called when this command is executed
   public void execute() {
      for (int y = 0; y < world.height; y++) {
         System.out.println();
         for (int x = 0; x < world.width; x++) {
            if (x == player.x && y == player.y) System.out.print("[x]");
            else System.out.print("[" + (int)(100*world.map[x][y].difficulty) + "] ");
         }
      }
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      if (player.isInCombat) return;
      System.out.println("[Map] -- View map of tiles and their estimated difficulties, as well as current location");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {}
}