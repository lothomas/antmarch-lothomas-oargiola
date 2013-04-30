package engine;

public class Attack implements IAction{
    private ICreature player;
    private ICreature target;
    
    public Attack(ICreature player, ICreature target) {
        this.player = player;
        this.target = target;
    }

	public void perform(ICreature target) {
		this.target = target;
        this.player.attack(this.target);
    }
	
    public String toString() {
        return "Attaquer.";
    }
}
