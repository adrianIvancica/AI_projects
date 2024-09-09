import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A class that implements the MiniMax algorithm.
 */
public class MiniMax {
	public static int numberOfStates; /**< counter to measure the number of iterations / states. */
	private static boolean usePruning;
	
	/**
	 * Start procedure of the MiniMax algorithm.
	 * @param state The state where the MiniMax algorithm starts searching
	 * @param usePruning Whether to use alpha-beta-pruning
	 * @return An optimal action to be taken at this point.
	 */
	public static Action MinimaxDecision(State state, boolean usePruning) {
		MiniMax.usePruning = usePruning;
		numberOfStates = 0;
		//System.out.println("number of States =" + numberOfStates);
		/* 
		 * Implement the minimax decision routine. Iterate over all possible actions
		 * and evaluate their utilities invoking MinValue(). Return the action that
		 * generates the highest utility.
		 * You can just return the first or the last best action, however it makes
		 * the algorithm way more interesting if you determine all best actions
		 * and then select one of them randomly.
		 */
		int indexToReturn = 0;
		List<Float> actionValues = new ArrayList<Float>();
		for (Action a : state.getActions()){
			actionValues.add(MinValue(state.getResult(a), Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY));
			//TicTacToeAction check = (TicTacToeAction) a;
			//System.out.print(check.position + " ");
		}
		//System.out.println("\n" + actionValues.toString());
		/*
		float max = Float.NEGATIVE_INFINITY;
		for (int i = 0; i < actionValues.size(); i++){
			if (actionValues.get(i) > max){
				max = actionValues.get(i);
				indexToReturn = i;
			}
		}
		*/
		
		int i = 0;
		while(true){
			i = i % actionValues.size();
			float max = Float.NEGATIVE_INFINITY;
			int randomNum = ThreadLocalRandom.current().nextInt(0, actionValues.size());
			for (int j = 0; j < actionValues.size(); j++){
				if (actionValues.get(j) > max){
					max = actionValues.get(j);
				}
			}
			if (actionValues.get(i) == max){
				if (i == randomNum){
					indexToReturn = i;
					break;
				}
			}
			i++;
		}
		//System.out.println("index to return: " + indexToReturn);
		System.out.println("State space size: " + numberOfStates);
		return state.getActions().get(indexToReturn);
	}
	
	/**
	 * @param state The current state to be evaluated
	 * @param alpha The current value for alpha
	 * @param beta The current value for beta
	 * @return The maximum of the utilites invoking MinValue, or the utility of the state if it is a leaf.
	 */
	private static float MaxValue(State state, float alpha, float beta) {
		++numberOfStates;
		
		/*
		 * implement the MaxValue procedure according to the textbook:
		 * 
		 * function Max-Value(state, alpha, beta) return a utility value
		 *   if TERMINAL-TEST(state) then return UTILITY(state)
		 *   v <- -infinity
		 *   for each a in ACTIONS(State) do
		 *     v <- max(v, MIN-VALUE(RESULT(state, a), alpha, beta))
		 *     if MiniMax.usePruning then
		 *       if v >= beta then return v
		 *       alpha <- max(alpha, v)
		 *   return v
		 *   
		 *   The pseudo code is slightly changed to be able to reuse the
		 *   code for alpha-beta-pruning.
		 */
		if (state.isTerminal()){
			return state.getUtility();
		}
		float v = Float.NEGATIVE_INFINITY;
		for (Action a : state.getActions()){
			v = Math.max(v, MinValue(state.getResult(a), alpha, beta));
			if (usePruning){
				if (v >= beta){
					return v;
				}
				alpha = Math.max(alpha, v);
			}
		}
		return v;
	}
	
	/**
	 * @param state The current state to be evaluated
	 * @param alpha The current value for alpha
	 * @param beta The current value for beta
	 * @return The minimum of the utilites invoking MaxValue, or the utility of the state if it is a leaf.
	 */
	private static float MinValue(State state, float alpha, float beta) {
		++numberOfStates;

		/*
		 * implement the MaxValue procedure according to the textbook:
		 * 
		 * function Min-Value(state, alpha, beta) return a utility value
		 *   if TERMINAL-TEST(state) then return UTILITY(state)
		 *   v <- +infinity
		 *   for each a in ACTIONS(State) do
		 *     v <- min(v, MAX-VALUE(RESULT(state, a), alpha, beta))
		 *     if MiniMax.usePruning then
		 *       if v <= alpha then return v
		 *       beta <- min(beta, v)
		 *   return v
		 *   
		 *   The pseudo code is slightly changed to be able to reuse the
		 *   code for alpha-beta-pruning.
		 */
		if (state.isTerminal()){
			return state.getUtility();
		}
		float v = Float.POSITIVE_INFINITY;
		for (Action a : state.getActions()){
			v = Math.min(v, MaxValue(state.getResult(a), alpha, beta));
			if (usePruning){
				if (v <= alpha){
					return v;
				}
				beta = Math.min(beta, v);
			}
		}
		return v;
	}
}
