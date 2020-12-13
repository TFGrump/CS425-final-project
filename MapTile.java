import java.util.ArrayList;
import java.io.Serializable;

public class MapTile {
   
   // If we do organized crime this is basically a city block
   
   // Stuff to store:
   // Type (Biome or something else along those lines)
   // Keep track of things on this tile
   
   double difficulty;
   String name;
   int x, y; // Coordinates on larger map
   ArrayList<Building> buildings;
   
   public MapTile(String name, double difficulty) {
      this.name = name;
      this.difficulty = difficulty;
      buildings = new ArrayList<Building>();
   }
   
   public ArrayList<Building> getBuildings() { return buildings; }
   public void addBuilding(Building building) { buildings.add(building); }
   
   public String toString() {
      String str = "========" + name + "========\n";
      for (Building loc: buildings) {
         str += loc.getName() + " (" + loc.getOccupants().size() + ")\n";
      }
      return str;
   }
}