import java.util.ArrayList;

/**
 * The class Combat is where the combat between two teams happens
 *
 * @author Theorin Feder
 * @version 0.1
 */
public class Combat
{
    private class Team
    {
        Person[] team;
        boolean isTeamOne;

        public Team(Person[] team, boolean isTeamOne)
        {
            this.team = team;
            this.isTeamOne = isTeamOne;
        }

        public Person[] getTeam(){ return team; }

        public Person personAt(int num){ return team[num]; }

        public void sort() 
        { 
            int n = team.length; 
            for (int i = 1; i < n; ++i) { 
                int key = team[i].getBaseAgi()+team[i].getModAgi();
                Person tempPerson = team[i];
                int j = i - 1; 

                /* Move elements of arr[0..i-1], that are 
                greater than key, to one position ahead 
                of their current position */
                while (j >= 0 && team[j].getBaseAgi()+team[j].getModAgi() < key) { 
                    team[j + 1] = team[j]; 
                    j = j - 1; 
                } 
                team[j + 1] = tempPerson; 
            } 
        }

        public int getTotalSpeed()
        {
            int totalSpeed = 0;

            for(Person person: team)
            {
                totalSpeed += person.getBaseAgi()+person.getModAgi();
            }

            return totalSpeed;
        }

        public Person removePerson(Person person)
        {
            // Removes Person from the team
            Person[] newTeam = new Person[team.length-1];
            for(Person dude: team)
            {
                if(dude == person) continue;
            }
            team = newTeam;
            return person;
        }

        public Player findPlayer()
        {
            Player player = null;
            for(Person person: team)
            {
                if(person.getType().equalsIgnoreCase("player"))
                {
                    player = (Player)person;
                    break;
                }
            }
            return player;
        }

        public int length(){ return team.length; }

        public boolean isTeamOne(){ return isTeamOne; }
    }

    Team teamOne, teamTwo; // Just so I can put the faster team first for attacking
    boolean isTeamOne; //Will be assigned true if the player is on teamOne
    boolean correctInput; // Will be assigned true once the player has correctly given an attack command
    boolean flee;
    ArrayList<Person> deadPeople;

    public Combat(Person[] teamOne, Person[] teamTwo)
    {
        this.teamOne = new Team(teamOne, true);
        this.teamTwo = new Team(teamTwo, false);
        deadPeople = new ArrayList<Person>();
        flee = false;
        correctInput = false;
        isTeamOne = false;
    }

    /*
     * Whichever team has the higher Agility stat collectively will go first
     * The Attack Order will be the order in which they appear in the array (which is sorted by the Persons speed)
     * The Combat ends when all of the Persons died on a team (or otherwise, like an escape)
     * The opposing team never flees.
     */
    public ArrayList<Person> startCombat()
    {
        GameEvent gameEvent = null;
        teamOne.sort();
        teamTwo.sort();
        Team[] teamAttackOrder = whosFirst(teamOne, teamTwo);
        
        do{
            for(Team team: teamAttackOrder)
            {
                for(Person person: team.getTeam())
                {
                    turn(person, team.isTeamOne());
                }
            }
        }while(teamOne.length() != 0 && teamTwo.length() != 0 && !flee);
        
        if(teamOne.length() == 0)
        {
            if(isTeamOne)
                System.out.println("You lose, you loser.");
            else
                System.out.println("You win, you winner.");
        }
        else if(teamTwo.length() == 0)
        {
            if(!isTeamOne)
                System.out.println("You lose, you loser.");
            else
                System.out.println("You win, you winner.");
        }
        else
        {
            System.out.println("You have fled from combat. Coward.");
        }
        
        return deadPeople;
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
        else if (!flee) AIAttack(person, team);
    }

    /*
     * The AI will attack a random opponent since 
     * we do not have behavior trees for the AI to act upon.
     * 
     * @param   The Gangster that is randomly attacking
     */
    private void AIAttack(Person gangster, boolean team)
    {
        // The AI does attack stuff
        int damage = calcDamage(gangster);
        Person target = team ? teamTwo.personAt((int)(Math.random()*teamTwo.length())) : teamOne.personAt((int)(Math.random()*teamOne.length()));

        target.takeDamage(damage);
        logAttack(gangster, target, damage);
        if(target.isDead())
        {
            logDeath(target);
            deadPeople.add(teamOne.removePerson(target));
        }
    }

    public Team[] whosFirst(Team teamOne, Team teamTwo)
    {
        Team[] attackOrder = new Team[2];

        if(teamOne.getTotalSpeed() < teamTwo.getTotalSpeed())
        {
            attackOrder[0] = teamTwo;
            attackOrder[1] = teamOne;
        }
        else
        {
            attackOrder[0] = teamOne;
            attackOrder[1] = teamTwo;
        }

        return attackOrder;
    }

    public Player findPlayer(Combat combat){ return (combat.isTeamOne ? teamOne.findPlayer() : teamTwo.findPlayer()); }

    public int calcDamage(Person person)
    {
        int totalDamage = 0;
        int hitThreshold = (int)(20.0 * person.getEquippedWeapon().getAccuracy() * (1 + (person.getBasePer() + person.getModPer())/100.0));
        int luckThreshold = (int)(20.0 * ((person.getBaseLuc()+person.getModLuc())/100.0));
        if(person.getEquippedWeapon().getMag() != 0)
        {
            for(int i = 0; i < person.getEquippedWeapon().getFirerate(); i++)
            {
                int damage = 0;
                if((int)(20*Math.random()) < hitThreshold)
                    damage+=person.getEquippedWeapon().getDamage();
                if((int)(20*Math.random()) < luckThreshold)
                    damage *= 2;
                totalDamage += damage;
            }
            person.getEquippedWeapon().shootBullets(person.getEquippedWeapon().getFirerate());
        }
        else 
            person.getEquippedWeapon().reload();
        return totalDamage;
    }

    public void logAttack(Person personOne, Person personTwo, int damage)
    {
        System.out.println(personOne.getFirstName() + " attacked " + personTwo.getFirstName() + " and did " + damage + " damage.");
    }
    
    public void logDeath(Person person)
    {
        System.out.println(person.getFirstName() + " is now dead.");
    }

    public void removePerson(Person person){ deadPeople.add(isTeamOne ? teamTwo.removePerson(person) : teamOne.removePerson(person)); }

    public int getTotalSpeed(Team team){ return team.getTotalSpeed(); }
    
    public Person[] getTeam(Team team){ return team.getTeam(); }
}
