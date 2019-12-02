package ctlogo.data;

import ctlogo.exception.CTVariableNotDefinedException;

/**
 * Variable manager used in context.
 *
 * <p>A VariableManager is defined for each context at runtime, meaning that
 * whenever a context is created, a new VariableManager is created. </p>
 * 
 * @author Paul Yang
 *
 */
public interface VariableManager {
	/**
	 * Check whether the variable is defined in context.
	 * @param name
	 * @return whether the variable is defined in context.
	 */
	boolean isDefined(String name);

	/**
	 * Check whether the variable is defined locally.
	 *
	 * @param name
	 * @return whether the variable is defined locally.
	 */
	boolean isDefinedLocally(String name);

	/**
	 * Get value of an valuable.
	 * If this {@code VariableManager} has enclosed some other 
	 * VariableManager, this method shall return the local variable if 
	 * found, otherwise, return the variable from higher level.
	 *
	 * @param name
	 * @throws CTVariableNotDefinedException if the variable name is not defined.
	 * @return the variable
	 */
	CTValue getValue(String name);

	/**
	 * Try to get a variable's value.
	 * <p>If this {@code VariableManager} has enclosed some other 
	 * VariableManager, this method shall return the local variable if 
	 * found, otherwise, return the variable from higher level.</p>
	 *
	 * @param name
	 * @return the variable is it is already defined, {@code null} 
     *         otherwise.
	 * 
	 */
	CTValue tryGetValue(String name);

	/**
	 * Set value of variable. 
	 *
	 * <p>Remark: if a variable is to be hidden, then it is not considered as 
	 * replaced. </p>
	 *
	 * @param name the name of the variable to set
	 * @param value the value to set 
	 * 
	 * @return the variable be replaced. If there is no variable being 
	 *         replace, then {@code null} shall be returned. 
     * @throws IllegalArgumentException if trying to set the variable to null (
     *                                  (in Java)
	 * 
	 */
	CTValue setVariable(String name, CTValue value);

	/**
	 * Set value of variable. 
	 *
	 * <p>Remark: if a variable is to be hidden, then it is not considered as 
	 * replaced. </p>
	 *
	 * @param name the name of the variable to set
	 * @param value the value to set 
	 * 
	 * @return the variable be replaced. If there is no variable being 
	 *         replace, then {@code null} shall be returned. 
     * @throws IllegalArgumentException if trying to set the variable to null (
     *                                  (in Java)
	 * 
	 */
	CTValue setLocalVariable(String name, CTValue value);
}
