import java.util.ArrayList;

public abstract class Person {
   
   // Basic Data
   protected boolean dead;
   protected boolean gender;
   protected String firstName;
   protected String lastName;
   protected int age;
   
   // Relationships and Assets
   protected ArrayList<Person> friends;
   protected ArrayList<Person> rivals;
   protected ArrayList<Building> buildings;
   protected ArrayList<GameItem> inventory;
   
   // Stats
   protected int hp; // Health points
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
   
   public int getAge() { return age; }
   public String getName() { return firstName + " " + lastName; }
   public String getFirstName() { return firstName; }
   public String getLastName() { return lastName; }
   public boolean isDead() { return dead; }
   
   public void printCharacterSheet() {
      Main.print("==========================================");
      Main.print("Name: " + getName());
      Main.print("Age: " + age);
      Main.print("Gender: " + (gender ? "Male" : "Female"));
      Main.print("==========================================");
   }
}