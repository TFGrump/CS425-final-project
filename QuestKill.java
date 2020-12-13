public class QuestKill extends Quest {
   
   Person target;
   
   public QuestKill(Person giver, Person target) {
      super(giver);
      this.target = target;
   }
   
   public void start() {}
   public boolean isComplete() { return target.isDead(); }
   public void finish() { System.out.println("Quest complete!"); }
}