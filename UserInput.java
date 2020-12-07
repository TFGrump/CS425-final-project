import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;

public class UserInput {
   
   private Scanner scanner;
   private ArrayList<String> validInputs;
   int mode;
   
   public UserInput() {
      scanner = new Scanner(System.in);  // Create a Scanner object
      validInputs = new ArrayList<String>();
      validInputs.add("quit");
   }
   
   // NOTE: Consider making boolean later?
   // Check if input is in array of valid inputs
   // If it's not, notify user
   public void requestAndHandleInput() {
      Main.print("Input prompt placeholder:");
      String input = scanner.nextLine();
   
      // Checks if input is valid
      if (isValidInput(input)) {
         executeCommand(input);
      } else Main.print("Input invalid");
   }
   
   
   private boolean isValidInput(String input) {
      for (String s: validInputs)
         if (s.equalsIgnoreCase(input)) 
            return true;
      return false;
   }
   
   private void executeCommand(String command) {
      switch (command.toLowerCase()) {
         case "help": printHelp();
            break;
         case "quit": Main.userWantsToQuit = true; 
            break;
      }
   }
   
   private void printHelp() {
      
   }
}