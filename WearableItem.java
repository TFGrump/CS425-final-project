
public class WearableItem extends GameItem {

	//private
	private int strengthMod;
	private int perceptionMod;
	private int enduranceMod;
	private int charismaMod;
	private int intelligenceMod;
	private int agilityMod;
	private int luckMod;
	
	//public
	//getters
	public int getStrMod() { return strengthMod; }
	public int getPerMod() { return perceptionMod; }
	public int getEndMod() { return enduranceMod; }
	public int getChrMod() { return charismaMod; }
	public int getIntMod() { return intelligenceMod; }
	public int getAgiMod() { return agilityMod; }
	public int getLucMod() { return luckMod; }
	
	//constructor
	public WearableItem(String name, float weight, float value, int strengthMod, int perceptionMod, int enduranceMod, int charismaMod, int intelligenceMod, int luckMod, int agilityMod) {
		super(name, weight, value);
		this.strengthMod = strengthMod;
		this.perceptionMod = perceptionMod;
		this.enduranceMod = enduranceMod;
		this.charismaMod = charismaMod;
		this.intelligenceMod = intelligenceMod;
		this.agilityMod = agilityMod;
		this.luckMod = luckMod;
	}
	public WearableItem(String name, int strengthMod, int perceptionMod, int enduranceMod, int charismaMod, int intelligenceMod, int luckMod, int agilityMod) {
		super(name, 0, 0);
		this.strengthMod = strengthMod;
		this.perceptionMod = perceptionMod;
		this.enduranceMod = enduranceMod;
		this.charismaMod = charismaMod;
		this.intelligenceMod = intelligenceMod;
		this.agilityMod = agilityMod;
		this.luckMod = luckMod;
	}
}
