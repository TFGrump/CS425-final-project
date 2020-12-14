
/**
 * The class CommandEquipGear allows the player to equip items from their inventory
 *
 * @author Theorin Feder
 * @version 0.1
 */
public class CommandEquipGear extends Command
{
    Player player;
    String[] tokens;
    public CommandEquipGear(Player player) { this.player = player; }
    
    public boolean isTrigger(String input) { 
        tokens = input.split(" ", 2);
        return tokens[0].equalsIgnoreCase("equip");
    }
    
    public void execute() {
        for(GameItem item: player.getInventory())
            if(item.getName().equalsIgnoreCase(tokens[1]))
                player.equip(item); return;
        System.out.println("The item " + tokens[1] + " is not in your inventory.");
    }
    
    public void printOneLineHelp() { System.out.println("[Equip] [Item] -- Equips the item to the player"); }
    
    public void printDetailedHelp() {
    }
}
