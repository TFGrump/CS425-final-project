
public class Weapon extends GameItem {

	//private
	private float damage;
	private float accuracy;
	private float firerate;
	private int mag;
	private int range;
	
	//public
	//constructors
	public Weapon(String name, int value, double weight, float damage, float accuracy, float firerate, int mag, int range) {
		super(name, value, weight);
		this.damage = damage;
		this.accuracy = accuracy;
		this.firerate = firerate;
		this.mag = mag;
		this.range = range;
	}
	public Weapon(String name, float damage, float accuracy, float firerate, int mag, int range) {
		super(name, 0, 0);
		this.damage = damage;
		this.accuracy = accuracy;
		this.firerate = firerate;
		this.mag = mag;
		this.range = range;
	}
	
	//getters
	public float getDamage() {
		return damage;
	}
	public float getAccuracy() {
		return accuracy;
	}
	public float getFirerate() {
		return firerate;
	}
	public int getMag() {
		return mag;
	}
	public int getRange() {
		return range;
	}
	

}
