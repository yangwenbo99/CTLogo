package ctlogo.data;

import java.util.HashMap;
import java.util.Map;

public class CTVariableManager {

	Map<String, CTValue> cTVariableCollection = new HashMap<String, CTValue>();

	public Boolean isDefined(String name) {
		return cTVariableCollection.containsKey(name);
	}

	public CTValue getValue(String name) {
		return cTVariableCollection.get(name);
	}

	public void setValue(String name, CTValue value) {
		cTVariableCollection.put(name, value);
	}

	// FIXME don't understand outer value structure here, is it referring to
	// global/local ariable?
	public CTValue getOuterValue(String name) {
		return null;
	}

	// FIXME don't understand outer value structure here, is it referring to
	// global/local ariable?
	public void setOuterValue(String name, CTValue value) {

	}

	// FIXME don't know why the function is here, maybe i have misunderstanding of
	// the structure?
//	public CTValue create(String type, Object value) throws CTSyntaxException {
//		if (type == "string" || type == "String")
//			return cTVariableCollection.new CTString((String) value);
//		if (type == "Boolean" || type == "boolean")
//			return new CTBoolean((Boolean) value);
//		if (type == "Integer" || type == "integer" || type == "int")
//			return new CTInteger((Integer) value);
//		if (type == "Double" || type == "double")
//			return new CTDouble((Double) value);
//		if (type == "undefined")
//			return new CTUndefined();
//		throw new CTSyntaxException("Please define correct type.");
//	}

	public CTValue delete(String name) {
		return cTVariableCollection.remove(name);
	}

}
