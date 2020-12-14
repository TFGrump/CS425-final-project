
/**
 * The class CommandUnequipGear unequips the item from a slot the user chooses.
 *
 * @author Theorin Feder
 * @version 0.1
 */
public class CommandUnequipGear extends Command
{
    Player player;
    String[] tokens;

    public CommandUnequipGear(Player player) { this.player = player; }

    public boolean isTrigger(String input) {
        tokens = input.split(" ", 2);
        return tokens[0].equalsIgnoreCase("unequip");
    }

    public void execute() {
        switch(tokens[1].toLowerCase()){
            case "weapon": 
            	if( player.getEquippedWeapon() != (Weapon)GameItemManager.getNewItem(0) )player.addToInventory(player.getEquippedWeapon()); 
            	player.equipWeapon((Weapon)GameItemManager.getNewItem(0)); 
            	break;
            case "head": 
            	if( player.getEquippedHead() != (Apparel)GameItemManager.getNewItem(1) )player.addToInventory(player.getEquippedHead());
            	player.equipHead((Apparel)GameItemManager.getNewItem(1)); 
            	break;
            case "torso": 
            	if( player.getEquippedTorso() != (Apparel)GameItemManager.getNewItem(1) )player.addToInventory(player.getEquippedTorso());
            	player.equipHead((Apparel)GameItemManager.getNewItem(1)); 
            	break;
            case "legs":
            	if( player.getEquippedLegs() != (Apparel)GameItemManager.getNewItem(1) )player.addToInventory(player.getEquippedLegs());
            	player.equipHead((Apparel)GameItemManager.getNewItem(1)); 
            	break;
        }            
    }

    public void printOneLineHelp() { System.out.println("[Unequip] [Weapon/Head/Torso/Legs] -- Unequips the item from the player"); }

    public void printDetailedHelp() {
    }
}
