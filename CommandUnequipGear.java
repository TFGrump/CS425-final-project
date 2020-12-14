
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
            case "weapon": player.equipWeapon((Weapon)GameItemManager.getNewItem(0)); break;
            case "head": player.equipHead((Apparel)GameItemManager.getNewItem(1)); break;
            case "torso": player.equipTorso((Apparel)GameItemManager.getNewItem(1)); break;
            case "legs": player.equipLegs((Apparel)GameItemManager.getNewItem(1)); break;
        }            
    }

    public void printOneLineHelp() { System.out.println("[Unequip] [Weapon/Head/Torso/Legs] -- Unequips the item from the player"); }

    public void printDetailedHelp() {
    }
}
