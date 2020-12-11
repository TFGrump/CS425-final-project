
/**
 * The class CommandGetOponents will print out the names of the opposing team.
 *
 * @author Theorin Feder
 * @version 0.1
 */
public class CommandGetOpponentsCombat extends Command
{
    Combat combat;
    
    public CommandGetOpponentsCombat(Combat combat)
    {
        this.combat = combat;
    }
    
    public boolean isTrigger(String input)
    {
        if(input.equalsIgnoreCase("get opponents"))return true;
        return false;
    }
    
    public void execute()
    {
        System.out.println("Opponents:");
        if(combat.isTeamOne)
        {
            for(Person opponent: combat.teamTwo)
            {
                System.out.println(opponent.firstName);
            }
        }
        else
        {
            for(Person opponent: combat.teamOne)
            {
                System.out.println(opponent.firstName);
            }
        }
    }
    
    public void printOneLineHelp()
    {
        System.out.println("Get opponents -- Lists the opponents' first name");
    }
    
    public void printDetailedHelp()
    {
    }
}
