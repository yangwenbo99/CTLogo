package ctlogo.data;

public class LocalVariableManager extends AbstractVariableManager implements VariableManager {
	
	private VariableManager outerManager;

	public LocalVariableManager(VariableManager outerManager) {
		super();
		this.outerManager = outerManager;
	}

	@Override
	public boolean isDefined(String name) {
		return isDefinedLocally(name) || outerManager.isDefined(name);
	}

	@Override
	public CTValue getValue(String name) {
		if (isDefinedLocally(name))
			return tryGetLocalValue(name);
		else
			return outerManager.getValue(name);
	}

	@Override
	public CTValue tryGetValue(String name) {
		CTValue res;
		res = tryGetLocalValue(name);
		if (res == null) {
			res = outerManager.tryGetValue(name);
		}
		return res;
	}

	@Override
	public CTValue setVariable(String name, CTValue value) {
		if (isDefinedLocally(name))
			return setLocalVariable(name, value);
		else
			return outerManager.setVariable(name, value);
	}

}
