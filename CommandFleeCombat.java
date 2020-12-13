
/**
 * The class CommandFleeCombat handles the case in which the player
 * wants to flee from combat.
 *
 * @author Theorin Feder
 * @version 0.1
 */
public class CommandFleeCombat extends Command
{
    Combat combat;

    public CommandFleeCombat(Combat combat)
    {
        this.combat = combat;
    }

    public boolean isTrigger(String input)
    {
        return input.equalsIgnoreCase("flee");
    }

    public void execute()
    {
        combat.correctInput = true;
        boolean didFlee = (combat.isTeamOne ? (combat.getTotalSpeed(combat.teamOne) - combat.getTotalSpeed(combat.teamTwo)) : (combat.getTotalSpeed(combat.teamTwo) - combat.getTotalSpeed(combat.teamOne))) > 0;
        combat.flee = didFlee;
        if(!didFlee)
            System.out.println("You cannot escape combat.");
    }

    public void printOneLineHelp()
    {
        System.out.println("Flee -- Escape combat");
    }

    public void printDetailedHelp()
    {
    }
}
