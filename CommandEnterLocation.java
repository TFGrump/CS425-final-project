public class CommandEnterLocation extends Command {

   World world;
   Player player;
   private String name;
   
   public CommandEnterLocation(World world, Player player) {
      this.world = world;
      this.player = player;
   }

    // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      if (player.isInCombat) return false;
      String[] tokens = input.split(" ");
      if (tokens.length < 2 || !input.contains("\"")) 
         return false;
      if (tokens[0].equalsIgnoreCase("visit") || tokens[0].equalsIgnoreCase("enter")) {
         this.name = input.split("\"")[1];
         System.out.println(this.name);
         return true;
      }
      return false;
   }
    // Code to be called when this command is executed
   public void execute() {
      for (Building loc: world.map[player.x][player.y].buildings) {
         if (this.name.equalsIgnoreCase(loc.name)) {
            player.location = loc;
            System.out.println("Entering location...");
            System.out.println(player.location);
            return;
         }
      }
      System.out.println("No location by name [" + name + "] in this neighborhood to enter!");
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      if (player.isInCombat) return;
      System.out.println("[Enter/Visit] [\"Name of location in double quotes\"] -- Move around the world");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {}
   
}