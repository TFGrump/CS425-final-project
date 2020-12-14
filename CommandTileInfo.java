public class CommandTileInfo extends Command {

   World world;
   Player player;
   
   public CommandTileInfo(World world, Player player) {
      this.world = world;
      this.player = player;
   }

   // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      if (player.isInCombat) return false;
      return input.equalsIgnoreCase("tile") || input.equalsIgnoreCase("neighborhood");
   }
   
   // Code to be called when this command is executed
   public void execute() {
      System.out.println(world.map[player.x][player.y]);
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      if (player.isInCombat) return;
      System.out.println("[Tile/Neighborhood] -- Print information on current neighborhood");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {}
}