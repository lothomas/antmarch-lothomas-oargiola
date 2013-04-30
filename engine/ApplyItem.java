package engine;

public class ApplyItem implements IAction {
    private IItem item;
    private ICreature target;
    
    public ApplyItem(IItem item, ICreature target) {
        this.item = item;
        this.target = target;
    }
    
    public void perform(ICreature target) {
    	this.target = target;
        this.item.use(this.target);
    }
    
    public String toString() {
        return String.format("Utiliser l'objet %s sur la créature %s.", this.item, this.target);
    }
}
