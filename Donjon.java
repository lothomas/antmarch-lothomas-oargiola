import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import engine.*;
import ui.Terminal;

public class Donjon {

	private static List<ICreature> generate_opponents() {
		List<ICreature> opps = new ArrayList<ICreature>();
        opps.add(new GenericCreature(3, 5, 20));
        opps.add(new GenericCreature(3, 6, 20));
        opps.add(new GenericCreature(5, 10, 20));
        opps.add(new GenericCreature(5, 10, 20));
        opps.add(new GenericCreature(5, 10, 20));
        opps.add(new GenericCreature(5, 10, 20));
        opps.add(new GenericCreature(5, 10, 20));
        opps.add(new GenericCreature(5, 10, 20));
        opps.add(new GenericCreature(5, 10, 20));
        opps.add(new GenericCreature(5, 10, 20));
        opps.add(new GenericCreature(10, 15, 20));
        opps.add(new GenericCreature(10, 15, 20));
        opps.add(new GenericCreature(10, 17, 20));
        opps.add(new GenericCreature(13, 17, 20));
        opps.add(new GenericCreature(13, 17, 20));
        opps.add(new Berserker(10));
        opps.add(new Berserker(20));
        opps.add(new Berserker(30));
        opps.add(new Zombie(10));
        opps.add(new Zombie(20));
        opps.add(new Zombie(30));
        opps.add(new Ninja());
        opps.add(new Ninja());
		Collections.shuffle(opps);
        return opps.subList(0, 6);
	}
	private static List<IItem> generate_inventory() {
		List<IItem> inv = new ArrayList<IItem>();
		inv.add(new HealPotion(1));
		inv.add(new HealPotion(2));
		inv.add(new HealPotion(3));
		inv.add(new HealPotion(4));
		inv.add(new HealPotion(5));
		inv.add(new Grenade(20, 3));
		inv.add(new Grenade(20, 3));
		inv.add(new Grenade(20, 3));
		inv.add(new Grenade(20, 3));
		inv.add(new Grenade(20, 3));
		inv.add(new CurePotion(10, 4));
		inv.add(new CurePotion(15, 3));
		inv.add(new CurePotion(20, 2));
		inv.add(new CurePotion(25, 1));
		inv.add(new CurePotion(30, 1));
		inv.add(new CurePotion(35, 1));
		inv.add(new CurePotion(40, 1));
		inv.add(new CurePotion(45, 1));
		inv.add(new CurePotion(50, 1));
		inv.add(new CurePotion(10, 5));
		inv.add(new CurePotion(15, 5));
		inv.add(new CurePotion(20, 5));
		inv.add(new CurePotion(25, 5));
		inv.add(new CurePotion(30, 5));
		inv.add(new CurePotion(35, 5));
		Collections.shuffle(inv);
        return inv.subList(0, 3);
	}

	public static void main(String[] args) {
		ICreature p = new Player(100);
		List<ICreature> opponents = generate_opponents();
		List<IItem> inventory = generate_inventory();
		IGameState tour = new Tournament(p, opponents, inventory);
        Terminal term = new Terminal();
        term.run(tour);
	}
}
