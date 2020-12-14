import java.util.Random;

public class Perlin {

   Vector[][] vGrid;
   Random ran;
   int pWidth, pHeight;
   int width, height;
   double cell_w, cell_h;
   
   public Perlin(int pWidth, int pHeight, int width, int height) {
	      this.pWidth = pWidth;
	      this.pHeight = pHeight;
	      this.width = width;
	      this.height = height;
		   this.cell_w = width / (double)(pWidth - 1); // The width of a cell
		   this.cell_h = height / (double)(pHeight - 1); // The height of a cell
	      
	      vGrid = new Vector[pWidth][pHeight];
	      ran = new Random();
	      for (int i = 0; i < pWidth; i++) {
	         for (int j = 0; j < pHeight; j++) {
	            vGrid[i][j] = getRandomVector(2);
	         }
	      }
   }

   public Perlin(int pWidth, int pHeight, int width, int height, long seed) {
      this.pWidth = pWidth;
      this.pHeight = pHeight;
      this.width = width;
      this.height = height;
	   this.cell_w = width / (double)(pWidth - 1); // The width of a cell
	   this.cell_h = height / (double)(pHeight - 1); // The height of a cell
      
      vGrid = new Vector[pWidth][pHeight];
      ran = new Random(seed);
      for (int i = 0; i < pWidth; i++) {
         for (int j = 0; j < pHeight; j++) {
            vGrid[i][j] = getRandomVector(2);
         }
      }
   }
   
   public double getValueAt(int x, int y) {
      return getValueAt(x, y, (byte)2);
   }
   
   public double getValueAt(int x, int y, byte mode) {
         int vec_id_x = (int)(x / cell_w) % (pWidth - 1); // X index of vector grid
       	int vec_id_y = (int)(y / cell_h) % (pHeight - 1); // Y index of vector grid
      	double cellspace_x = (x / cell_w) - vec_id_x; // Convert X to cellspace
       	double cellspace_y = (y / cell_h) - vec_id_y; // Convert Y to cellspace
       	while (cellspace_x > 1) cellspace_x--;
       	while (cellspace_y > 1) cellspace_y--;
      	Vector tl_dist = new Vector(cellspace_x, cellspace_y); // Distance from top left corner to point in cellspace
      	Vector tr_dist = new Vector(cellspace_x - 1, cellspace_y); // Distance from top right corner to point in cellspace
      	Vector bl_dist = new Vector(cellspace_x, cellspace_y - 1); // Distance from bottom left corner to point in cellspace
      	Vector br_dist = new Vector(cellspace_x - 1, cellspace_y - 1); // Distance from bottom right corner to point in cellspace
       	Vector tl_grad = vGrid[vec_id_x][vec_id_y]; // Gradient in top left corner
      	Vector tr_grad = vGrid[vec_id_x + 1][vec_id_y]; // Gradient in top right corner
      	Vector bl_grad = vGrid[vec_id_x][vec_id_y + 1]; // Gradient in bottom left corner
       	Vector br_grad = vGrid[vec_id_x + 1][vec_id_y + 1]; // Gradient in bottom right corner
     
       	// Calculate the dot products using the gradient and distance vectors
       	double tl_dot = (tl_grad.getX() * tl_dist.getX()) + (tl_grad.getY() * tl_dist.getY()); // Dot product for top left corner
       	double tr_dot = (tr_grad.getX() * tr_dist.getX()) + (tr_grad.getY() * tr_dist.getY()); // Dot product for top right corner
       	double bl_dot = (bl_grad.getX() * bl_dist.getX()) + (bl_grad.getY() * bl_dist.getY()); // Dot product for bottom left corner
       	double br_dot = (br_grad.getX() * br_dist.getX()) + (br_grad.getY() * br_dist.getY()); // Dot product for bottom right corner
       
       	// Uses the dot products for bilinear interpolation
       	double x1 = interpolation(tl_dot, tr_dot, cellspace_x, mode); // Interpolate between top
       	double x2 = interpolation(bl_dot, br_dot, cellspace_x, mode); // Interpolate between bottom
       	return interpolation(x1, x2, cellspace_y, mode); // Interpolate across
   }
   
   private double interpolation(double p, double q, double s, byte mode) {
      switch (mode) {
         case 0: return linearInterpolation(p, q, s); // Linear
         case 1: return cosineInterpolation(p, q, s); // Cosine
         case 2: return cubicInterpolation(p, q, s);  // Cubic
         default: return -1000; // TODO: Modify this control flow to be better -- throw an error or something
      }
   }
   
   private double linearInterpolation(double p, double q, double s) {
      return p*(1.0f-s)+(q*s);
   }
   
   private double cosineInterpolation(double p, double q, double s) {
   	double f = (1 - Math.cos(s * Math.PI)) * 0.5;
		return p*(1-f)+(q*f);
   }
   
   private double cubicInterpolation(double p, double q, double s) {
      double f = (3*s*s) - (2*s*s*s); // 3s^2 + 2s^3
		return p*(1-f)+(q*f);
   }
   
   private Vector getRandomVector(int dimensions) {
      double max = 1.0;
      double min = -1.0;
      Vector v = new Vector(dimensions);
      for (int i = 0; i < dimensions; i++)
         v.set(i, ((ran.nextDouble() * (max - min)) + min));
      return v;
   }
   
   private class Vector {
      
      private double[] values;
      
      // Default to 2D vector
      public Vector() {
         values = new double[2];
      }
      
      public Vector(double x, double y) {
         values = new double[2];
         values[0] = x;
         values[1] = y;
      }
      
      public Vector(int dimensions) {
         values = new double[dimensions];
      }
      
      // Getters
      public double getX() { return values[0]; }
      public double getY() { return values[1]; }
      public double getZ() { return values[2]; }
      public double get(int index) { return values[index]; }
      
      // Setters
      public void setX(double newValue) { values[0] = newValue; }
      public void setY(double newValue) { values[1] = newValue; }
      public void setZ(double newValue) { values[2] = newValue; }
      public void set(int index, double newValue) { values[index] = newValue; }
      
      // Operations
      public double dot(Vector v) {
         double sum = 0;
         for (int i = 0; i < Math.min(this.values.length, v.values.length); i++) sum += this.values[i] * v.values[i];
         return sum;
      }
   }
   
   public static void main(String[] args) {
      Perlin perlin = new Perlin(3, 3, 5, 5, 0);
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            System.out.print("[" + perlin.getValueAt(i, j) + "] ");
         }
         System.out.println();
      }
   }
}