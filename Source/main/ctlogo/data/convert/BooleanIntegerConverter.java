package ctlogo.data.convert;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTInteger;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;

public class BooleanIntegerConverter extends CTValueConverter {
	
	BooleanIntegerConverter () {
		super(CTBoolean.getTypeMarkerStatic(), 
				CTInteger.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
		if (from.equals((Object) CTBoolean.TRUE))
			return CTInteger.ONE;
		else
			return CTInteger.ZERO;
	}

	@Override
	protected boolean isConvertible(CTValue from) {
		return true;
	}
	
}