import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Implements the min-conflict local search CSP solver 
 */
public class MinConflicts implements CSPSolver {

	@Override
	public <E> CSPResult<E> solve(CSP<E> csp) {
		/* 
		 * find reasonable value for max iterations.
		 */
		return minConflicts(csp, 1000);
	}
	
	/**
	 * Implements the min-conflicts algorithm.
	 * @param csp The csp to solve
	 * @param maxSteps The max number of steps
	 * @return A solution to the csp, or null if none was found.
	 */
	private static <E> CSPResult<E> minConflicts(CSP<E> csp, int maxSteps) {
		/* 
		 * The implementation can pretty much follow the pseudo code
		 * in the text book:
		 * 
		 * current <- an initial complete assignment for csp
		 * for i = 1 to max_steps do
		 *   if current is a solution for csp then return current
		 *   var <- a randomly chosen conflicted variable from csp.VARIABLES
		 *   value <- the value v for var that minimizes CONFLICTS(var, v, current, csp)
		 *   set var = value in current
		 * return failure
		 * 
		 * Most of it is straight forward, because there is a separate
		 * function for it. Only finding the value that minimizes the
		 * number of conflicts is a little more complicated. However,
		 * you should use the function conflicts() for this purpose.
		 * Also, please note that "failure" is "null" in this implementation.
		 * You should return the result like "new CSPResult(current, i);"
		 */
		Assignment<E> current = createCompleteAssignment(csp);
		for (int i = 1; i <= maxSteps; i++){
			if(csp.isConsistent(current)){
				return new CSPResult<E>(current, i);
			}
			String var = getRandomConflictedVariable(current, csp);
			int numConflicts = Integer.MAX_VALUE;
			E value = csp.domains.get(var).get(0); // set to arbitrary E value for initialization purposes
			for(E v : csp.domains.get(var)){
				int result = conflicts(var, v, current, csp);
				if (result < numConflicts){
					numConflicts = result;
					value = v;
				}
			}
			//System.out.println(i +"Min numConflicts=" + numConflicts +" | var= " + var + " set to value=" + value);
			current.replace(var, value);
		}

		return null;
	}
	
	/**
	 * Randomly selects a conflicted variable.
	 * @param current The current assignment
	 * @param csp The csp
	 * @return A randomly chosen conflicted variable.
	 */
	private static <E> String getRandomConflictedVariable(Assignment<E> current, CSP<E> csp) {
		/* 
		 * First, you should create an initially empty set of conflicted variables.
		 * Then, iterate over all constraints, and if it is not consistent, add
		 * all the variables from its scope to the set of conflicted variables.
		 * Afterwards, just return a randomly selected one of them. (Hint: make
		 * sure that variables that appear in multiple constraints are not
		 * selected with a higher probability, they should be selected unbiased).
		 */
		Set<String> confVar = new HashSet<String>();
		for(Constraint c : csp.constraints){
			if(!c.isConsistent(current)){
				confVar.add(c.getScope().get(0));
				confVar.add(c.getScope().get(1));
			}
		}
		int randomNum = ThreadLocalRandom.current().nextInt(0, confVar.size());
		int n = confVar.size();
		String arr[] = new String[n];
		int i = 0;
		for (String x : confVar){
			arr[i++] = x;
		}
		return arr[randomNum];
	}
	
	/**
	 * Creates an assignment in which every varibale is assigned a value from its domain.
	 * @param csp The underlying csp that defines the domains and the variables
	 * @return A complete assignment
	 */
	private static <E> Assignment<E> createCompleteAssignment(CSP<E> csp) {
		/* 
		 * create a new assignment and randomly assign a value to every
		 * variable from its domain.
		 */
		Assignment<E> a = new Assignment<E>();
		for (String v : csp.variables){
			int randomNum = ThreadLocalRandom.current().nextInt(0, csp.domains.get(v).size()); //check if random number is assigned every time in for loop
			a.put(v, csp.domains.get(v).get(randomNum));
		}
		return a;
	}
	
	/**
	 * Computes the number of conflict based on an assignment, but with one variable
	 * set to a specific value.
	 * @param var The variable to be checked
	 * @param value The value to be checked
	 * @param current The current assignment used as basis
	 * @param csp The csp problem
	 * @return The number of conflict given the current assignment, but with var=value
	 */
	private static <E> int conflicts(String var, E value, Assignment<E> current, CSP<E> csp) {
		/* 
		 * You might want to temporarily modify the assignment
		 * to set var = value (undo this afterwards!). Then
		 * iterate over all constraints and count the number of
		 * insonsistent constraints.
		 */
		E oldVal = current.get(var);
		current.replace(var, value);
		int count = 0;
		for(Constraint c : csp.constraints){
			if (!c.isConsistent(current)){
				count++;
			}
		}
		current.replace(var, oldVal);

		return count;
	}
}