

public class Main {

   public static World world = null;

   public static void main(String[] args) {
      //setup();
      
      draw();
      // TODO: Put main menu stuff here
      CommandCreateWorld cmd1 = new CommandCreateWorld();
      TextInputManager.addCommand(cmd1);

      System.out.print("Input your command: ");
      
      while (world == null) {
         TextInputManager.prompt();
      }
      
      TextInputManager.removeCommand(cmd1);
      TextInputManager.addCommand(new CommandMove(world, world.player));
      TextInputManager.addCommand(new CommandEnterLocation(world, world.player));
      TextInputManager.addCommand(new CommandAttack(world, world.player));
      TextInputManager.addCommand(new CommandExamine(world, world.player));
      TextInputManager.addCommand(new CommandMap(world, world.player));
      TextInputManager.addCommand(new CommandTileInfo(world, world.player));
      TextInputManager.addCommand(new CommandLocationInfo(world.player));
      TextInputManager.addCommand(new CommandGetKillQuest(world, world.player));
      TextInputManager.addCommand(new CommandQuestlog(world.player));
      TextInputManager.addCommand(new CommandInventory(world.player));
      TextInputManager.addCommand(new CommandEquipGear(world.player));
      TextInputManager.addCommand(new CommandUnequipGear(world.player));
      TextInputManager.addCommand(new CommandCharacter(world.player));
      world.start();
   }
   
   private static void setup() {
      System.out.println("Starting...");
      // TODO: Add setup
      System.out.println("Complete!");
   }
   
   public static void draw()
    {

        System.out.println("[UNTITLED TEXT BASED GAME WITH LOTS OF PROCEDURALLY GENERATED CONTENT]\n");
        System.out.println("+--^----------,--------,-----,--------^-,");
        System.out.println(" | |||||||||   `--------'     |          O");
        System.out.println(" `+---------------------------^----------|");
        System.out.println("   `\\_,---------,---------,--------------'");
        System.out.println("     / XXXXXX /'|       /'");
        System.out.println("    / XXXXXX /  `\\    /'");
        System.out.println("   / XXXXXX /`-------'");
        System.out.println("  / XXXXXX /");
        System.out.println(" / XXXXXX /");
        System.out.println("(________(");
        System.out.println(" `------'");

        System.out.println("\nCreated By: Liam Rainey, Theorin Feder, Elijah Monroe\n");
        System.out.println("If you ever don't know what to do, type \"help\"!\n");
    }
   
   // TODO: Remove this
   public static void print(Object o) {
      System.out.println(o);
   }
}
