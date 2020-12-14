public class CommandCharacter extends Command {

   Player player;

   public CommandCharacter(Player player) { this.player = player; }

   public boolean isTrigger(String input) { 
      return input.equalsIgnoreCase("stats") || input.equalsIgnoreCase("character");
   } 

   public void execute() { 
      player.printCharacterSheet();
   }

   public void printOneLineHelp() { System.out.println("[Stats/Character] -- Display character sheet"); }

   public void printDetailedHelp() {}
}
