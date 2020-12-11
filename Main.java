import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) throws FileNotFoundException {
      setup();
      
      // TODO: Put main menu stuff here
      
      System.out.println("Welcome to Gangster the Game!");
      
      Scanner scanner = new Scanner(new File("icon/icon.txt"));
      System.out.println(scanner.toString());
      scanner.close();
      
      CommandCreateWorld cmd1 = new CommandCreateWorld();
      TextInputManager.addCommand(cmd1);

      while (true) {
         TextInputManager.prompt();
      }
   }
   
   private static void setup() {
      System.out.println("Starting...");
      
      System.out.println("Complete!");
   }
   
   // TODO: Remove this
   public static void print(Object o) {
      System.out.println(o);
   }
}