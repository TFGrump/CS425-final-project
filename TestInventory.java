
/**
 * Write a description of class TestInventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestInventory
{
    public static void main() {
        Player player = new Player("First", "Last", 1, true);
        
        Weapon nutSacker = new Weapon("Nut Sacker", 69, 420, 2, .5, 1, 2, 1);
        Weapon weakAsBeater = new Weapon("Weak As Beater", 1, 1, 1, .1, 1, 10, 1);
        
        player.addToInventory(nutSacker);
        player.addToInventory(weakAsBeater);
        
        Command cmd = new CommandInventory(player);
        TextInputManager.addCommand(cmd);
        while(true)
            TextInputManager.prompt();
    }
}
