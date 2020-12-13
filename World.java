public class World {

   private ProceduralContentGenerator pcg;
   private Perlin perlin;
   
   private MapTile[][] map;
   
   public World() {
      pcg = new ProceduralContentGenerator();
      generate(10, 10);
   }
   
   public World(long seed) {
      pcg = new ProceduralContentGenerator(seed);
      perlin = new Perlin(3, 3, 10, 10, seed);
      generate(10, 10);
   }
   
   public World(long seed, int width, int height) {
      pcg = new ProceduralContentGenerator(seed);
      perlin = new Perlin(3, 3, width, height, seed);
      generate(width, height);
   }
   
   public World(String filename) {
      load(filename);
   }
   
   // NOTE: Coud handle generation settings
   private void generate(int width, int height) {
      map = new MapTile[width][height];
      for (int i = 0; i < width; i++) {
         for (int j = 0; j < height; j++) {
            double perlinValue = perlin.getValueAt(i, j); // TODO: Get perlin value for specific tile
            map[i][j] = pcg.genTile((perlinValue + 1) / 2.0);
         }
      }
   }
   
   // Load world from file
   public void load(String filename) {
      // Read the data in the file and load into memory
   }
   
   // Save world as file
   public void save() {
      // Basically will take the values in memory and convert them into a format that will be outputted to a file
   }
   
   public void start() {
      
      // We would put the normal input loop in here
      
      while (true) {
         TextInputManager.prompt();
      }
      
   }
   
   public void handleEvent(GameEvent e) {
      
   }
   
   public static void main(String[] args) {
      int width = 10, height = 10;
      World world = new World(0, width, height);
      //world.start();
      
      for (int x = 0; x < width; x++) {
         for (int y = 0; y < height; y++) {
            Main.print(world.map[x][y]);
         }
      }
      for (int x = 0; x < width; x++) {
         System.out.println();
         for (int y = 0; y < height; y++) {
            System.out.print("[" + world.map[x][y].difficulty + "] ");
         }
      }
   }

}