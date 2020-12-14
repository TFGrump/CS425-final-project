import java.util.ArrayList;

public class CommandAttack extends Command {

   World world;
   Player player;
   private String name;
   
   public CommandAttack(World world, Player player) {
      this.world = world;
      this.player = player;
   }

    // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      if (player.location == null || player.isInCombat) return false;
      String[] tokens = input.split(" ");
      if (tokens.length < 2 || !input.contains("\"")) return false;
      if (tokens[0].equalsIgnoreCase("attack") || tokens[0].equalsIgnoreCase("engage")) {
         this.name = input.split("\"")[1];
         return true;
      }
      return false;
   }
    // Code to be called when this command is executed
   public void execute() {
     Person target = null;
      for (Person person: player.location.getOccupants()) {
         if (name.equalsIgnoreCase(person.getFirstName()) || name.equalsIgnoreCase(person.getName())) {
            target = person;
         }
      }
      if (target == null) {
         System.out.println("No person by name " + name + " in this location.");
         return;
      }
      
      ArrayList<Person> opponents = new ArrayList();
      for (Person person: player.location.getOccupants()) {
         if (person.getType().equals(target.getType())) opponents.add(person);
      }
      
      System.out.println("Engaging combat with " + name + " and their allies!");
      ArrayList<Person> playerTeam = new ArrayList<Person>(); // Ew
      playerTeam.add(player);
      Combat combat = new Combat(playerTeam, opponents);
      CommandAttackCombat cmd1 = new CommandAttackCombat(combat);
      CommandFleeCombat cmd2 = new CommandFleeCombat(combat);
      CommandGetOpponentsCombat cmd3 = new CommandGetOpponentsCombat(combat);
      TextInputManager.addCombatCommand(cmd1);
      TextInputManager.addCombatCommand(cmd2);
      TextInputManager.addCombatCommand(cmd3);
      player.isInCombat = true;
      combat.startCombat();
      player.isInCombat = false;
      TextInputManager.removeCombatCommand(cmd1);
      TextInputManager.removeCombatCommand(cmd2);
      TextInputManager.removeCombatCommand(cmd3);
      player.pingQuestCompletion();
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      System.out.println("[Attack] [\"Name of person in double quotes\"] -- Engage in combat with person and any nearby allies");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {}
}