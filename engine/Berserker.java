package engine;

public class Berserker implements ICreature {
    private int hit_points;
    private final int max_hit_points;

    public Berserker(int start_hit_points) {
        this.hit_points = start_hit_points;
        this.max_hit_points = start_hit_points;
    }

    public void receiveDamage(int damages) {
        this.hit_points -= damages;
    }

    public void receiveHealing(int healing) {
        this.hit_points += healing;
    }

    @Override
    public void receiveHealing() {
        this.hit_points = this.max_hit_points;
    }

    public boolean isAlive() {
        return this.hit_points > 0;
    }

    public void attack(ICreature opponent) {
        int damages = 2 * (this.max_hit_points - this.hit_points);
        opponent.receiveDamage(damages);
    }

    public String toString() {
        return String.format("%-20s (PdV: %4d)",
                "Berserker", this.hit_points);
    }
}
