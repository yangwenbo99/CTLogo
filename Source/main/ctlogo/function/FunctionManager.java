package ctlogo.function;

import java.util.HashMap;
import java.util.Map;

public class FunctionManager {

	Map<String, Function> functionCollection= new HashMap<String, Function>();
	
	public Function add(String name, Function command) {
		return functionCollection.put(name, command);
	}

	public Function delete(String name) {
		return functionCollection.remove(name);
	}

	public Boolean hasFunction(String name) {
		return functionCollection.containsKey(name);
	}

	public Function getFunction(String name) {
		return functionCollection.get(name);
	}
}
