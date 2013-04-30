package engine;

import java.util.Random;

public class GenericCreature implements ICreature {
	private final int min_damage;
	private final int max_damage;
	private int hit_points;
    private final int max_hit_points;
	private final Random random_generator;

	public GenericCreature(int min, int max, int hp) {
		this.min_damage = min;
		this.max_damage = max;
		this.hit_points = hp;
		this.max_hit_points = hp;
		this.random_generator = new Random();
	}

	@Override
	public void attack(ICreature opponent) {
		int rand = this.random_generator.nextInt(this.max_damage - this.min_damage + 1);
		int damages = rand + this.min_damage;
		opponent.receiveDamage(damages);
	}

	@Override
	public void receiveDamage(int damages) {
		this.hit_points -= damages;
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
    public void receiveHealing(int healing) {
        this.hit_points += healing;
    }

    @Override
    public String toString() {
        return String.format("%-20s (PdV: %4d; Dmg: %2d-%2d)", "Spookie",
                this.hit_points, this.min_damage, this.max_damage);
    }

}
