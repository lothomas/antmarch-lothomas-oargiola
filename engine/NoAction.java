package engine;

public class NoAction implements IAction {
	public void perform(ICreature target) {
        // Do nothing
    }
	
    public String toString() {
        return "Ne rien faire.";
    }

}
