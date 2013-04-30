package engine;

public interface IAction {
    void perform(ICreature target);
    String toString();
}
