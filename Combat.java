import java.util.ArrayList;

/**
 * Write a description of class combat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Combat
{
    ArrayList<Person> teamOne, teamTwo;
    
    public Combat(ArrayList<Person> teamOne, ArrayList<Person> teamTwo)
    {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        startCombat();
    }
    
    /*
     * Team One will attack before Team Two
     * The Attack Order will be the order in which they appear in the ArrayList
     * The Combat ends when all of the Persons died on a team (or otherwise, like an escape)
     * 
     * @Return Returs a GameEvent(whatever that is)
     */
    private GameEvent startCombat()
    {
        GameEvent gameEvent = null;
        return gameEvent;
    }
    
    /*
     * A person takes a turn in combat
     */
    private void turn(Person person)
    {
    }
}
