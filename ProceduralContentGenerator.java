import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ProceduralContentGenerator {

   // Constants for wordlist filesnames
   private final String DIR_NAME = "wordlists";
   private final String FIRST_NAMES_M = "firstnames_male";
   private final String FIRST_NAMES_F = "firstnames_female";
   private final String LAST_NAMES = "lastnames";
   private final String TRAITS = "traits";
   
   // Item Pools
   private final String DIR_ITEM = "items";
   private final String GANG_EQUIP_WEAPON = "gang_equip_pool_weapon";
   private final String GANG_EQUIP_HEAD = "gang_equip_pool_weapon";
   private final String GANG_EQUIP_TORSO = "gang_equip_pool_weapon";
   private final String GANG_EQUIP_LEGS = "gang_equip_pool_weapon";
   
   private long seed;
   private Random ran;
   
   // TODO: Remove this, generate random seed in the world file or main menu even
   public ProceduralContentGenerator() {
      ran = new Random();
      seed = ran.nextLong();
      ran = new Random(seed);
   }
   
   public ProceduralContentGenerator(long seed) {
      this.seed = seed;
      ran = new Random(seed);
   }
   
   public long getSeed() { return seed; }
   
   public MapTile genTile(double diff) {
      MapTile tile = new MapTile(diff);
      
      
      
      // TODO: Add logic
      return tile;
   }
   
   public Civilian genCivilian(double diff) {
      int maxAge = 81;
      int minAge = 24;
      double chanceOfMan = 0.5;
      
      boolean gender = (ran.nextDouble() < chanceOfMan ? true : false);
      String firstname = getLineFromFile((gender ? FIRST_NAMES_M : FIRST_NAMES_F)); // Get Random first name
      String lastname = getLineFromFile(LAST_NAMES); // Get random last name
      int age = (int)((ran.nextDouble() * (maxAge - minAge)) + minAge);
      
      return new Civilian(firstname, lastname, age, gender, false);
   }
   
   public Gangster genGangster(double diff) {
      int maxAge = 34;
      int minAge = 15;
      double chanceOfMan = 0.8;
      double chanceOfNickname = 0.2;
      
      boolean gender = (ran.nextDouble() < chanceOfMan ? true : false);
      String firstname = getLineFromFile((gender ? FIRST_NAMES_M : FIRST_NAMES_F)); // Get Random first name
      String lastname = getLineFromFile(LAST_NAMES); // Get random last name
      int age = (int)((ran.nextDouble() * (maxAge - minAge)) + minAge);
      
      
      
      Gangster gangster = new Gangster(firstname, lastname, age, gender, false); // Create gangster as specified
      applyLevelUps(gangster, (int)((diff * 100) / 4)); // Level up the gangster based on difficulty
      
      
      
      return gangster;
   }
   
   
   
   // TODO: Add method for each different kind of thing we want to generate
   //       with the "difficulty" value (from the perlin) as an argument
   
   // PRIVATE HELPERS
   private String getLineFromFile(String filename) {
      try {
         File file = new File(DIR_NAME + "/" + filename + ".txt"); // File object
         Scanner reader = new Scanner(file); // Scanner opens file
         
         // Check the first line of the file to look for how many items there are
         int total;
         if (reader.hasNextLine()) total = Integer.parseInt(reader.nextLine());
         else 
            return null;
         
         // Select random line from file
         int target = ran.nextInt(total); // Target index of the line we want to uniformly select
         for (int i = 0; i < target; i++) reader.nextLine(); // Iterate through file
         String line = reader.nextLine();
         
         reader.close(); // Close file
         return line; // Return the selected line
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
      return null;
   }
   
   private void applyLevelUps(Person person, int levels) {
      for (int i = 0; i < levels; i++) {
         switch(ran.nextInt(7)) {
            case 0: person.levelUp('s'); break;
            case 1: person.levelUp('p'); break;
            case 2: person.levelUp('e'); break;
            case 3: person.levelUp('c'); break;
            case 4: person.levelUp('i'); break;
            case 5: person.levelUp('a'); break;
            case 6: person.levelUp('l'); break;
         }
      }
   }
   
   public static void main(String[] args) {
      ProceduralContentGenerator pcg = new ProceduralContentGenerator(0);
      Gangster gangster = pcg.genGangster(1);
      gangster.printCharacterSheet();
   }
}