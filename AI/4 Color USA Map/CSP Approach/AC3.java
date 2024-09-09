import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class AC3 {
	/**
	 * This class represents a single arc for the AC-3 algorithm.
	 */
	public static class Arc {
		private String value1, value2;

		public Arc(String value1, String value2) {
			this.value1 = value1;
			this.value2 = value2;
		}
	}
	
	/**
	 * Implements the AC-3 algorithm to make a csp arc consistent.
	 * @param csp The csp
	 * @return Whether an inconsistency was found (false) or not (true)
	 * @throws Exception
	 */
	public static <E> boolean ac3(CSP<E> csp) throws Exception {
		/* 
		 * First, set up a queue of all arcs. For each constraint (you can assume that
		 * all constraints are binary constraints) add two arcs, one forward, and one
		 * backwards. Then implement the following (taken from text book):
		 * 
		 * while queue is not empty do
		 *   (Xi, Xj) <- REMOVE-FIRST(queue)
		 *   if REVISE(csp, Xi, Xj) then
		 *     if size of Di = 0 then return false
		 *     for each Xk in Xi.NEIGHBORS - {Xj} do
		 *       add (Xk, Xi) to queue
		 * return true
		 * 
		 * Note that Xi and Xj correspond to Arc.value1 and Arc.value2
		 * after some arc has been polled from the queue.
		 */
		Queue<Arc> arcQ = new LinkedList<Arc>();
		for(Constraint c : csp.constraints){
			arcQ.add(new Arc(c.getScope().get(0), c.getScope().get(1)));
			arcQ.add(new Arc(c.getScope().get(1), c.getScope().get(0)));
		}
		while(!arcQ.isEmpty()){
			Arc a = arcQ.remove();
			if(revise(csp, a.value1, a.value2)){
				if (csp.domains.get(a.value1).size() == 0){
					return false;
				}
				Set<String> setOfXj = new HashSet<String>();
				setOfXj.add(a.value2);
				Set<String> nbrs = neighbors(csp, a.value1);
				nbrs.removeAll(setOfXj);
				for(String Xk : nbrs){
					arcQ.add(new Arc(Xk, a.value1));
				}
			}
		}
		return true;
	}
	
	/**
	 * Implements the revise-routine of the AC-3 algorithm. Effectively iterates
	 * over all domain values of var1 and checks if there is at least 1 possible value
	 * for var2 remaining. If not, removes that value from the domain of var1.
	 * @param csp
	 * @param var1
	 * @param var2
	 * @return
	 */
	private static <E> boolean revise(CSP<E> csp, String var1, String var2) {
		/* 
		 * You may want to use a temporary Assignment to check whether a constraint
		 * is violated by any values for var1 and var2. Iterate over all domain values
		 * of var1. Then iterate over all domain values of var2 and prepare the
		 * temporary assignment accordingly. If all values for var2 produce an
		 * inconsistent assignment, remove the current value from the domain of
		 * var1. Hint: You cannot modify the domain as long as you are iterating over
		 * it, therefore I recommend to temporarily store the values to be deleted in
		 * a list or something, and then delete them all together after you iterated
		 * over all domain values. Also, don't forget to return whether you actually
		 * modified the domain of var1. 
		 */
		Assignment<E> temp = new Assignment<E>();
		List<E> delete = new ArrayList<E>();
		boolean revised = false;
		for (E x : csp.domains.get(var1)){
			boolean allInconsistent = true;
			for (E y : csp.domains.get(var2)){
				temp.put(var1, x);
				temp.put(var2, y);
				for (Constraint c : csp.constraints){
					List<String> cScope = c.getScope();
					if((cScope.get(0).equals(var1) && cScope.get(1).equals(var2)) || (cScope.get(1).equals(var1) && cScope.get(0).equals(var2))){
						if(c.isConsistent(temp)){
							allInconsistent = false;
						}
					}
				}
				temp.remove(var1, x);
				temp.remove(var2, y);
			}
			if(allInconsistent){
				delete.add(x);
				revised = true;
			}
		}
		for (E d : delete){
			csp.domains.get(var1).remove((Object)d);
		}
		return revised;
	}
	
	/**
	 * Computes the "neighbors" of a variable in a CSP. A variable is
	 * a neighbor if it is coupled to another variable by a constraint.
	 * @param csp The csp
	 * @param var The variable the neighbors of which are to be found.
	 * @return The neighbors of the given variable.
	 */
	private static Set<String> neighbors(CSP<?> csp, String var) {
		/* 
		 * Iterate over all constraints and check if var is contained
		 * in the constraint's scope. If so, all _other_ variables of
		 * the constraint's scope are neighbors.
		 */
		Set<String> nbrs = new HashSet<String>();
		for(Constraint c : csp.constraints){
			List<String> cScope = c.getScope();
			for(String v : cScope){ 
				if(v.equals(var)){
					if(cScope.indexOf(v) == 1){
						String cScopeI0 = cScope.get(0);
						if(!(cScopeI0).equals(v)){
							nbrs.add(cScopeI0);
						}
					}
					if(cScope.indexOf(v) == 0){
						String cScopeI1 = cScope.get(1);
						if(!(cScopeI1).equals(v)){
							nbrs.add(cScopeI1);
						}
					}
				}
			}
		}
		return nbrs;
	}
}
