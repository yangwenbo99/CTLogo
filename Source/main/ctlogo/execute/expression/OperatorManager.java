package ctlogo.execute.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class OperatorManager {
	
	private Map<String, Class<? extends AbstractBinaryOperator>> 
		binaryOperators;
	private Map<String, Class<? extends AbstractUnaryOperator>> 
		unaryOperators;
	
	private final static OperatorManager theInstance = new OperatorManager();
	
	public static OperatorManager getInstance() {
		return theInstance;
	}

	private OperatorManager() {
		binaryOperators = new HashMap<>();
		unaryOperators = new HashMap<>();
	}
	
	/**
	 * 
	 * @param token
	 * @param cls
	 * @throws IllegalArgumentException if token already registered. 
	 */
	public void registerBinaryOperator(
			String token, Class<? extends AbstractBinaryOperator> cls) 
					throws IllegalArgumentException {
		if (binaryOperators.containsKey(token))
			throw new IllegalArgumentException(
					"Registerring an operator twice not allowed.");
		
		binaryOperators.put(token, cls);
	}

	/**
	 * 
	 * @param token
	 * @return 
	 * @throws NoSuchElementException if token not registered
	 */
	public Class<? extends AbstractBinaryOperator> 
	getBinaryOperationExpression(String token) {
		if (binaryOperators.containsKey(token))
			return binaryOperators.get(token);
		else
			throw new NoSuchElementException();
	}

	/**
	 * 
	 * @param token
	 * @param cls
	 * @throws IllegalArgumentException if token already registered. 
	 */
	public void registerUnaryOperator(
			String token, Class<? extends AbstractUnaryOperator> cls) 
					throws IllegalArgumentException {
		if (binaryOperators.containsKey(token))
			throw new IllegalArgumentException(
					"Registerring an operator twice not allowed.");
		
		unaryOperators.put(token, cls);
	}

	/**
	 * 
	 * @param token
	 * @return 
	 * @throws NoSuchElementException if token not registered
	 */
	public Class<? extends AbstractUnaryOperator> 
	getUnaryOperationExpression(String token) {
		if (unaryOperators.containsKey(token))
			return unaryOperators.get(token);
		else
			throw new NoSuchElementException();
	}

}
