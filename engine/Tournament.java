package engine;

import java.util.ArrayList;
import java.util.List;

public class Tournament implements IGameState {
	private ICreature player;
	private List<ICreature> monsters;
	private List<IItem> items;
    private boolean finished;

	public Tournament(ICreature challenger, List<ICreature> monsters, List<IItem> inventory) {
		this.player = challenger;
		this.monsters = monsters;
		monsters.add(0, player);
		this.items = inventory;
        this.finished = (!this.player.isAlive() || this.monsters.size()==1);
	}

    public Tournament nextState(IAction action, int index) {
        action.perform(this.monsters.get(index));
        this.monsters.get(0).attack(this.player);
        this.monsters = filterMonsters(this.monsters);
        this.items = filterInventory(this.items);
        if(this.monsters.size()==1 || !this.player.isAlive()) {
            this.finished = true;
        }
        return this;
    }

    public boolean isFinished() {
        return finished;
    }

    public List<IAction> getPossibleMoves() {
        List<IAction> actions = new ArrayList<IAction>();
        if(this.player.isAlive()) {
            actions.add(new NoAction());
            actions.add(new Attack(this.player, this.monsters.get(0)));
            for(IItem i : this.items) {
                actions.add(new ApplyItem(i, this.player));
            }
        }
        return actions;
    }

	private List<IItem> filterInventory(List<IItem> i2) {
		List<IItem> l = new ArrayList<IItem>();
		for (IItem i : i2) {
			if (i.usable()) {
				l.add(i);
			}
		}
		return l;
	}

	private List<ICreature> filterMonsters(List<ICreature> m2) {
		List<ICreature> l = new ArrayList<ICreature>();
		for (ICreature c: m2) {
			if(c.isAlive()) {
				l.add(c);
			}
		}
		return l;
	}

	public boolean hasWon() {
		return this.finished && this.player.isAlive();
	}

    public ICreatureState getPlayer() {
        return this.player;
    }

    public ICreatureState getOpponent() {
    		return this.monsters.get(1);
    }
    
    public List<IItem> getItems(){
    	List<IItem> all = new ArrayList<IItem>();
        all.addAll(this.items);
        return all;
    }
    
    public List<ICreatureState> getOpponents() {
    	List<ICreatureState> all = new ArrayList<ICreatureState>();
        all.addAll(this.monsters);
        return all;
    }
    
    public List<ICreatureState> getFutureOpponents() {
        List<ICreatureState> others = new ArrayList<ICreatureState>();
        others.addAll(this.monsters.subList(2, this.monsters.size()));
        return others;
    }
}
