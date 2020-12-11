public abstract class Quest {
   
   //int locX, locY; // NOTE: Consider replacing this with other class
   
   // NOTE: Could have quest log
   
   Person giver;
   
   public Quest(Person giver) {
      this.giver = giver;
   }
   
   public void start();
   public boolean isComplete(); // Will check quest conditions and see if they are met
   public GameEvent finish(); // Will finish the quest and return assosiated GameEvent
   
   // NOTE: Could later expand into multi-step quests by using a Queue and having a step() method.
   // Or rather perhaps that could just be done with this class quest as a "questline"
}