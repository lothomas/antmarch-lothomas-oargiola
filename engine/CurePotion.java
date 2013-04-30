package engine;

public class CurePotion implements IItem {
	private int strength;
	private int charges;

	public CurePotion(int s, int c) {
		this.strength = s;
		this.charges = c;
	}

	@Override
	public void use(ICreature p) {
		p.receiveHealing(this.strength);
		this.charges -= 1;
	}

	@Override
	public boolean usable() {
		return charges > 0;
	}

	@Override
	public String toString() {
		return String.format("Potion de Soins (Soin: %3d, charges: %d)", this.strength, this.charges);
	}

}
