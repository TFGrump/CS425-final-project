public abstract class Command {
   
   String helpFull; // More details help screen
   String helpBrief; // One line output for help
   
   public void printOneLineHelp();
   public void printDetailedHelp();
}