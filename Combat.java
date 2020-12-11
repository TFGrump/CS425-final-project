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
     */
    private void start()
    {
        // Repeatedly call doTurn() and check if the combat should end or not.  May need to exit doTurn() early if all on one side is dead.
        // (More elegant option than exiting doTurn() though may be to simply skip a turn for NPC or Player if there are no enemies, then it will fall through naturally)
    }
    
    /*
     * A person takes a turn in combat
     */
    private void doTurn()
    {
      // Get the combatants in turn order using below helper method
      
      //Iterate through each and do their moves, or prompt the player if it is the players turn
      
    }
    
    private Person[] getCombatantsInTurnOrder() {
      
    }
}
