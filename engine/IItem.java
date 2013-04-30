package engine;

public interface IItem extends IItemState {
	boolean usable();
	void use(ICreature p);
	String toString();
}
