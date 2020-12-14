

public class Main {

   public static World world = null;

   public static void main(String[] args) {
      //setup();
      
      // TODO: Put main menu stuff here
      CommandCreateWorld cmd1 = new CommandCreateWorld();
      TextInputManager.addCommand(cmd1);
      
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
      world.start();
   }
   
   private static void setup() {
      System.out.println("Starting...");
      // TODO: Add setup
      System.out.println("Complete!");
   }
   
   // TODO: Remove this
   public static void print(Object o) {
      System.out.println(o);
   }
}