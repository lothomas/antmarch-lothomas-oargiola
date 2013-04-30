package engine;

import java.util.List;

public interface IGameState {
    boolean                isFinished();
    boolean                hasWon();
    List<ICreatureState>   getFutureOpponents();
    List<ICreatureState>   getOpponents();
    ICreatureState         getOpponent();
    ICreatureState         getPlayer();
    List<IAction>          getPossibleMoves();
	List<IItem> 		   getItems();
    IGameState             nextState(IAction action, int target);
}
