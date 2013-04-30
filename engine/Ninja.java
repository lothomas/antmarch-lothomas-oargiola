package engine;

import java.util.Random;

public class Ninja implements ICreature {
    private int damages;
    private int hit_points;
    private final int max_hit_points;
    private Random rng;

    public Ninja() {
        this.hit_points = 1;
        this.max_hit_points = this.hit_points;
        this.damages = 5;
        this.rng = new Random();
    }

    public void receiveDamage(int damages) {
        if(this.rng.nextInt(10) >= 6) {
            this.hit_points -= damages;
        }
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
        opponent.receiveDamage(this.damages);
        this.damages = 2 * this.damages;
    }

    public String toString() {
        return String.format("%-20s (PdV: %4d, Dmg: %4d)",
                "Ninja", this.hit_points, this.damages);
    }
}
