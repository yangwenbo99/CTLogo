package ctlogo.function;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.expression.Expression;

public class FunctionManager {
	private Map<String, Function> functions;
	private Set<String> nonOverridables;
	
	private static FunctionManager theInstance = new FunctionManager();
	
	public static FunctionManager getInstace() {
		return theInstance;
	}
	
	private FunctionManager() {
		this.functions = new HashMap<>();
		this.nonOverridables = new HashSet<>();
	}
	
    /**
     * Register a overrideable function.
     *
     * @param name name of the function
     * @param func body of the function
     * @throws IllegalArgumentException if function already registered.
     */
	public void register(String name, Function func) {
		if (functions.containsKey(name))
            throw new IllegalArgumentException(
                    "Registerring function twice not allowed.");
		functions.put(name, func);
	}
	
    /**
     * Register a function.
     *
     * @param name name of the function
     * @param func body of the function
     * @throws IllegalArgumentException if function already registered.
     */
	public void register(String name, Function func, boolean isOerridable) {
		if (functions.containsKey(name))
            throw new IllegalArgumentException(
                    "Registerring function twice not allowed.");
		functions.put(name, func);
		if (!isOerridable) 
			nonOverridables.add(name);
	}
	
	/**
	 * @param name name of the function
	 * @param func body of the function
	 * @return whether the function has been registered before. 
	 * @throws UnsupportedOperationException if the function is non-overridable
	 */
	public boolean reRegister(String name, Function func) {
		if (nonOverridables.contains(name))
			throw new UnsupportedOperationException(
					"Cannot override non-overridenable function");

		boolean alreadyExist = functions.containsKey(name);
		functions.put(name, func);
		return alreadyExist;
	}
	
	public boolean hasFunction(String name) {
		boolean alreadyExist = functions.containsKey(name);
		return alreadyExist;
	}

	/**
	 * @param name
	 * @param params
	 * @return the Expression object representing the function.
	 * @throws CTSyntaxException if incorrect number of parameter given
     * @throws NoSuchElementException if token not registered
	 */
	public Expression getFunctionExpression(
			String name, 
			List<Expression> params) throws CTSyntaxException {
		if (functions.containsKey(name))
			return functions.get(name).getFunctionExpression(params);
		else
			throw new NoSuchElementException(String.format(
					"Function %s not registered", name));

	}
}
