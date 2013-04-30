package engine;

public class Grenade implements IItem {
	private int strength;
	private int charges;

	public Grenade(int s, int c) {
		this.strength = s;
		this.charges = c;
	}

	@Override
	public void use(ICreature p) {
		p.receiveDamage(this.strength);
		this.charges -= 1;
	}

	@Override
	public boolean usable() {
		return charges > 0;
	}

	@Override
	public String toString() {
		return String.format("Grenade (Dégats: %3d, charges: %d)", this.strength, this.charges);
	}

}