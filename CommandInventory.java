
/**
 * The class CommandInventory tells the player what is in their inventory.
 *
 * @author Theorin Feder
 * @version 0.1
 */
public class CommandInventory extends Command {
    Player player;

    public CommandInventory(Player player) { this.player = player; }

    public boolean isTrigger(String input) { return input.equalsIgnoreCase("inventory") || input.equalsIgnoreCase("bag"); } 

    public void execute() { 
        if(player.getInventory() != null) for(GameItem item: player.getInventory()) item.toString(); 
        else System.out.println("There is nothing in your inventory."); } 

    public void printOneLineHelp() { System.out.println("[Inventory/Bag] -- Display the items in your inventory"); }

    public void printDetailedHelp() {
    }
}
