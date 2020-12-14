import java.util.ArrayList;

public class Player extends Person {

   int x, y;
   Building location;
   boolean isInCombat;
   ArrayList<Quest> questlog;

   public Player(String firstName, String lastName, int age, boolean gender) {
      super(firstName, lastName, age, gender);
      x = 0;
      y = 0;
      location = null;
      isInCombat = false;
      questlog = new ArrayList<Quest>();
   }
   
   public void pingQuestCompletion() {
      ArrayList<Quest> done = new ArrayList<>();
        for (Quest quest: questlog) {
            if (quest.isComplete()) { done.add(quest); quest.finish(); }
        }
        for(Quest quest: done) {
            questlog.remove(quest);
        }
   }

   public String getType() {
      return "player";
   }

}
