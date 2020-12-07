public class World {

   private ProceduralContentGenerator pcg;
   private Perlin perlin;
   
   private MapTile[][] map;
   
   public World() {
      pcg = new ProceduralContentGenerator();
   }
   
   public World(long seed) {
      pcg = new ProceduralContentGenerator(seed);
   }
   
   // NOTE: Coud handle generation settings
   private void generate(int width, int height) {
      MapTile[][] map = new MapTile[width][height];
      perlin = new Perlin(3, 3, width, height);
      for (int i = 0; i < width; i++) {
         for (int j = 0; j < height; j++) {
            double perlinValue = perlin.getValueAt(i, j); // TODO: Get perlin value for specific tile
            map[i][j] = pcg.genTile(perlinValue);
         }
      }
   }
   
   // Load world from file
   public void load() {
      // Read the data in the file and load into memory
   }
   
   // Save world as file
   public void save() {
      // Basically will take the values in memory and convert them into a format that will be outputted to a file
   }
   
   public void start() {
      
      // We would put the normal input loop in here
      
      
      
   }
   
   public void handleEvent(GameEvent e) {
      
   }

}