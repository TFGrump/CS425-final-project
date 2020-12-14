
/**
 * Write a description of class TestEquip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestEquip
{
    public static void main() {
        Player player = new Player("a","b",1,true);
        
        Weapon nutSacker = new Weapon("Nut Sacker", 69, 420, 2, .5, 1, 2, 1);
        Weapon weakAsBeater = new Weapon("Weak As Beater", 1, 1, 1, .1, 1, 10, 1);
        
        player.addToInventory(GameItemManager.getNewItem(4));
        player.addToInventory(GameItemManager.getNewItem(3));
        
        Command cmd = new CommandEquipGear(player);
        Command cmd_two = new CommandInventory(player);
        Command cmda = new CommandCharacter(player);
        TextInputManager.addCommand(cmd);
        TextInputManager.addCommand(cmd_two);
        TextInputManager.addCommand(cmda);
        
        while(true)
            TextInputManager.prompt();
    }
}
