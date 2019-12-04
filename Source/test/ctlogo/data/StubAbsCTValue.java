package ctlogo.data;

class StubAbsCTValue extends AbstractCTValue {
	private static TypeMarker tm = new TypeMarker("Stub1");
	
	private CTValue convertedTo;
	private boolean isConvertable;

	public StubAbsCTValue(CTValue convertedTo, boolean isConvertable) {
		super();
		this.convertedTo = convertedTo;
		this.isConvertable = isConvertable;
	}

	@Override
	public TypeMarker getTypeMarker() {
		return tm;
	}

	@Override
	public boolean isConvertibleTo(TypeMarker newType) {
		return isConvertable;
    }

	@Override
	public CTValue convertTo(TypeMarker newType) {
        return convertedTo;
	}

	@Override
	public CTBoolean equals(CTValue another) {
		return this == another ?
				CTBoolean.TRUE : 
					CTBoolean.FALSE;
	}
	
	@Override
	public CTBoolean exactlyEquals(CTValue another) {
		return this == another ?
				CTBoolean.TRUE : 
					CTBoolean.FALSE;
	}

	@Override
	public int compareTo(CTValue another) {
		return 0;
	}

	@Override
	public boolean isCompareableTo(CTValue another) {
		return false;
	}
}