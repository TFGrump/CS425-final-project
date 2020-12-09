public class Player extends Person {
    public Player(String firstName, String lastName, int age, boolean gender, boolean dead) {
        super(firstName, lastName, age, gender, dead);
    }
    
    public String getType(){
        return "Player";
    }
}
