package engine;

public class Player implements ICreature {
	private int hit_points;
    private final int max_hit_points;

	public Player(int hit_points) {
		this.hit_points = hit_points;
        this.max_hit_points = hit_points;
	}

	@Override
	public void receiveDamage(int damages) {
		this.hit_points -= damages;
	}

	@Override
	public void receiveHealing(int healing) {
		this.hit_points += healing;
        if (this.hit_points > this.max_hit_points) {
            this.hit_points = this.max_hit_points;
        }
	}

    @Override
    public void receiveHealing() {
        this.hit_points = this.max_hit_points;
    }

	@Override
	public boolean isAlive() {
		return this.hit_points > 0;
	}

	@Override
	public void attack(ICreature opponent) {
		opponent.receiveDamage(10);
	}

	@Override
	public String toString() {
		return String.format("%-20s (PdV: %4d; Dmg: %2d-%2d)",
                "Joueur", this.hit_points, 10, 10);
	}

}
