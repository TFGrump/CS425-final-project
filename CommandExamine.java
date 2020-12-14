public class CommandExamine extends Command {
   World world;
   Player player;
   private String name;
   
   public CommandExamine(World world, Player player) {
      this.world = world;
      this.player = player;
   }

    // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      if (player.location == null || player.isInCombat) return false;
      String[] tokens = input.split(" ");
      if (tokens.length < 2 || !input.contains("\"")) return false;
      if (tokens[0].equalsIgnoreCase("examine")) {
         this.name = input.split("\"")[1];
         return true;
      }
      return false;
   }
    // Code to be called when this command is executed
   public void execute() {
      for (Person person: player.location.getOccupants()) {
         if (name.equalsIgnoreCase(person.getFirstName()) || name.equalsIgnoreCase(person.getName())) {
            person.printCharacterSheet();
            return;
         }
      }
      System.out.println("No person by name " + name + " in this location.");
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      if (player.isInCombat) return;
      System.out.println("[Examine] [\"Name of person in double quotes\"] -- Print stats and items of a nearby person");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {}
}