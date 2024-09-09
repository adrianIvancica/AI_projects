import java.util.HashSet;
import java.util.Set;
/**
 * Implements the backtracking search with forward checking. 
 */
public class ForwardCheckingCSPSolver extends BacktrackingCSPSolver {
	
	/**
	 * Implements the actual forward checking. Infers the values to be deleted
	 * from the domains of some variables based on the given variable and value.
	 */
	@Override
	protected <E> Inference<E> inference(CSP<E> csp, Assignment<E> assignment, String var, E value) {
		/* 
		 * Implement the forward checking. You may want to iterate over all
		 * constraints to identify those who involve the given variable. Then,
		 * iterate over the variables of the scope of the constraint and check
		 * if the variable is not yet assigned. If it is not assigned, check all
		 * the values of the domain of that variable, and identify those values
		 * that are inconsistent with the constraint (therefore, you might temporarily
		 * modify the assignment with the value to test, and restore the assignment
		 * later on). The inconsistent values should be added to the inference that
		 * will be returned. If no value was found at all, then return failure (null in this
		 * case).
		 */
		Inference<E> Inf = new Inference<E>();
		Set<E> s = new HashSet<E>();
		for(Constraint c : csp.constraints){
			for(String v : c.getScope()){ 
				if(v.equals(var) && assignment.get(v) == null){
					for(E i : csp.domains.get(v)){
						assignment.replace(v, i);
						if(!csp.isConsistent(assignment)){
							s.add(i);
						}
						assignment.replace(v, null);
					}
					if (s.size() == 0){
						return null;
					}
					Inf.put(v, s);
				}
			}
		}
		return Inf;
	}
}
