import java.util.ArrayList;

public abstract class Person {
   
   // Basic Data
   protected boolean dead;
   protected boolean gender;
   protected String firstName;
   protected String lastName;
   protected int age;
   
   // Equipped Items
   protected Weapon weaponSlot;
   protected Apparel headSlot;
   protected Apparel torsoSlot;
   protected Apparel legsSlot;
   
   // Relationships and Assets
   protected ArrayList<Person> friends;
   protected ArrayList<Person> rivals;
   protected ArrayList<Building> buildings;
   protected ArrayList<GameItem> inventory;
   
   // Stats
   protected int hp; // Health points
   protected int maxHp; // Maximum Health points
   protected int strength; // Strength
   protected int perception; // Perception
   protected int endurance; // Endurance
   protected int charisma; // Charisma
   protected int intelligence; // Intelligence
   protected int agility; // Agility
   protected int luck; // Luck
   protected ArrayList<Trait> traits;
   
   public Person(String firstName, String lastName, int age, boolean gender, boolean dead) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.gender = gender;
      this.dead = dead;
      friends = new ArrayList<Person>();
      rivals = new ArrayList<Person>();
      buildings = new ArrayList<Building>();
   }
   
   // Getters
   public boolean getGender() { return gender; }
   public int getAge() { return age; }
   public String getName() { return firstName + " " + lastName; }
   public String getFirstName() { return firstName; }
   public String getLastName() { return lastName; }
   public boolean isDead() { return dead; }
   public ArrayList<Person> getFriends() { return friends; }
   public ArrayList<Person> getRivals() { return rivals; }
   public ArrayList<Building> getBuildings() { return buildings; }
   public ArrayList<GameItem> getInventory() { return inventory; }
   public int getBaseStr() { return strength; }
   public int getModStr() { return headSlot.getStrMod() + torsoSlot.getStrMod() + legsSlot.getStrMod(); }
   public int getBasePer() { return perception; }
   public int getModPer() { return headSlot.getPerMod() + torsoSlot.getPerMod() + legsSlot.getPerMod(); }
   public int getBaseEnd() { return endurance; }
   public int getModEnd() { return headSlot.getEndMod() + torsoSlot.getEndMod() + legsSlot.getEndMod(); }
   public int getBaseChr() { return charisma; }
   public int getModChr() { return headSlot.getChrMod() + torsoSlot.getChrMod() + legsSlot.getChrMod(); }
   public int getBaseInt() { return intelligence; }
   public int getModInt() { return headSlot.getIntMod() + torsoSlot.getIntMod() + legsSlot.getIntMod(); }
   public int getBaseAgi() { return agility; }
   public int getModAgi() { return headSlot.getAgiMod() + torsoSlot.getAgiMod() + legsSlot.getAgiMod(); }
   public int getBaseLuc() { return luck; }
   public int getModLuc() { return headSlot.getLucMod() + torsoSlot.getLucMod() + legsSlot.getLucMod(); }
   
   // Take/Heal Damage and death
   public void healDamage(int damage) {
     if (this.dead) return; // Can't heal dead people
     this.hp += damage;
     if (this.hp > maxHp) this.hp = maxHp;
   }
   public void takeDamage(int damage) {
      this.hp -= damage;
      if (this.hp <= 0) this.die();
   }
   public void die() {
      this.dead = true;
      this.hp = 0;
   }
   
   // Getters and setters related to equipped items
   public Weapon getEquippedWeapon() { return weaponSlot; }
   public Apparel getEquippedHead() { return headSlot; }
   public Apparel getEquippedTorso() { return torsoSlot; }
   public Apparel getEquippedLegs() { return legsSlot; }
   
   public void equipWeapon(Weapon weapon) { this.weaponSlot = weapon; }
   public void equipHead(Apparel apparel) { this.headSlot = apparel; }
   public void equipTorso(Apparel apparel) { this.torsoSlot = apparel; }
   public void equipLegs(Apparel apparel) { this.legsSlot = apparel; }
   
   public void printCharacterSheet() {
      Main.print("==========================================");
      Main.print("Name: " + getName());
      Main.print("Age: " + age);
      Main.print("Gender: " + (gender ? "Male" : "Female"));
      Main.print("==========================================");
   }
   
   public abstract String getType();
}