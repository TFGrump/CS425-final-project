public class EventKill extends GameEvent {
   
   public EventKill(Person person) {
      this.target = person;
   }
   
   public void execute() {
      ((Person)target).die();
   }
}