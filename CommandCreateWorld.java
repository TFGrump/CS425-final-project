public class CommandCreateWorld extends Command {

   private long seed;
   private int width;
   private int height;
   private boolean randomSeed = true;

    // Returns true if this string would be a valid trigger for this command 
   public boolean isTrigger(String input) {
      String[] tokens = input.split(" ");
      if (tokens.length < 2) 
         return false;
      if (tokens[0].equalsIgnoreCase("new") || tokens[0].equalsIgnoreCase("create")) {
         if (tokens[1].equalsIgnoreCase("world")) {
            
            if (tokens.length < 4) {
               System.out.println("Correct usage: [new/create] world [width] [height] (seed)");
               return false;
            }
            width = Integer.parseInt(tokens[2]);
            height = Integer.parseInt(tokens[3]);
            
            if (tokens.length == 5) {
               seed = Integer.parseInt(tokens[4]);
               randomSeed = false;
            }
         }
         return true;
      }
      return false;
   }
    // Code to be called when this command is executed
   public void execute() {
      if (randomSeed) System.out.println("Generating world of dimensions (" + width + " x " + height + ") with random seed...");
      else System.out.println("Generating world of dimensions (" + width + " x " + height + ") with seed (" + seed + ")...");
      
      Main.world = new World((randomSeed ? (long)Math.random() : seed), width, height);
      // TODO: Instantiate world object here, and save it to a file, then also print out name to user
   }
   
   // Print out one line of help to the user
   public void printOneLineHelp() {
      System.out.println("New world -- Creates a new random world");
   }
   
   // Print out a more detailed help menu
   public void printDetailedHelp() {
      System.out.println("=========================================================================================");
      System.out.println("|                                      New World                                        |");
      System.out.println("=========================================================================================");
      System.out.println("| [new/create] world [width] [height] (seed)                                            |");
      System.out.println("|                                                                                       |");
      System.out.println("|                                                                                       |");
      System.out.println("|                                                                                       |");
      System.out.println("=========================================================================================");
   }
}