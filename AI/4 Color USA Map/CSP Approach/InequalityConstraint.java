import java.util.List;
import java.util.ArrayList;

/**
 * Implements the inequality constraint of two variables. 
 */
public class InequalityConstraint implements Constraint {
	private String value1, value2;

	public InequalityConstraint(String value1, String value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	@Override
	public List<String> getScope() {
		/* 
		 * return a list containing value1 and value2
		 */
		ArrayList<String> values = new ArrayList<String>();
		values.add(value1);
		values.add(value2);
		return values;
	}

	@Override
	public <E> boolean isConsistent(Assignment<E> assignment) {
		/* 
		 * Check if the assignment is consistent with the constraint,
		 * or if it violates it. It is consistent if the assigned values
		 * of the two variables differ. Keep in mind, that if the assignment
		 * does not contain an assigned value for both variables, the
		 * constraint is not violated, and therefore consistent!
		 */
		E val1 = assignment.get(value1);
		E val2 = assignment.get(value2);
		if ((val1 != val2) || (val1 == null && val2 == null)){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return value1 + " != " + value2;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof InequalityConstraint)) {
			return false;
		}
		InequalityConstraint other = (InequalityConstraint)o;
		return value1.equals(other.value1) && value2.equals(other.value2);
	}
}
