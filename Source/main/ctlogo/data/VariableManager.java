package ctlogo.data;

import ctlogo.exception.CTVariableNotDefinedException;

/**
 * Variable manager used in context
 * 
 * @author Paul Yang
 *
 * A VariableManager is defined for each context at runtime, meaning that
 * whenever a context is created, a new VariableManager is created. 
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
	 * If this {@code VariableManager} has enclosed some other 
	 * VariableManager, this method shall return the local variable if 
	 * found, otherwise, return the variable from higher level.
	 */
	CTValue getValue(String name);

	/**
	 * @param name
	 * @return the variable is it is already defined, {@code null} 
     *         otherwise.
	 * 
	 * If this {@code VariableManager} has enclosed some other 
	 * VariableManager, this method shall return the local variable if 
	 * found, otherwise, return the variable from higher level.
	 */
	CTValue tryGetValue(String name);

	/**
	 * @param name the name of the variable to set
	 * @param value the value to set 
	 * 
	 * @return the variable be replaced. If there is no variable being 
	 *         replace, then {@code null} shall be returned. 
     * @throws IllegalArgumentException if trying to set the variable to null (
     *                                  (in Java)
	 * 
	 * Remark: if a variable is to be hidden, then it is not considered as 
	 * replaced. 
	 * 
	 */
	CTValue setVariable(String name, CTValue value);

	/**
	 * @param name the name of the variable to set
	 * @param value the value to set 
	 * 
	 * @return the variable be replaced. If there is no variable being 
	 *         replace, then {@code null} shall be returned. 
     * @throws IllegalArgumentException if trying to set the variable to null (
     *                                  (in Java)
	 * 
	 * Remark: if a variable is to be hidden, then it is not considered as 
	 * replaced. 
	 * 
	 */
	CTValue setLocalVariable(String name, CTValue value);
}
