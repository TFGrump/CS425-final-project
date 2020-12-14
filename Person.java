import java.util.ArrayList;

public abstract class Person {
   
   // Basic Data
   protected boolean dead;
   protected boolean gender;
   protected String firstName;
   protected String lastName;
   protected int age;
   
   // Equipped Items
   protected Weapon weaponSlot = null;
   protected Apparel headSlot = null;
   protected Apparel torsoSlot = null;
   protected Apparel legsSlot = null;
   
   // Relationships and Assets
   protected ArrayList<Person> friends;
   protected ArrayList<Person> rivals;
   protected ArrayList<GameItem> inventory;
   protected int money;
   
   // Stats
   protected final int SPECIAL_MIN = 1;
   protected int strength = SPECIAL_MIN; // Strength
   protected int perception = SPECIAL_MIN; // Perception
   protected int endurance = SPECIAL_MIN; // Endurance
   protected int charisma = SPECIAL_MIN; // Charisma
   protected int intelligence = SPECIAL_MIN; // Intelligence
   protected int agility = SPECIAL_MIN; // Agility
   protected int luck = SPECIAL_MIN; // Luck
   protected int maxHp = endurance*5; // Maximum Health points
   protected int hp = maxHp; // Health points
   protected ArrayList<Trait> traits;
   
   public Person(String firstName, String lastName, int age, boolean gender) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.gender = gender;
      this.dead = false;
      friends = new ArrayList<Person>();
      rivals = new ArrayList<Person>();
      this.inventory = new ArrayList<GameItem>();
      this.money = 0;
   }
   
   public void levelUp(char c) {
      switch (c) {
         case 's': strength++; break;
         case 'p': perception++; break;
         case 'e': endurance++; maxHp += 5; break;
         case 'c': charisma++; break;
         case 'i': intelligence++; break;
         case 'a': agility++; break;
         case 'l': luck++; break;
         default: System.out.println("ERROR: Not valid special stat char (" + c + ")");
      }
   }
   
   // Getters for special stats
   public int getBaseStr() { return strength; }
   public int getBasePer() { return perception; }
   public int getBaseEnd() { return endurance; }
   public int getBaseChr() { return charisma; }
   public int getBaseInt() { return intelligence; }
   public int getBaseAgi() { return agility; }
   public int getBaseLuc() { return luck; }
   public int getModStr() {
      return (headSlot != null ? headSlot.getStrMod() : 0)
           + (torsoSlot != null ? torsoSlot.getStrMod() : 0)
           + (legsSlot != null ? legsSlot.getStrMod() : 0);
   }
   public int getModPer() {
      return (headSlot != null ? headSlot.getPerMod() : 0)
           + (torsoSlot != null ? torsoSlot.getPerMod() : 0)
           + (legsSlot != null ? legsSlot.getPerMod() : 0);
   }
   public int getModEnd() {
      return (headSlot != null ? headSlot.getEndMod() : 0)
           + (torsoSlot != null ? torsoSlot.getEndMod() : 0)
           + (legsSlot != null ? legsSlot.getEndMod() : 0);
   }
   public int getModChr() {
      return (headSlot != null ? headSlot.getChrMod() : 0)
           + (torsoSlot != null ? torsoSlot.getChrMod() : 0)
           + (legsSlot != null ? legsSlot.getChrMod() : 0);
   }
   public int getModInt() {
      return (headSlot != null ? headSlot.getIntMod() : 0)
           + (torsoSlot != null ? torsoSlot.getIntMod() : 0)
           + (legsSlot != null ? legsSlot.getIntMod() : 0);
   }
   public int getModAgi() {
      return (headSlot != null ? headSlot.getAgiMod() : 0)
           + (torsoSlot != null ? torsoSlot.getAgiMod() : 0)
           + (legsSlot != null ? legsSlot.getAgiMod() : 0);
   }
   public int getModLuc() {
      return (headSlot != null ? headSlot.getLucMod() : 0)
           + (torsoSlot != null ? torsoSlot.getLucMod() : 0)
           + (legsSlot != null ? legsSlot.getLucMod() : 0);
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
   public ArrayList<GameItem> getInventory() { return inventory; }
   
   
   
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
   
   // Getters and setters for currency
   public int getMoney() { return money; }
   public void addMoney(int moneyToAdd) { money += moneyToAdd; }
   public void loseMoney(int moneyLost) { money = Math.max(money - moneyLost, 0); }
   
   public void printCharacterSheet() {
      Main.print("==========================================");
      Main.print("Name: " + getName());
      Main.print("Age: " + age);
      Main.print("Gender: " + (gender ? "Male" : "Female"));
      Main.print("==SPECIAL==");
      Main.print("Strength: \t(" + strength + "/" + getModStr() + "/" + (strength + getModStr()) + ")");
      Main.print("Perception: \t(" + perception + "/" + getModPer() + "/" + (perception + getModPer()) + ")");
      Main.print("Endurance: \t(" + endurance + "/" + getModEnd() + "/" + (endurance + getModEnd()) + ")");
      Main.print("Charisma: \t(" + charisma + "/" + getModChr() + "/" + (charisma + getModChr()) + ")");
      Main.print("Intelligence: \t(" + intelligence + "/" + getModInt() + "/" + (intelligence + getModInt()) + ")");
      Main.print("Agility: \t(" + agility + "/" + getModAgi() + "/" + (agility + getModAgi()) + ")");
      Main.print("Luck: \t(" + luck + "/" + getModLuc() + "/" + (luck + getModLuc()) + ")");
      Main.print("==EQUIPMENT==");
      Main.print("Weapon: \t\"" + weaponSlot.getName() + "\"");
      Main.print("Head: \t\"" + headSlot.getName() + "\"");
      Main.print("Torso: \t\"" + torsoSlot.getName() + "\"");
      Main.print("Legs: \t\"" + legsSlot.getName() + "\"");
      Main.print("==========================================");
   }
   
   public abstract String getType();
}