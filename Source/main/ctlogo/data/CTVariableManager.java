package ctlogo.data;

import ctlogo.exception.CTSyntaxException;

public abstract class CTVariableManager {

	public Boolean isDefined(String name) {
		return null;
	}

	public CTValue getValue(String name) {
		return null;
	}

	public void setValue(String name, CTValue value) {

	}

	public CTValue getOuterValue(String name) {
		return null;
	}

	public void setOuterValue(String name, CTValue value) {

	}

	public CTValue create(String type, Object value) throws CTSyntaxException {
		if (type == "string" || type == "String")
			return new CTString((String) value);
		if (type == "Boolean" || type == "boolean")
			return new CTBoolean((Boolean) value);
		if (type == "Integer" || type == "integer" || type == "int")
			return new CTInteger((Integer) value);
		if (type == "Double" || type == "double")
			return new CTDouble((Double) value);
		if (type == "undefined")
			return new CTUndefined();
		throw new CTSyntaxException("Please define correct type.");
	}

	public void delete(String name) {
		
	}

}
