package engine;

public interface ICreature extends ICreatureState, IBoardPiece {
	void attack(ICreature opponent);
	void receiveDamage(int damages);
	boolean isAlive();

    void receiveHealing(int healing);
    void receiveHealing();
    String toString();
}
