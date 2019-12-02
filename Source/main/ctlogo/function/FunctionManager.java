package ctlogo.function;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.expression.Expression;

/**
 * @author Paul Yang
 * 
 * Please note that all function names are case-insensitive. 
 *
 */
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
		register(name, func, true);
	}
	
    /**
     * Register a function.
     *
     * @param name name of the function
     * @param func body of the function
     * @throws IllegalArgumentException if function already registered.
     */
	public void register(String name, Function func, boolean isOerridable) {
		if (functions.containsKey(name.toUpperCase()))
            throw new IllegalArgumentException(
                    "Registerring function twice not allowed.");
		functions.put(name.toUpperCase(), func);
		if (!isOerridable) 
			nonOverridables.add(name.toUpperCase());
	}
	
	/**
	 * @param name name of the function
	 * @param func body of the function
	 * @return whether the function has been registered before. 
	 * @throws UnsupportedOperationException if the function is non-overridable
	 */
	public boolean reRegister(String name, Function func) {
		if (nonOverridables.contains(name.toUpperCase()))
			throw new UnsupportedOperationException(
					"Cannot override non-overridenable function");

		boolean alreadyExist = functions.containsKey(name.toUpperCase());
		functions.put(name.toUpperCase(), func);
		return alreadyExist;
	}
	
	public boolean hasFunction(String name) {
		boolean alreadyExist = functions.containsKey(name.toUpperCase());
		return alreadyExist;
	}

	/**
	 * Get an expression representing a function
	 * 
	 * @param name
	 * @param params
	 * @return the Expression object representing the function.
	 * @throws CTSyntaxException if incorrect number of parameter given
     * @throws NoSuchElementException if token not registered
	 */
	public Expression getFunctionExpression(
			String name, 
			List<Expression> params) throws CTSyntaxException {
		if (hasFunction(name))
			return functions.get(name.toUpperCase()).getFunctionExpression(params);
		else
			throw new NoSuchElementException(String.format(
					"Function %s not registered", name.toUpperCase()));
	}

    public int getDefaultParameterNum(String name) {
        if (hasFunction(name))
            return functions.get(name.toUpperCase()).getDefaultParameterNum();
        else
            throw new NoSuchElementException(String.format(
                    "Function %s not registered", name.toUpperCase()));
    }

    public int getMinParameterNum(String name) {
        if (hasFunction(name))
            return functions.get(name.toUpperCase()).getMinParameterNum();
        else
            throw new NoSuchElementException(String.format(
                    "Function %s not registered", name.toUpperCase()));
    }

    public int getMaxParameterNum(String name) {
        if (hasFunction(name))
            return functions.get(name.toUpperCase()).getMaxParameterNum();
        else
            throw new NoSuchElementException(String.format(
                    "Function %s not registered", name.toUpperCase()));
    }
	
	static {
		BuildInFunctionRegistrator.registerAll();
	}
}
