package ui;

import engine.ICreatureState;
import engine.IGameState;
import engine.IAction;

import java.util.List;
import java.util.Scanner;

public class Terminal {
    private Scanner scanner;

    public Terminal() {
        this.scanner = new Scanner(System.in);
    }

    public void run(IGameState game) {
        System.out.println("Bienvenue dans ce donjon.");
        while(!game.isFinished()) {
            describe(game);
            IAction a = this.chooseAction(game.getPossibleMoves(), game);
            int target = chooseTarget(game.getOpponents());
            game = game.nextState(a, target);
        }
        describe(game);
    }

    private static void describe(IGameState game) {
        if(!game.isFinished()) {
            System.out.println(String.format("Etat du joueur: %s", game.getPlayer()));
            System.out.println(String.format("Adversaire: %s", game.getOpponent()));
            System.out.println(String.format("Adversaires futurs: %s", game.getFutureOpponents()));
        } else {
            if(game.hasWon()) {
                System.out.println("Vous avez gagné!");
            } else {
                System.out.println("Vous avez perdu...");
            }
        }
    }

    private IAction chooseAction(List<IAction> actions, IGameState game) {
        System.out.println(String.format("Choisissez une action:"));
        int i = 0;
        int end = actions.size() - game.getItems().size();
        for(IAction a : actions.subList(0, end)) {
            System.out.println(String.format("[%2d] %s", i, a));
            i += 1;
        }
        System.out.println(String.format("[%2d] Inventaire", i));
        int index = -1;
        while(index < 0 || index >= (end+1)) {
            System.out.print("Entrez le numéro de l'action:");
            index = this.scanner.nextInt();
        }
        if(index== end){
        	index = chooseObject(actions, end, index);
        }
        return actions.get(index);
    }
    
    private int chooseObject(List<IAction> actions, int end, int index) {
    	int i=0;
    	for(IAction a : actions.subList(end, actions.size())) {
            System.out.println(String.format("[%2d] %s", i, a));
            i += 1;
        }
        index = -1;
        while(index < 0 || index >= (actions.size()-end)) {
            System.out.print("Entrez le numéro de l'action:");
            index = this.scanner.nextInt();
        }
        index += end;
        return index;
    }
    
    private int chooseTarget(List<ICreatureState> creatures) {
        System.out.println(String.format("Choisissez une cible:"));
        int i = 0;
        for(ICreatureState a : creatures) {
            System.out.println(String.format("[%2d] %s", i, a));
            i += 1;
        }
        int index = -1;
        while(index < 0 || index >= creatures.size()) {
            System.out.print("Entrez le numéro de la cible:");
            index = this.scanner.nextInt();
        }
        return index;
    }

}
