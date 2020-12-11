import java.util.ArrayList;

/**
 * The class Combat is where the combat between two teams happens
 *
 * @author Theorin Feder
 * @version 0.1
 */
public class Combat
{
    Person[] teamOne, teamTwo;
    boolean isTeamOne = false; //Will be assigned true if the player is on teamOne
    boolean correctInput; // Will be assigned true once the player has correctly given an attack command

    public Combat(Person[] teamOne, Person[] teamTwo)
    {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    /*
     * Whichever team has the higher Agility stat collectively will go first
     * The Attack Order will be the order in which they appear in the array (which is sorted by the Persons speed)
     * The Combat ends when all of the Persons died on a team (or otherwise, like an escape)
     */
    public void startCombat()
    {
        GameEvent gameEvent = null;
        sort(teamOne);
        sort(teamTwo);
        do{
            for(Person person: teamOne) turn(person, true);
            for(Person person: teamTwo) turn(person, false);
        }while(teamOne.length != 0 && teamTwo.length != 0);
    }

    /*
     * A person takes a turn in combat
     */
    private void turn(Person person, boolean team)
    {
        if(person.getType().equalsIgnoreCase("Player")) {
            isTeamOne = team;
            correctInput = false;
            while(!correctInput){
                TextInputManager.prompt();
            }
        }
        else AIAttack(person);
    }

    /*
     * The AI will attack a random opponent since 
     * we do not have behavior trees for the AI to act upon.
     * 
     * @param   The Gangster that is randomly attacking
     */
    private void AIAttack(Person gangster)
    {

    }

    void sort(Person[] arr) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i].getBaseAgi()+arr[i].getModAgi();
            Person tempPerson = arr[i];
            int j = i - 1; 

            /* Move elements of arr[0..i-1], that are 
            greater than key, to one position ahead 
            of their current position */
            while (j >= 0 && arr[j].getBaseAgi()+arr[j].getModAgi() < key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = tempPerson; 
        } 
    } 

    public Player findPlayer(Combat combat)
    {
        Player player = null;

        if(combat.isTeamOne)
        {
            for(Person person: combat.teamTwo)
            {
                if(person.getType().equalsIgnoreCase("player"))
                {
                    player = (Player)person;
                }
            }
        }
        else
        {
            for(Person person: combat.teamTwo)
            {
                if(person.getType().equalsIgnoreCase("player"))
                {
                    player = (Player)person;
                }
            }
        }

        return player;
    }

    public int calcDamage(Person person)
    {
        int damage = 0;
        int hitThreshold = (int)(20.0 * person.getEquippedWeapon().getAccuracy() + 1);
        int luckThreshold = (int)(20.0 * ((person.getBaseLuc()+person.getModLuc())/100.0));
        if(person.getEquippedWeapon().getMag() != 0)
        {
            for(int i = 0; i < person.getEquippedWeapon().getFirerate(); i++)
            {
                if((int)(20*Math.random()) < hitThreshold)
                    damage+=person.getEquippedWeapon().getDamage();
                if((int)(20*Math.random()) < luckThreshold)
                    damage *= 2;
            }
            person.getEquippedWeapon().shootBullets(person.getEquippedWeapon().getFirerate());
        }
        else 
            person.getEquippedWeapon().reload();
        return damage;
    }
}
