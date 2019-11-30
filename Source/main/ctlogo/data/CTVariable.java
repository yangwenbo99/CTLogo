package ctlogo.data;

public class CTVariable {
	private CTValue value;
	
	public CTVariable() {
		this(CTUndefined.UNDEFINED);
	}

	public CTVariable(CTValue value) {
		super();
		this.value = value;
	}

	public CTValue getValue() {
		return value;
	}

	public void setValue(CTValue value) {
		this.value = value;
	}

}
