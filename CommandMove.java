public class CommandMove extends Command {
   
   int directionCode;
   World world;
   Player player;
   
   public CommandMove(World world, Player player) {
      this.world = world;
      this.player = player;
   }

    // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      if (player.isInCombat) return false;
      String[] tokens = input.split(" ");
      if (tokens.length < 2) 
         return false;
      if (tokens[0].equalsIgnoreCase("move")) {
         if (tokens[1].equalsIgnoreCase("north")) directionCode = 0;
         else if (tokens[1].equalsIgnoreCase("east")) directionCode = 1;
         else if (tokens[1].equalsIgnoreCase("south")) directionCode = 2;
         else if (tokens[1].equalsIgnoreCase("west")) directionCode = 3;
         else return false;
         return true;
      }
      return false;
   }
    // Code to be called when this command is executed
   public void execute() {
      int lastX = player.x;
      int lastY = player.y;
   
      switch (directionCode) {
         case 0:
            if (player.y - 1 >= 0) player.y--;
            else System.out.println("Can't move north!");
            break;
         case 1:
            if (player.x + 1 < world.width) player.x++;
            else System.out.println("Can't move east!");
            break;
         case 2:
            if (player.y + 1 < world.height) player.y++;
            else System.out.println("Can't move south!");
            break;
         case 3:
            if (player.x - 1 >= 0) player.x--;
            else System.out.println("Can't move west!");
            break;
      }
      
      if (lastX != player.x || lastY != player.y) {
    	 if(player.location != null) {
    		 
    		 player.location = null;
    		 
    	 }
         System.out.println("Entering neighborhood:");
         System.out.println(world.map[player.x][player.y]);
      }
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      if (player.isInCombat) return;
      System.out.println("[Move] [North/East/South/West] -- Move around the world");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {}
   
}