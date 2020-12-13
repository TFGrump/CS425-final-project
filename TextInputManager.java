import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;

public class TextInputManager {
   
   private static Scanner scanner;
   private static ArrayList<Command> commands;
   
   static {
      scanner = new Scanner(System.in);
      commands = new ArrayList<Command>();
      commands.add(new CommandQuit());
   }
   
   // NOTE: Consider making boolean later?
   // Check if input is in array of valid inputs
   // If it's not, notify user
   public static void prompt() {
      Main.print("Enter Command:"); // Prompt the user
      String input = scanner.nextLine(); // Input
      if (input.equalsIgnoreCase("help")) help();
      else 
         for (Command command: commands)  // Checks if input is valid
            if (command.isTrigger(input)) 
               command.execute();
   }
   
   private static void help() {
      for (Command command: commands) command.printOneLineHelp();
   }
   
   public static void addCommand(Command c) { commands.add(c); }
   public static void removeCommand(Command c) { commands.remove(c); }
   
}