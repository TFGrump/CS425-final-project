public class CommandGetKillQuest extends Command {
   World world;
   Player player;
   
   public CommandGetKillQuest(World world, Player player) {
      this.world = world;
      this.player = player;
   }

   // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      if (player.isInCombat) return false;
      return input.equalsIgnoreCase("get quest");
   }
   
   // Code to be called when this command is executed
   public void execute() {
      MapTile tile = world.map[player.x][player.y];
      new QuestKill(world.getRandomPersonInTile(tile), player, world.getRandomPersonInTile(tile)).start();
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      if (player.isInCombat) return;
      System.out.println("[Get Quest] -- Gets a local quest in this neighborhood");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {}
}