package ctlogo.data;

public class TypeConversionDirection {
	
	private TypeMarker from;
	private TypeMarker to;

	protected TypeMarker getFrom() {
		return from;
	}

	protected TypeMarker getTo() {
		return to;
	}

	public TypeConversionDirection(TypeMarker from, TypeMarker to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!other.getClass().equals(this.getClass()))
			return false;
		
		TypeConversionDirection otherTcd = (TypeConversionDirection) other;
		
		return this.from == otherTcd.from &&
				this.to == otherTcd.to;
	}
	
	@Override 
	public int hashCode() {
		return from.hashCode() * 7 + to.hashCode() * 13;
	}

    @Override 
    public String toString() {
        return String.format("<ctlogo.data.TypeConversionDirection from %s to %s>",
                from, to);
    }
}
