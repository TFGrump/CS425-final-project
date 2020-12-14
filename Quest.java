public abstract class Quest {
   
   //int locX, locY; // NOTE: Consider replacing this with other class
   
   // NOTE: Could have quest log
   
   Person giver;
   Player quester;
   
   public Quest(Person giver, Player quester) {
      this.giver = giver;
      this.quester = quester;
   }
   
   public void start() {
      quester.questlog.add(this);
   }
   public abstract boolean isComplete(); // Will check quest conditions and see if they are met
   //public GameEvent finish(); // Will finish the quest and return assosiated GameEvent
   public abstract void finish(); // Will finish the quest
   // NOTE: Could later expand into multi-step quests by using a Queue and having a step() method.
   // Or rather perhaps that could just be done with this class quest as a "questline"
   public abstract void printBriefDesc();
}