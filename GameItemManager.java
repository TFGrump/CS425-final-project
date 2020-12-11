import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GameItemManager
{
   private static final String DIR_NAME = "items";
   private static final String ITEM_FILE = "itemsByID";
   
   // Item tag Constants
   private static final String TAG_WEAPON = "#Weapon";
   private static final String TAG_APPAREL = "#Apparel";
   private static final String TAG_RANGED = "#Range";
   private static final String TAG_AOE = "#AoE";

   static GameItem getNewItem(int id) {
      GameItem item = null;
      Scanner reader = null;
      try {
         File file = new File(DIR_NAME + "/" + ITEM_FILE + ".txt"); // File object
         reader = new Scanner(file); // Scanner opens file
      
         while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (id == getID(line)) {
               String[] stats = line.split(" ");
               if (hasTag(TAG_WEAPON, line)) item = new Weapon(line);
               else if (hasTag(TAG_APPAREL, line))item = new Apparel(line);
            }
         }
      } catch (FileNotFoundException e) {}
      if (item == null) System.out.println("ERROR: No item with ID of (" + id + ") found");
      if (reader != null) reader.close();
      return item;
   }
   
   private static String getName(String line) {
      String[] tokens = line.split("'");
      return tokens[1];
   }
   
   private static int getID(String line) {
      return Integer.parseInt(line.split(" ")[0]);
   }
   
   private static String[] getTags(String line) {
      String[] tokens = line.split(" ");
      int j = 0;
      for (int i = 0; i < tokens.length; i++)
         if (tokens[i].charAt(0) == '#') j++;
   
      String[] tags = new String[j];
      j = 0;
      for (int i = 0; i < tokens.length; i++)
         if (tokens[i].charAt(0) == '#') tags[j++] = tokens[i];
      return tags;
   }
   
   private static boolean hasTag(String tag, String line) {
      String[] tags = getTags(line);
      for (int i = 0; i < tags.length; i++)
         if (tags[i].equals(tag)) 
            return true;
      return false;
   }
   
   private static int getValue(String line) {
      return Integer.parseInt(line.split(" ")[1]);
   }
   
   private static int getWeight(String line) {
      return Integer.parseInt(line.split(" ")[2]);
   }
   
   // For tokens formatted such as "damage=5" it will return the 5 as a string
   // If it is just a "5" this is also accounted for, and will not error.
   public static String removeLabel(String token) {
      String[] tokens = token.split("=");
      return (tokens.length == 2 ? tokens[1] : tokens[0]);
   }
   
         
   public static void main(String[] args) {
      System.out.println(getNewItem(1));
   }
   
   
}