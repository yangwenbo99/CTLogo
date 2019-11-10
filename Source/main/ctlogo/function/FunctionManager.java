package ctlogo.function;

import java.util.HashMap;
import java.util.Map;

public class FunctionManager {

	private Map<String, Function> functionCollection = new HashMap<String, Function>();
	private static FunctionManager instance;

	private FunctionManager() {
	}

	private static FunctionManager getInstance() {
		if (instance == null)
			instance = new FunctionManager();
		return instance;
	}

	private Map<String, Function> getFunctionCollection() {
		return this.functionCollection;
	}

	public static Function add(String name, Function command) {
		FunctionManager ins = FunctionManager.getInstance();
		return ins.getFunctionCollection().put(name, command);
	}

	public static Function delete(String name) {
		FunctionManager ins = FunctionManager.getInstance();
		return ins.getFunctionCollection().remove(name);
	}

	public static Boolean hasFunction(String name) {
		FunctionManager ins = FunctionManager.getInstance();
		return ins.getFunctionCollection().containsKey(name);
	}

	public static Function getFunction(String name) {
		FunctionManager ins = FunctionManager.getInstance();
		return ins.getFunctionCollection().get(name);
	}
}
