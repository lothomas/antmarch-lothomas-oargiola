package engine;

public class HealPotion implements IItem {
	private int charges;

	public HealPotion(int charges) {
		this.charges = charges;
	}

	@Override
	public void use(ICreature p) {
		p.receiveHealing();
		this.charges -= 1;
	}

	@Override
	public boolean usable() {
		return charges > 0;
	}

	@Override
	public String toString() {
		return String.format("Potion de Soins Complet (charges: %d)", this.charges);
	}

}
