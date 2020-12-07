public abstract class Command {
   public abstract boolean isTrigger(String input); // Returns true if this string would be a valid trigger for this command 
   public abstract void execute(); // Code to be called when this command is executed
   public abstract void printOneLineHelp(); // Print out one line of help to the user
   public abstract void printDetailedHelp(); // Print out a more detailed help menu
}