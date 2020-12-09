import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public
abstract class GameItem {

   //static private
   final private static String in = "items/items.txt";
	
   //static public
   public static GameItem findItem(int id) {

	   FileReader input = null;
	   BufferedReader reader = null;
	   
	   try {
		   
		   input = new FileReader(in);
		   reader = new BufferedReader(input);
		   
	   }
	   catch(FileNotFoundException e){
		   
		   System.out.println(e.getMessage());
		   e.printStackTrace();
		   System.exit(0);
		   
	   }
	   
	   String s = null;
	   
	   try {
			   
		   while((s = reader.readLine()) != null && id != 0) {id--;}
		   
	   }
	   catch(IOException e){
		   
		   System.out.println(e.getMessage());
		   e.printStackTrace();
		   System.exit(0);
		   
	   }
	   
	   String name = s.split("\"", 3)[1];
	   float weight = 0;
	   float value = 0;
	   String type = s.split("(|)", 3)[1];
	   if(type.equals("Weapon")) {
		   
		   
		   
	   }
	   else if(type.equals("WearbleItem")) {
		   
		   
	   }
	   else {
		   
		   System.out.println("Item " + id + " is not one of our defined types!");
		   return null;
		   
	   }
	   
	   return null;
	   
   }
   
   //private
   private String name;
   private float weight;
   private float value;
   
   //protected
   protected GameItem(String name, float weight, float value) {
	   this.name = name;
	   this.value = value;
	   this.weight = weight;
   }

   //public
   public String getName() {
	   return this.name;
   }
	
   public float getWeight() {
	   return this.weight;
   }

   public float getValue() {
	   return this.value;
   }

   
}