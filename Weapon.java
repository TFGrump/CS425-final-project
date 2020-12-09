
public class Weapon extends GameItem {

	//private
	private float damage;
	private float accuracy;
	private float firerate;
	private int mag;
	private int range;
	
	//public
	//constructors
	public Weapon(String name, float weight, float value, float damage, float accuracy, float firerate, int mag, int range) {
		super(name, weight, value);
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
		return this.damage;
	}
	public float getAccuracy() {
		return this.accuracy;
	}
	public float getFirerate() {
		return this.firerate;
	}
	public int getMag() {
		return this.mag;
	}
	public int getRange() {
		return this.range;
	}	
	

}
