import java.util.ArrayList;

public abstract class Building {
   
   protected String name;
   ArrayList<Person> occupants;
   
   public Building(String name) {
      this.name = name;
      occupants = new ArrayList<Person>();
   }
   
   public String getName() { return name; }
   
   public void addOccupant(Person person) {
      occupants.add(person);
   }
   public void removeOccupant(Person person) {
      occupants.remove(person);
   }
   public ArrayList<Person> getOccupants() { return occupants; }
   public abstract int getFaction();
   public abstract String getFactionString();
   
   public String toString() {
      String str = "========" + name + "========\n";
      for (Person person: occupants) {
         str += person.getName() + " (" + person.getType() + ")\n";
      }
      return str;
   }
}