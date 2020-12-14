import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;

public class TextInputManager {
   
   private static Scanner scanner;
   private static ArrayList<Command> commands;
   private static ArrayList<Command> combatCommands;
   
   static {
      scanner = new Scanner(System.in);
      commands = new ArrayList<Command>();
      combatCommands = new ArrayList<Command>();
      commands.add(new CommandQuit());
   }
   
   // NOTE: Consider making boolean later?
   // Check if input is in array of valid inputs
   // If it's not, notify user
   public static void prompt() {
      boolean somethingWasValid = false;
      //Main.print("Enter Command:"); // Prompt the user
      String input = scanner.nextLine(); // Input
      if (input.equalsIgnoreCase("help")) help();
      else {
         for (Command command: commands)  // Checks if input is valid
            if (command.isTrigger(input)) {
               command.execute();
               somethingWasValid = true;
            }
         if (!somethingWasValid) System.out.println("\"" + input + "\" is not a valid command! Type \"help\" to see a list of valid ones!");
      }
   }
   
   public static void combatPrompt() {
      boolean somethingWasValid = false;
      //Main.print("Enter Command:"); // Prompt the user
      String input = scanner.nextLine(); // Input
      if (input.equalsIgnoreCase("help")) combatHelp();
      else {
         for (Command command: combatCommands)  // Checks if input is valid
            if (command.isTrigger(input)) {
               command.execute();
               somethingWasValid = true;
            }
         if (!somethingWasValid) System.out.println("\"" + input + "\" is not a valid command! Type \"help\" to see a list of valid ones!");
      }
   }
   
   private static void combatHelp() {
      for (Command command: combatCommands) command.printOneLineHelp();
   }
   
   private static void help() {
      for (Command command: commands) command.printOneLineHelp();
   }
   
   public static void addCommand(Command c) { commands.add(c); }
   public static void removeCommand(Command c) { commands.remove(c); }
   public static void addCombatCommand(Command c) { combatCommands.add(c); }
   public static void removeCombatCommand(Command c) { combatCommands.remove(c); }
}