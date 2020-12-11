
/**
 * The class CommandAttack handles an attack command from the player.
 *
 * @author Theorin Feder
 * @version 0.1
 */
public class CommandAttackCombat extends Command
{
    private String[] tokens = null;
    private Combat combat;
    
    public CommandAttackCombat(Combat combat)
    {
        this.combat = combat;
    }
    
    public boolean isTrigger(String input){
        tokens = input.split(" ", 4);
        if (tokens[0].equalsIgnoreCase("attack")) return true;
        return false;
    }
    
    public void execute(){
        Person attackTarget = null;
        Player player = null;
        
        player = combat.findPlayer(combat);
        
        if(tokens != null && tokens.length == 4)
        {
            attackTarget = findTarget(tokens[1]);
            if(attackTarget == null)return;
            else
            {
                // Attack the target
                attackTarget.takeDamage(combat.calcDamage(player));
                combat.correctInput = true;
            }
        }
    }
    
    public void printOneLineHelp(){
        System.out.println("Attack -- Used to attack other Gangsters");
    }
    
    public void printDetailedHelp(){
        System.out.println("Input: attack [target's first name] with [weapon]");
    }
    
    /*
     * 
     */
    private Person findTarget(String name)
    {
        Person person = null;
        if(combat.isTeamOne)
        {
            for(Person oponent: combat.teamTwo)
            {
                if(oponent.firstName.equalsIgnoreCase(name))
                {
                    person = oponent;
                }
            }
        }
        else
        {
            for(Person oponent: combat.teamOne)
            {
                if(oponent.firstName.equalsIgnoreCase(name))
                {
                    person = oponent;
                }
            }
        }
        return person;
    }
}
