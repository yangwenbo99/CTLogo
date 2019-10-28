package ctlogo.data;

import ctlogo.exception.CTVariableNotDefinedException;

/**
 * Variable manager used in context
 * 
 * @author Paul Yang
 *
 */
public interface VariableManager {
	/**
	 * @param name
	 * @return whether the variable is defined in context.
	 */
	boolean isDefined(String name);

	/**
	 * @param name
	 * @return whether the variable is defined locally.
	 */
	boolean isDefinedLocally(String name);

	/**
	 * @param name
	 * @throws CTVariableNotDefinedException if the variable name is not defined.
	 * @return the variable
	 * 
	 * If this {@code: VariableManager} has enclosed some other 
	 * VariableManager, this method shall return the local variable if 
	 * found, otherwise, return the variable from higher level.
	 */
	CTVariable getVariable(String name);

	/**
	 * Create a variable whose value is undefined. 
	 * 
	 * @param name
	 * @return the original 
	 * 
	 * This shall be equivalent to 
	 * {@code: setVariable(name, new CTVariable())}.
	 */

	CTVariable createVariable(String name);

	/**
	 * @param name
	 * @param variable
	 * 
	 * @return the variable be replaced. If there is no variable being 
	 *         replace, then {@code: null} shall be returned. 
	 * 
	 * Remark: if a variable is to be hidden, then it is not considered as 
	 * replaced. 
	 * 
	 */
	CTVariable setVariable(String name, CTVariable variable);
}
