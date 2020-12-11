import java.util.ArrayList;
import java.io.Serializable;

public class MapTile {
   
   // If we do organized crime this is basically a city block
   
   // Stuff to store:
   // Type (Biome or something else along those lines)
   // Keep track of things on this tile
   
   double difficulty;
   String name;
   ArrayList<Building> buildings;
   
   public MapTile(double difficulty) {
      this.difficulty = difficulty;
      buildings = new ArrayList<Building>();
   }
}