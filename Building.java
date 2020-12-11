import java.util.ArrayList;

public abstract class Building {
   
   protected String name;
   ArrayList<Person> occupants;
   
   public abstract int getFaction();
   public abstract String getFactionString();
}