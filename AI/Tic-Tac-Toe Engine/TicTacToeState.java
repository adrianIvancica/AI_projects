import java.util.List;
import java.util.ArrayList;

/**
 * A class that implements a state and the playing logic of the TicTacToe game. 
 */
public class TicTacToeState implements State {
	private Square[] field; /**< The field, consisting of nine squares. First three values correspond to first row, and so on. */
	public Square player; /**< The player, either X or O. */
	public Square playerToMove; /**< The player that is about to move. */
	private float utility; /**< The utility value of this state. Can be 0, 1 (won) or -1 (lost).*/

	/**
	 * Updates the utility value.
	 */
	private void updateUtility() {
		/** 
		 * The utility value for the TicTacToe game is defined as follows:
		 * - if player has three marks in a row, it is 1
		 * - if the other player has three marks in a row, it is -1
		 * - otherwise it is 0
		 * Note that "three marks in a row" can actually be a row, a column
		 * or a diagonal. So basically, first find out if there are three
		 * identical values in a row, and if so, check whether the marks belong
		 * to player or not. 
		 */
		
		boolean isWin = false;
		Square p = Square.EMPTY;
		//check rows
		if (field[0] != Square.EMPTY && field[0] == field[1] && field[1] == field[2]){
			isWin = true;
			p = field[0];
		}
		if (field[3] != Square.EMPTY && field[3] == field[4] && field[4] == field[5]){
			isWin = true;
			p = field[3];
		}
		if (field[6] != Square.EMPTY && field[6] == field[7] && field[7] == field[8]){
			isWin = true;
			p = field[6];
		}

		//check columns
		if (field[0] != Square.EMPTY && field[0] == field[3] && field[3] == field[6]){
			isWin = true;
			p = field[0];
		}
		if (field[1] != Square.EMPTY && field[1] == field[4] && field[4] == field[7]){
			isWin = true;
			p = field[1];
		}
		if (field[2] != Square.EMPTY && field[2] == field[5] && field[5] == field[8]){
			isWin = true;
			p = field[2];
		}
		
		//check diagonals
		if (field[0] != Square.EMPTY && field[0] == field[4] && field[4] == field[8]){
			isWin = true;
			p = field[0];
		}
		if (field[2] != Square.EMPTY && field[2] == field[4] && field[4] == field[6]){
			isWin = true;
			p = field[2];
		}

		if (isWin && p != Square.EMPTY){
			if (p == player){
				utility = 1;
			}
			else{
				utility = -1;
			}
			return;
		}
		utility = 0;
	}
	
	/**
	 * Default constructor.
	 */
	public TicTacToeState() {
		field = new Square[9];
		for(int i = 0; i < 9; ++i) {
			field[i] = Square.EMPTY;
		}
		player = Square.X;
		playerToMove = Square.X;
		utility = 0;
	}
	
	@Override
	public List<Action> getActions() {
		/** 
		 * For the TicTacToe game, there is one valid action
		 * for each empty square. The action would then consist
		 * of the position of the empty square and the "color" of
		 * the player to move.
		 */
		List<Action> actions = new ArrayList<Action>();
		for (int i = 0; i < 9; i++){
			if (field[i] == Square.EMPTY){
				actions.add(new TicTacToeAction(playerToMove, i));
			}
		}
		return actions;
	}

	@Override
	public float getUtility() {
		return utility;
	}

	@Override
	public State getResult(Action action) {
		/** 
		 * Create a new state and copy all the contents of the current state
		 * to the new one (in particular the field and the player). The
		 * player to move must be switched. Then incorporate the action into
		 * the field of the new state. Finally, compute the utility of the new
		 * state using updateUtility().
		 */
		TicTacToeAction a = (TicTacToeAction) action;
		TicTacToeState newState = new TicTacToeState();
		for (int i = 0; i < 9; i++){
			if (a.position == i){
				newState.field[i] = a.player;
			}
			else{
				newState.field[i] = field[i];
			}
		}
		
		newState.player = player;

		if (playerToMove == Square.X){
			newState.playerToMove = Square.O;
		}
		else{
			newState.playerToMove = Square.X;
		}
		
		newState.updateUtility();

		return newState;
	}

	@Override
	public boolean isTerminal() {
		/** 
		 * Hint: the utility value has specific values if one of
		 * the players has won, which is a terminal state. However,
		 * you will also have to check for terminal states in which
		 * no player has won, which can not be inferred immediately
		 * from the utility value.
		 */
		if (utility == 1 || utility == -1){
			return true;
		}
		for (Square s : field){
			if (s == Square.EMPTY){
				return false;
			}
		}
		return true;
	}

	@Override
	public void print() {
		String s = "" + field[0] + "|" + field[1] + "|" + field[2] + "\n";
		s += "-+-+-\n";
		s += field[3] + "|" + field[4] + "|" + field[5] + "\n";
		s += "-+-+-\n";
		s += field[6] + "|" + field[7] + "|" + field[8] + "\n";
		System.out.println(s);
	}
}
