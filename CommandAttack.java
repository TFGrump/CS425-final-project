
/**
 * Write a description of class CommandAttack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CommandAttack extends Command
{
    public boolean isTrigger(String input){
        String[] tokens = input.split(" ");
        if (tokens[0].equalsIgnoreCase("attack"))return true;
        return false;
    }
    
    public void execute(){
        System.out.println("You are a dofus that decided to attack");
    }
    
    public void printOneLineHelp(){
        System.out.println("Attack -- Used to attack other Gangsters");
    }
    
    public void printDetailedHelp(){
    }
}
