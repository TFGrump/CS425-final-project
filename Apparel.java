public class Apparel extends GameItem {

    // Private
    private int strengthMod;
    private int perceptionMod;
    private int enduranceMod;
    private int charismaMod;
    private int intelligenceMod;
    private int agilityMod;
    private int luckMod;

    // Constructor
    public Apparel(String name, int value, double weight, int s, int p, int e, int c, int i, int a, int l) {
        super(name, value, weight);
        this.strengthMod = s;
        this.perceptionMod = p;
        this.enduranceMod = e;
        this.charismaMod = c;
        this.intelligenceMod = i;
        this.agilityMod = a;
        this.luckMod = l;
    }

    public Apparel(String rawData) {
        super(rawData); // Super constructor handles name, value, and weight

        // Read Stats
        String[] stats = rawData.split(" ");
        strengthMod = Integer.parseInt(GameItemManager.removeLabel(stats[3])); // Strength
        perceptionMod = Integer.parseInt(GameItemManager.removeLabel(stats[4])); // Perception
        enduranceMod = Integer.parseInt(GameItemManager.removeLabel(stats[5])); // Endurance
        charismaMod = Integer.parseInt(GameItemManager.removeLabel(stats[6])); // Charisma
        intelligenceMod = Integer.parseInt(GameItemManager.removeLabel(stats[7])); // Intelligence
        agilityMod = Integer.parseInt(GameItemManager.removeLabel(stats[8])); // Agility
        luckMod = Integer.parseInt(GameItemManager.removeLabel(stats[9])); // Luck
    }

    // Get respective stat modifiers
    public int getStrMod() { return strengthMod; }

    public int getPerMod() { return perceptionMod; }

    public int getEndMod() { return enduranceMod; }

    public int getChrMod() { return charismaMod; }

    public int getIntMod() { return intelligenceMod; }

    public int getAgiMod() { return agilityMod; }

    public int getLucMod() { return luckMod; }

    public String getBriefDetails() {
        return name + " - "
        + "[Val: " + value + "] [Wgt: " + weight + "] "
        + (strengthMod != 0 ? "[Str: " + strengthMod + "] " : "")
        + (perceptionMod != 0 ? "[Per: " + perceptionMod + "] " : "")
        + (enduranceMod != 0 ? "[End: " + enduranceMod + "] " : "")
        + (charismaMod != 0 ? "[Chr: " + charismaMod + "] " : "")
        + (intelligenceMod != 0 ? "[Int: " + intelligenceMod + "]" : "")
        + (agilityMod != 0 ? "[Agi: " + agilityMod + "]" : "")
        + (luckMod != 0 ? "[Luc: " + luckMod + "]" : "");
    }

    public String getDetails() {
        return name + "\n"
        + "[Value: " + value + " Weight: " + weight + "\n"
        + (strengthMod != 0 ? "[Strength: " + strengthMod + "]\n" : "")
        + (perceptionMod != 0 ? "[Perception: " + perceptionMod + "]\n" : "")
        + (enduranceMod != 0 ? "[Endurance: " + enduranceMod + "]\n" : "")
        + (charismaMod != 0 ? "[Charisma: " + charismaMod + "]\n" : "")
        + (intelligenceMod != 0 ? "[Intelligence: " + intelligenceMod + "]\n" : "")
        + (agilityMod != 0 ? "[Agility: " + agilityMod + "]\n" : "")
        + (luckMod != 0 ? "[Luck: " + luckMod + "]\n" : "");
    }

    @Override
    public String toString() {
        return getBriefDetails();
    }
}
