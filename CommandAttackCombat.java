
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

        if(tokens != null && tokens.length == 2)
        {
            attackTarget = findTarget(tokens[1]);
            if(attackTarget == null)return;
            else
            {
                int damage = combat.calcDamage(player);
                attackTarget.takeDamage(damage);
                combat.logAttack((Person)player, attackTarget, damage);
                if(attackTarget.isDead())
                {
                    combat.logDeath(attackTarget);
                    combat.removePerson(attackTarget, !combat.isTeamOne);
                }
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

    private Person findTarget(String name){ return combat.isTeamOne ? findOpponent(combat.getTeam(combat.teamTwo), name) : findOpponent(combat.getTeam(combat.teamOne), name); }

    private Person findOpponent(Person[] team, String name)
    {
        Person person = null;

        for(Person opponent: team)
        {
            if(opponent.firstName.equalsIgnoreCase(name))
            {
                person = opponent;
            }
        }

        return person;
    }
}
