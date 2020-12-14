import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class ProceduralContentGenerator {

   // Constants for wordlist filesnames
   private final String DIR_NAME = "wordlists";
   private final String FIRST_NAMES_M = "firstnames_male";
   private final String FIRST_NAMES_F = "firstnames_female";
   private final String LAST_NAMES = "lastnames";
   private final String NICKNAMES_M = "nicknames_male";
   private final String NICKNAMES_F = "nicknames_female";
   private final String POLICE_RANKS_SHORT = "police_ranks_short";
   private final String TRAITS = "traits";
   private final String SHOP_NAMES_P2 = "shop_names_p2";
   private final String GANG_LOC_NAMES = "gang_loc_names";
   private final String TILE_NAMES = "neighborhoods";
   
   // Item Pools
   private final String DIR_ITEM = "equipment_spawn_pools";
   private final String CIV_EQUIP_POOL = DIR_ITEM + "/civ_equip_pool";
   private final String GANG_EQUIP_POOL = DIR_ITEM + "/gang_equip_pool";
   private final String POLICE_EQUIP_POOL = DIR_ITEM + "/police_equip_pool";
   
   
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
      String name = getLineFromFile(TILE_NAMES);
      MapTile tile = new MapTile(name, diff);
      double policeLocChance = 0.2;
      int amountOfLocs = ran.nextInt(8) + 2;
      if (ran.nextDouble() < policeLocChance) tile.addBuilding(genCopLocation(diff, name + " PD"));
      for (int i = 0; i < amountOfLocs; i++) tile.addBuilding((ran.nextDouble() < diff ? genGangLocation(diff) : genCivilianLocation(diff)));
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
      
      Civilian civ = new Civilian(firstname, lastname, age, gender);
      applyLevelUps(civ, (int)((diff * 100) / 8)); // Level up the gangster based on difficulty
      equipRandomFromPool(civ, CIV_EQUIP_POOL); // Give the gangster items from the gangster loot pool
      civ.addMoney(ran.nextInt(10));
      
      return civ;
   }
   
   public ArrayList<Civilian> genCivilianFamily(double diff) {
      ArrayList<Civilian> civs = new ArrayList<Civilian>();
      String lastname = getLineFromFile(LAST_NAMES); // Get random last name
      
//       int adultMaxAge = 55;
//       int adultMinAge = 24;
//       
//       int childMaxAge = 17;
//       int childMinAge = 1;
//       
//       int maxAge = 81;
//       int minAge = 24;
//       
//       
//       boolean gender = (ran.nextDouble() < chanceOfMan ? true : false);
//       String firstname = getLineFromFile((gender ? FIRST_NAMES_M : FIRST_NAMES_F)); // Get Random first name
//       
//       int age = (int)((ran.nextDouble() * (maxAge - minAge)) + minAge);
//       
//       Civilian civ = new Civilian(firstname, lastname, age, gender);
//       applyLevelUps(civ, (int)((diff * 100) / 8)); // Level up the gangster based on difficulty
//       equipRandomFromPool(civ, CIV_EQUIP_POOL); // Give the gangster items from the gangster loot pool
      
      return civs;
   }
   
   public CivilianLocation genCivilianLocation(double diff) {
      double chanceOfShop = 1;
      Civilian owner = genCivilian(diff); // Generate owner of property
      CivilianLocation loc;
      
      if (ran.nextDouble() < chanceOfShop) loc = new CivilianLocation(owner.getFirstName() + "'s " + getLineFromFile(SHOP_NAMES_P2));
      else loc = new CivilianLocation(owner.getLastName() + " Residence");
      loc.addOccupant(owner);
      
      
      return loc;
   }
   
   public Gangster genGangster(double diff) {
      int maxAge = 34;
      int minAge = 15;
      double chanceOfMan = 0.8;
      double chanceOfNickname = 0.2;
      
      // Generate name and gender
      boolean gender = (ran.nextDouble() < chanceOfMan ? true : false);
      String firstname = getLineFromFile((gender ? FIRST_NAMES_M : FIRST_NAMES_F)); // Get Random first name
      String lastname = getLineFromFile(LAST_NAMES); // Get random last name
      int age = (int)((ran.nextDouble() * (maxAge - minAge)) + minAge);
      
      // Instantiate gangster with or without a nickname
      Gangster gangster;
      if (ran.nextDouble() < chanceOfNickname) gangster = new Gangster(firstname, (gender ? getLineFromFile(NICKNAMES_M) : getLineFromFile(NICKNAMES_F)), lastname, age, gender); // Create gangster as specified
      else gangster = new Gangster(firstname, lastname, age, gender); // Create gangster as specified
      
      applyLevelUps(gangster, (int)((diff * 100) / 4)); // Level up the gangster based on difficulty
      equipRandomFromPool(gangster, GANG_EQUIP_POOL); // Give the gangster items from the gangster loot pool
      gangster.addMoney(ran.nextInt(20));
      
      return gangster;
   }
   
   public GangLocation genGangLocation(double diff) {
      GangLocation loc = new GangLocation(getLineFromFile(GANG_LOC_NAMES));
      int amountOfGangMembers = ran.nextInt(((int)(diff * 8))+1);
      for (int i = 0; i < amountOfGangMembers; i++) loc.addOccupant(genGangster(diff));
      return loc;
   }
   
   public Cop genCop(double diff) {
      int maxAge = 55;
      int minAge = 20;
      double chanceOfMan = 0.7;
      
      boolean gender = (ran.nextDouble() < chanceOfMan ? true : false);
      String firstname = getLineFromFile((gender ? FIRST_NAMES_M : FIRST_NAMES_F)); // Get Random first name
      String lastname = getLineFromFile(LAST_NAMES); // Get random last name
      int age = (int)((ran.nextDouble() * (maxAge - minAge)) + minAge);
      String rank = getLineFromFile(POLICE_RANKS_SHORT);
      
      Cop cop = new Cop(rank, firstname, lastname, age, gender);
      applyLevelUps(cop, (int)((diff * 100) / 2)); // Level up the gangster based on difficulty
      equipRandomFromPool(cop, POLICE_EQUIP_POOL); // Give the gangster items from the gangster loot pool
      cop.addMoney(ran.nextInt(50));
      
      return cop;
   }
   
   public CopLocation genCopLocation(double diff, String name) {
      CopLocation loc = new CopLocation(name);
      int amountOfCops = ran.nextInt(((int)(diff * 10))+1);
      for (int i = 0; i < amountOfCops; i++) loc.addOccupant(genCop(diff));
      return loc;
   }
   
   public void equipRandomFromPool(Person person, String pool_filename) {
      Scanner reader = null;
      try {
         File file = new File(DIR_NAME + "/" + pool_filename + ".txt"); // File object
         reader = new Scanner(file); // Scanner opens file
         String line;
         for (int i = 0; i < 4; i++) {
            if (reader.hasNextLine()) {
               String[] items = reader.nextLine().split(" ");
               int itemID = Integer.parseInt(items[ran.nextInt(items.length-1)+1]);
               switch (i) {
                  case 0: person.equipWeapon((Weapon)GameItemManager.getNewItem(itemID)); break; // Get random weapon from pool
                  case 1: person.equipHead((Apparel)GameItemManager.getNewItem(itemID)); break; // Get random head apparel from pool
                  case 2: person.equipTorso((Apparel)GameItemManager.getNewItem(itemID)); break; // Get random torso apparel from pool
                  case 3: person.equipLegs((Apparel)GameItemManager.getNewItem(itemID)); break; // Get random legs apparel from pool
               }
            }
         }
      } catch (FileNotFoundException e) { e.printStackTrace(); }
      if (reader != null) reader.close(); // Close file
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
   
   public void applyLevelUps(Person person, int levels) {
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
      double diff = 1;
      
      /*
      Gangster gangster = pcg.genGangster(diff);
      gangster.printCharacterSheet();
      
      Cop cop = pcg.genCop(diff);
      cop.printCharacterSheet();
      
      Civilian civ = pcg.genCivilian(diff);
      civ.printCharacterSheet();
      
      CivilianLocation civloc = pcg.genCivilianLocation(diff);
      System.out.println(civloc.getName());
      
      civloc.getOccupants().get(0).printCharacterSheet();*/
      
//       GangLocation gangloc = pcg.genGangLocation(diff);
//       System.out.println(gangloc.getName());
//       
//       for (Person person : gangloc.getOccupants()) {
//          person.printCharacterSheet();  
//       }

      CopLocation coploc = pcg.genCopLocation(diff, "South Side Department");
      System.out.println(coploc.getName());
      
      for (Person person : coploc.getOccupants()) {
         person.printCharacterSheet();
      }
   }
}