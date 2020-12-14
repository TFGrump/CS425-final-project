public class CommandQuestlog extends Command {

    Player player;

    public CommandQuestlog(Player player) { this.player = player; }

    public boolean isTrigger(String input) { return input.equalsIgnoreCase("questlog") || input.equalsIgnoreCase("quests"); } 

    public void execute() { 
        System.out.println("==========[QUEST LOG]===============");
        if (player.questlog.size() == 0) System.out.println("You have no quests!");
        else for (Quest quest: player.questlog) quest.printBriefDesc();
    }

    public void printOneLineHelp() { System.out.println("[Questlog/Quests] -- Display active quests"); }

    public void printDetailedHelp() {}
}