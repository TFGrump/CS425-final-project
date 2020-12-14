import java.util.Random;

public class QuestKill extends Quest {
   
   Person target;
   int x, y;
   
   public QuestKill(Person giver, Player quester, Person target) {
      super(giver, quester);
      this.target = target;
   }
   
   public void start() {
      super.start();
      x = quester.x;
      y = quester.y;
      System.out.println(giver.getName() + ": \"I need you to go kill " + target.getName() + " for me.\"");
      System.out.println(giver.getName() + ": \"They should be somewhere in this neighborhood.\"" + " (" + x + ", " + y + ")"); 
   }
   public boolean isComplete() { return target.isDead(); }
   public void finish() {
      Random ran = new Random();
      GameItem randomItem = GameItemManager.getNewItem(ran.nextInt(50));
      System.out.println("=============[QUEST COMPLETE]=================");
      System.out.println(target.getName() + " is dead.");
      System.out.println(giver.getName() + " has rewarded you with " + randomItem.getName());
      System.out.println("==============================================");
      quester.getInventory().add(randomItem);
      super.finish();
   }
   public void printBriefDesc() {
      System.out.println("[KILL] -- " + giver.getName() + " wants you to kill " + target.getName() + " (" + x + ", " + y + ")");
   }
}